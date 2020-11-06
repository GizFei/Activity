package com.giz.fragment.transition

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giz.fragment.R
import com.giz.fragment.lifecycle.BasePrintLifecycleFragment
import kotlinx.android.synthetic.main.fragment_transition_a.view.*

class TransitionByAnimFragmentAAA : BasePrintLifecycleFragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val index = arguments?.getInt("index") ?: 0

        return inflater.inflate(R.layout.fragment_transition_a, container, false).apply {
            textView.text = "AAA---TransitionFragment-$index"
        }
    }
}