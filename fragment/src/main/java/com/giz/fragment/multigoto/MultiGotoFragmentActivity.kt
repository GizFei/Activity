package com.giz.fragment.multigoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.giz.fragment.R
import com.giz.utility.log

class MultiGotoFragmentActivity : AppCompatActivity() {

    private lateinit var mMultiGotoFragment: MultiGotoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_goto_fragment)

        initFragment()
    }

    private fun initFragment() {
        mMultiGotoFragment = MultiGotoFragment()
        supportFragmentManager.beginTransaction()
            .add(FRAGMENT_CONTAINER, mMultiGotoFragment)
            .commit()
        supportFragmentManager.addOnBackStackChangedListener {
            if (mMultiGotoFragment.isVisible) {
                supportActionBar?.title = "Multi Goto Home"
            }
        }
    }

    fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun gotoFragment(tag: String) {
        val fragment = supportFragmentManager.findFragmentByTag(tag) ?: when(tag) {
            FragmentOne.TAG -> FragmentOne()
            FragmentTwo.TAG -> FragmentTwo()
            FragmentThree.TAG -> FragmentThree()
            else -> null
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction().apply {
                setCustomAnimations(
                    R.anim.slide_in_from_right,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out_to_right
                )
                hide(mMultiGotoFragment)
                log("$tag 是否已添加：${fragment.isAdded}")
                if (fragment.isAdded) {
                    show(fragment)
                } else {
                    add(FRAGMENT_CONTAINER, fragment, tag)
                }
                addToBackStack(tag)
                commit()
            }
        }
    }

    companion object {
        const val FRAGMENT_CONTAINER = R.id.fragment_container
    }
}