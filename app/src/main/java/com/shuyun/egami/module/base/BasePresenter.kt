package com.shuyun.egami.module.base

import android.app.Activity
import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.functions.Consumer

abstract class BasePresenter<V>: LifecycleObserver, IPresenter {

    var mContext: Context? = null
    var mView: V? = null

    /**
     * Use functional parameter to ensure the operation could work on UI thread
     */
    fun getView(consumer: Consumer<V?>) {
        (mContext as Activity?)?.runOnUiThread {
            consumer.accept(mView)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
    }

}