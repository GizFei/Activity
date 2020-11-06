package com.giz.interaction.receive

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giz.interaction.R
import kotlinx.android.synthetic.main.activity_receive_implicit_intent.*

class ReceiveImplicitIntentActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_implicit_intent)

        intent?.apply {
            if (type == "text/plain") {
                textView.text = "接收到文字：${extras?.getString(Intent.EXTRA_TEXT)}"
            } else {
                textView.text = "接收到一张图片，路径为：${this.clipData?.toString()}或${data?.path}"
            }
        }

    }
}