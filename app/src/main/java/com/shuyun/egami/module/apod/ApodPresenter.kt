package com.shuyun.egami.module.apod

import android.content.Context

import com.shuyun.egami.module.base.BasePresenter
import com.shuyun.egami.net.NasaServiceUtil
import com.shuyun.egami.utils.DateTimeUtil
import com.shuyun.egami.utils.Logg
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class ApodPresenter() : BasePresenter<ApodContract.View>(),
    ApodContract.Presenter {

    constructor(context: Context, view: ApodContract.View) : this() {
        this.mContext = context
        this.mView = view
        this.mView?.setPresenter(this)
    }

    override fun onCreate() {}

    override fun onResume() {
        super.onResume()
        val d = NasaServiceUtil.getInstance().getApodData(DateTimeUtil.yymmddDate, false)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .retry(2)
            .subscribe({
                Logg.d(it.toString())
                getView(Consumer { view ->
                    view?.showImage(it.url)
                    view?.setTitle(it.title)
                    view?.setContent(it.explanation)
                })
            }, { t: Throwable? -> Logg.e(t.toString()) })

    }
}
