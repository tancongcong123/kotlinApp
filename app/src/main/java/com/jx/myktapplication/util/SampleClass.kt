package com.jx.myktapplication.util

import java.text.SimpleDateFormat
import java.util.*

class SampleClass{
    fun getString() :String?{
        val text = """
            多行字符串
            菜鸟教程
            多行字符串
            Runoob
        """.trimMargin("|")
        return text
    }

    fun switchDataString(milSecond:Long, pattern:String): String{
        val date = Date(milSecond)
        val format = SimpleDateFormat(pattern)
        return format.format(date)
    }
}