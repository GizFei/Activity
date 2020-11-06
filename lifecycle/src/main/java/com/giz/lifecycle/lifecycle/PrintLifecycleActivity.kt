package com.giz.lifecycle.lifecycle

import android.os.Bundle
import com.giz.lifecycle.R
import com.giz.utility.goto
import kotlinx.android.synthetic.main.activity_print_lifecycle.*

/**
 * 打印Activity生命周期回调的活动
 */
class PrintLifecycleActivity : BasePrintLifecycleActivity() {

    private val lifecycleObserverComponent = PrintLifecycleObserverComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print_lifecycle)

        // 绑定生命周期感知型组件
        lifecycle.addObserver(lifecycleObserverComponent)
        tv_enter_state.setOnClickListener { goto(InstanceStateActivity::class.java) }
    }
}
