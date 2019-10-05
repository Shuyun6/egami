package com.shuyun.egami.module.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import android.view.WindowManager

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fullScreen()
    }

    fun add2LifeCycle(observer: LifecycleObserver) {
        lifecycle.addObserver(observer)
    }

    private fun fullScreen() {
        val params = window.attributes
        params.flags = params.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
        window.attributes = params
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

}