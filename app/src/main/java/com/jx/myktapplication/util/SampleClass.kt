package com.jx.myktapplication.util

import android.annotation.SuppressLint
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
    /*
     * Your task is to implement a palindrome test.
     *
     * A string is called a palindrome when it reads the same way left-to-right
     * and right-to-left.
     *
     * See http://en.wikipedia.org/wiki/Palindrome
     */
    fun isPalindrome(s: String): Boolean {
        if(s!=null){
            if(s.length<2) return true
            val maxIndex = s.length-1
            if(maxIndex%2==0){
                val middle = maxIndex/2
                return s.substring(0,middle) == s.substring(middle+1,maxIndex+1).reversed()
            }else{
                val middle = maxIndex/2+1
                return s.substring(0,middle) == s.substring(middle,maxIndex+1).reversed()
            }
        }
        return false
    }

    fun indexOfMax(a: IntArray): Int? {
        if(a==null || a.size==0) {
            return null
        }
        loop@ for(pos in a.indices){
            for(index in a.indices){
                if(index!=pos && a[index]>a[pos])continue@loop
                if(a[index]<=a[pos] && index==a.size-1){
                    println("pos=$pos")
                    return pos
                }
            }
        }
        return 0
    }

    @SuppressLint("UseSparseArrays")
    fun runs(a: IntArray): Int {
        // Write your solution here
        if(a!=null){
            if(a.size==1){
                return 1
            }
            var map:MutableMap<Int,Int> = HashMap<Int, Int>()
            var currentIndex = -1
            outer@ for(x in a.indices){
                if(x<=currentIndex){
                    continue@outer
                }else{
                    map.put(x, currentIndex)
                }

                loop@ for(y in a.indices){
                    if(y<=currentIndex||a[y]==a[x]) {
                        if(y==a.size-1){
                            return map.size
                        }
                        continue@loop
                    }else{
                        currentIndex = y-1
                        continue@outer
                    }
                }
            }
            return map.size
        }
        return 0
    }
}