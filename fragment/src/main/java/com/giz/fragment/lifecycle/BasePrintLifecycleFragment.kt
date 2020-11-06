package com.giz.fragment.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

abstract class BasePrintLifecycleFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logL("onAttach-${context::class.simpleName}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logL("onCreate")
    }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logL("onCreateView")
        return null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logL("onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        logL("onStart")
    }

    override fun onResume() {
        super.onResume()
        logL("onResume")
    }

    override fun onPause() {
        logL("onPause")
        super.onPause()
    }

    override fun onStop() {
        logL("onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        logL("onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        logL("onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        logL("onDetach")
        super.onDetach()
    }

    
    private fun logL(event: String) {
        Log.d("PrintLifecycleFragment", "${this::class.simpleName}生命周期回调：$event")
    }
    
}