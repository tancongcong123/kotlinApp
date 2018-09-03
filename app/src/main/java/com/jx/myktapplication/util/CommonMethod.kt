package com.jx.myktapplication.util

import java.text.SimpleDateFormat
import java.util.*

class CommonMethod{
    companion object {
        fun switchDataString(milSecond:Long, pattern:String): String{
            val date = Date(milSecond)
            val format = SimpleDateFormat(pattern)
            return format.format(date)
        }
    }
}