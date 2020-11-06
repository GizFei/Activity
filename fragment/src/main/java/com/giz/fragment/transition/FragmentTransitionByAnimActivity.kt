package com.giz.fragment.transition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giz.fragment.R
import com.giz.utility.log
import kotlinx.android.synthetic.main.activity_fragment_transitions.*

class FragmentTransitionByAnimActivity : AppCompatActivity() {

    companion object {
        private const val TAG_FRAGMENT_A = "FragmentA"
        private const val TAG_FRAGMENT_B= "FragmentB"
    }

    private var isFragmentBAdded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transitions)

        initFragment()
        initViews()
    }

    private fun initFragment() {
        val fragmentA = TransitionByAnimFragmentAAA().apply { arguments = Bundle().apply { putInt("index", 1) } }
        supportFragmentManager.apply {
            // 添加FragmentA
            beginTransaction()
                .add(R.id.fragment_container, fragmentA, TAG_FRAGMENT_A)
                .commit()
            // 添加监听器
            addOnBackStackChangedListener {
                // 添加Fragment时，在onResume之后回调。销毁Fragment时，在onDestroy之前回调
                // 判断FragmentB是否已添加
                log("监听：OnBackStackChangedListener")
                isFragmentBAdded = !(findFragmentByTag(TAG_FRAGMENT_A)?.isVisible ?: true)
            }
        }
    }

    private fun initViews() {
        btn_add_fragment.setOnClickListener {
            if (!isFragmentBAdded) {
                // 添加FragmentB
                val fragmentB = TransitionByAnimFragmentBBB().apply { arguments = Bundle().apply { putInt("index", 2) } }
                supportFragmentManager.beginTransaction()
                    // 在替换Fragment之前添加动画
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_to_right
                    )
                    .replace(R.id.fragment_container, fragmentB, TAG_FRAGMENT_B)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }



}