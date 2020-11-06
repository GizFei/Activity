package com.giz.lifecycle

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.giz.lifecycle.lifecycle.PrintLifecycleActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityTestSuite {

    @Test
    fun createActivity() {
        val scenario = launchActivity<PrintLifecycleActivity>()
    }

}