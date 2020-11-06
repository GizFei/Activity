package com.giz.lifecycle.lifecycle

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.util.SparseArray
import androidx.appcompat.widget.AppCompatEditText

class PrintLifecycleEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = android.R.attr.editTextStyle)
    : AppCompatEditText(context, attrs, defStyleAttr) {

    override fun onSaveInstanceState(): Parcelable? {
        val state = super.onSaveInstanceState()
        Log.d("PrintLifecycleEditText", "onSaveInstanceState: EditText保存状态-state: $state")
        return state
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        Log.d("PrintLifecycleEditText", "onRestoreInstanceState: EditText恢复状态-state: $state")
        super.onRestoreInstanceState(state)
    }
}