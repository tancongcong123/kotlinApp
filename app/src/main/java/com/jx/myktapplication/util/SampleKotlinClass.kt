package com.jx.myktapplication.util

fun main(args: Array<String>){
    val a:Int = 28
    println( a === a)

    val boxA:Int? = a
    val anotherBoxA:Int? = a
    println(boxA === anotherBoxA)
    println(boxA == anotherBoxA)
}