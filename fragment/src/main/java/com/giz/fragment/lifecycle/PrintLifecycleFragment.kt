package com.giz.fragment.lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giz.fragment.R
import kotlinx.android.synthetic.main.fragment_print_lifecycle.*


class PrintLifecycleFragment : BasePrintLifecycleFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = layoutInflater.inflate(R.layout.fragment_print_lifecycle, container, false)

        return view
    }

    fun setInfo(info: String) {
        tv_info?.text = info
    }
}