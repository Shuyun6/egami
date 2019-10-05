package com.shuyun.egami.module.apod

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.shuyun.egami.R

import com.shuyun.egami.module.base.BaseFragment
import com.shuyun.egami.utils.GlideUtil
import kotlinx.android.synthetic.main.apod_fragment.*

class ApodFragment private constructor() : BaseFragment<ApodContract.Presenter>(),
    ApodContract.View {

    companion object {
        fun newInstance(): ApodFragment {
            return ApodFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.apod_fragment, null)
    }

    override fun showImage(url: String) {
        Glide.with(this)
            .load(url)
            .listener(GlideUtil.defaultRequestListener())
            .into(ivImage)
    }

    override fun setTitle(text: String) {
        tvTitle.text = text
    }

    override fun setContent(text: String) {
        tvContent.text = text
    }

    override fun setPresenter(presenter: ApodContract.Presenter) {
        mPresenter = presenter
    }

}
