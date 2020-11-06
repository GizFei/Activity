package com.giz.fragment.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BasePrintLifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLC("onCreate--Bundle: $savedInstanceState")
    }

    override fun onRestart() {
        super.onRestart()
        logLC("onRestart")
    }

    override fun onStart() {
        super.onStart()
        logLC("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLC("onResume")
    }

    override fun onPause() {
        logLC("onPause")
        super.onPause()
    }

    override fun onStop() {
        logLC("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        logLC("onDestroy")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logLC("onSaveInstanceState--Bundle: $outState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logLC("onRestoreInstanceState--Bundle: $savedInstanceState")
    }


    private fun logLC(msg: String) {
        Log.d("PrintLifecycleActivity", "${this::class.simpleName}生命周期回调：$msg")
    }
}