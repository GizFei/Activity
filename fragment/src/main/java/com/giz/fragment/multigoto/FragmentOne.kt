package com.giz.fragment.multigoto

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giz.fragment.R
import com.giz.fragment.lifecycle.BasePrintLifecycleFragment

class FragmentOne : BasePrintLifecycleFragment() {

    private lateinit var mActivity: MultiGotoFragmentActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as MultiGotoFragmentActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_transition_b, container, false)
    }

    override fun onResume() {
        super.onResume()
        mActivity.setActionBarTitle("FragmentOne")
    }

    companion object {
        const val TAG = "FragmentOne"
    }
}