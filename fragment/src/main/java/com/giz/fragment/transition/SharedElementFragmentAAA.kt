package com.giz.fragment.transition

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giz.fragment.R
import com.giz.fragment.lifecycle.BasePrintLifecycleFragment
import kotlinx.android.synthetic.main.fragment_shared_element_aaa.*

class SharedElementFragmentAAA : BasePrintLifecycleFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 其他图片的退出动画
        exitTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.non_share_image_fade)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_shared_element_aaa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imageView.setOnClickListener {
            fragmentManager?.run {
                beginTransaction()
                    // 添加共享元素动画
                    .addSharedElement(imageView, resources.getString(R.string.img_transition_name))
                    .replace(android.R.id.content, SharedElementFragmentBBB())
                    .addToBackStack(null)
                    .commit()
            }
        }

    }
}