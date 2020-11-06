package com.giz.fragment.transition

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giz.fragment.R
import com.giz.fragment.lifecycle.BasePrintLifecycleFragment

class SharedElementFragmentBBB : BasePrintLifecycleFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置共享元素进入动画，必须要加
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.share_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_shared_element_bbb, container, false)
    }
}