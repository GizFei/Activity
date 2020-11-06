package com.giz.fragment.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giz.fragment.R
import com.giz.utility.goto
import kotlinx.android.synthetic.main.activity_fragment_lifecycle_main.*

class FragmentLifecycleMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_lifecycle_main)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.title = "打印Fragment生命周期"
        btn_print_lifecycle.setOnClickListener { goto(PrintLifecycleFragmentActivity::class.java) }
    }
}
