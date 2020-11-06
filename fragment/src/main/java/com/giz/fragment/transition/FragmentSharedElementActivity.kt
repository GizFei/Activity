package com.giz.fragment.transition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FragmentSharedElementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, SharedElementFragmentAAA())
            .commit()
    }

}