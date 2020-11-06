package com.giz.fragment.transaction

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giz.fragment.R
import com.giz.fragment.lifecycle.BasePrintLifecycleFragment
import kotlinx.android.synthetic.main.fragment_manage_back_stack.view.*

class BBBManageBackStackFragment : BasePrintLifecycleFragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val index = arguments?.getInt("index") ?: 0

        return inflater.inflate(R.layout.fragment_manage_back_stack, container, false).apply {
            textView.text = "BBB----ManageBackStackFragment-$index"
        }
    }

}