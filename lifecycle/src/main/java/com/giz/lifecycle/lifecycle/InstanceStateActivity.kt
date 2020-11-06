package com.giz.lifecycle.lifecycle

import android.os.Bundle
import com.giz.lifecycle.R

class InstanceStateActivity : BasePrintLifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instance_state)

        supportActionBar?.title = "InstanceState测试"
    }
}