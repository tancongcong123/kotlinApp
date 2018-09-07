package com.jx.myktapplication.ui

import android.content.Context
import android.support.v7.widget.AppCompatEditText
import android.text.InputFilter
import android.text.Spanned
import android.util.AttributeSet

/**
 * filter emoji from EditText,cannot input emoji
 */
class CustomEditText(context:Context?, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatEditText(context, attrs, defStyleAttr){

    init {
        val oldFilters = filters
        val oldFilterSize = oldFilters.size
        val newFilters = arrayOfNulls<InputFilter>(oldFilterSize + 1)
        if (oldFilterSize>0){
            // src表示源数组，srcPos表示源数组要复制的起始位置，desc表示目标数组，descPos目标数组的起始位置，length表示要复制的长度
            // System.arraycopy(src, srcPos, desc, descPos, length)
            System.arraycopy(oldFilters,0,newFilters, 0,oldFilterSize)
        }
        newFilters[oldFilterSize] = EmojiFilter()
        filters = newFilters
    }

    inner class EmojiFilter : InputFilter{
        override fun filter(source: CharSequence?, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int): CharSequence {
            for (i in start until end) {
                val type = Character.getType(source!!.get(i))
                if (type == Character.SURROGATE.toInt() || type == Character.OTHER_SYMBOL.toInt()) {
                    return ""
                }
            }
            return ""
        }
    }
}
