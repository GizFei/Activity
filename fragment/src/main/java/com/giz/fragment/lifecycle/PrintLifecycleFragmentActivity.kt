package com.giz.fragment.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giz.fragment.R

class PrintLifecycleFragmentActivity : BasePrintLifecycleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print_lifecycle_fragment)

        with(supportFragmentManager) {
            (findFragmentById(R.id.fragment_print_lifecycle)
                    as PrintLifecycleFragment).setInfo("Activity在布局文件中添加Fragment")

            val fragment = PrintLifecycleFragment()
            beginTransaction()
                .add(R.id.fragment_containter1, fragment)
                .runOnCommit { fragment.setInfo("在Activity的onCreate中添加Fragment") }
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()

        val fragment = PrintLifecycleFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_containter2, fragment)
            .runOnCommit {
                // 在这里调用fragment的方法设置TextView的文本
                fragment.setInfo("在Activity的onResume中添加Fragment")
            }
            .commit()
    }
}