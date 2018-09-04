package com.jx.myktapplication.exec

import android.content.Context
import android.widget.Toast

public fun Context.toast(msg: String?){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}