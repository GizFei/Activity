package com.giz.fragment.multigoto

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giz.fragment.R
import com.giz.fragment.lifecycle.BasePrintLifecycleFragment
import kotlinx.android.synthetic.main.fragment_multi_goto.*

class MultiGotoFragment : BasePrintLifecycleFragment() {

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
        return inflater.inflate(R.layout.fragment_multi_goto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_fragment_one.setOnClickListener { mActivity.gotoFragment(FragmentOne.TAG) }
        btn_fragment_two.setOnClickListener { mActivity.gotoFragment(FragmentTwo.TAG) }
        btn_fragment_three.setOnClickListener { mActivity.gotoFragment(FragmentThree.TAG) }
    }

}