package com.shuyun.egami.utils

import android.util.Log

import com.shuyun.egami.BuildConfig

object Logg {

    private val defaultTag: String = "Logg"

    fun e(msg: String) {
        Log.e(invokeMethod(), msg)
    }

    fun i(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.i(invokeMethod(), msg)
        }
    }

    fun d(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(invokeMethod(), msg)
        }
    }

    private fun invokeMethod(): String {
        val stacks = Thread.currentThread().stackTrace
        return if (stacks.size > 4) {
            stacks[4].className + " - " + stacks[4].methodName
        } else {
            defaultTag
        }
    }

}
