package com.jx.myktapplication.exec

import android.content.Context
import android.widget.Toast

/**
 * 扩展写在包名下 与包名同级 这样全部可见
 * 通过导入 包名+扩展名 就可以引用
 *
 * 也可在类中对其他类进行扩展 这样只有类及其子类可见
 */
fun Context.toast(msg: String?){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}