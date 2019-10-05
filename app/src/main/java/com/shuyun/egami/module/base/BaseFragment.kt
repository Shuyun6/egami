package com.shuyun.egami.module.base

import androidx.fragment.app.Fragment

abstract class BaseFragment<P>: Fragment() {

    var mPresenter: P? = null

}