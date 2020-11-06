package com.giz.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.giz.fragment.example.FragmentLayoutActivity
import com.giz.fragment.lifecycle.FragmentLifecycleMainActivity
import com.giz.fragment.transaction.ManageBackStackActivity
import com.giz.utility.goto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun click(view: View) {
        (view.tag as? String)?.let { goto(Class.forName(it)) }
    }
}