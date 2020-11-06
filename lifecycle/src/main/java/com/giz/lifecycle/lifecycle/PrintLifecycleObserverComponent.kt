package com.giz.lifecycle.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 打印生命周期回调的生命周期感知型组件
 */
class PrintLifecycleObserverComponent : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun doOnCreate() {
        logL("onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun doOnStart() {
        logL("onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun doOnResume() {
        logL("onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun doOnPause() {
        logL("onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun doOnStop() {
        logL("onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun doOnDestroy() {
        logL("onDestroy")
    }


    private fun logL(event: String) {
        Log.d("PrintLifecycleObserver", "感知到Activity的生命周期[$event]，执行动作")
    }
}