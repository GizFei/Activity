package com.giz.utility

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.log(msg: String) {
    Log.d(this::class.simpleName, "log: $msg")
}
fun Fragment.log(msg: String) {
    Log.d(this::class.simpleName, "log: $msg")
}

fun Activity.goto(clz: Class<*>) {
    startActivity(Intent(this, clz))
}

fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}