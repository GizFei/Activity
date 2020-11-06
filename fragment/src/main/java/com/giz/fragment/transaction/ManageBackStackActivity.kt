package com.giz.fragment.transaction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giz.fragment.R
import kotlinx.android.synthetic.main.activity_manage_back_state.*

class ManageBackStackActivity : AppCompatActivity() {

    private var index: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_back_state)

        // 添加FragmentA
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, AAAManageBackStackFragment().apply { arguments = Bundle().apply { putInt("index", index++) } })
            .commit()
        initView()
    }

    private fun initView() {
        supportActionBar?.title = "管理Fragment返回栈"
        btn_add_bbb.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BBBManageBackStackFragment().apply { arguments = Bundle().apply { putInt("index", index++) }})
                // 将事务添加到返回栈中，用户可以通过返回键回退
                .addToBackStack(null)
                .commit()
        }
    }


}