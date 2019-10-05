package com.shuyun.egami.module.apod

import com.shuyun.egami.module.base.IPresenter
import com.shuyun.egami.module.base.IView

interface ApodContract {

    interface View : IView<Presenter> {

        fun showImage(url: String)

        fun setTitle(text: String)

        fun setContent(text: String)

    }

    interface Presenter : IPresenter


}
