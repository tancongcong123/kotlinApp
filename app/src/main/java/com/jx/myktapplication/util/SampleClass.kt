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

    fun operator(){
        var a = 10
        var b = 10
        var c = 10
        var d = 10
        println("a++ = ${a++} \t b-- = ${b--} \t ++c = ${++c} \t --d = ${--d}")
        a++
        b--
        ++c
        --d
        println("a=$a b=$b c=$c d=$d")
    }

    fun findElement(){
        var str = "kotlin very good"
        var result = str.firstOrNull { it=='e' }
        println("result=$result")
        println("str.first()=${str.first()}")
        println("count=${str.count { it=='o' }}")
    }

    fun getColor() {
        println("name = " + Color.RED.name + "\tordinal = " + Color.RED.ordinal)
        println("name = " + Color.WHITE.name + "\tordinal = " + Color.WHITE.ordinal)
        println("name = " + Color.BLACK.name + "\tordinal = " + Color.BLACK.ordinal)
        println("name = " + Color.GREEN.name + "\tordinal = " + Color.GREEN.ordinal)
        Color.BLUE.toString()
        Color.BLUE.print()
    }

    fun regex(){
//        val regex = "\\d+".toRegex()
        val regex = "[a-zA-Z0-9]+".toRegex()
        val nums = listOf("aaa","123","34D").filter(regex::matches)
        println("nums = $nums")

        val map = mapOf(0 to "11", 1 to "haha", "hehe" to "22")
        println("map = $map")
        println(map.mapValues{(key, value)->"$value"})

    }
}