package com.giz.fragment.transition

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giz.fragment.R
import com.giz.fragment.lifecycle.BasePrintLifecycleFragment
import kotlinx.android.synthetic.main.fragment_transition_b.view.*

class TransitionFragmentBBB : BasePrintLifecycleFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 过渡动画
        enterTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.slide_right)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val index = arguments?.getInt("index") ?: 0

        return inflater.inflate(R.layout.fragment_transition_b, container, false).apply {
            imageView.setImageResource(R.drawable.bg4)
            textView.text = "BBB---TransitionFragment-$index"
        }
    }
}