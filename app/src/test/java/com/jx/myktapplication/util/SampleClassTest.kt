package com.jx.myktapplication.util

import com.jx.myktapplication.bean.UserBean
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class SampleClassTest {

    lateinit var sampleClass : SampleClass

    @Before
    fun setUp() {
        sampleClass = SampleClass()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getString() {
        println(sampleClass!!.getString())
        println("----while 使用-----")
        var x = 5
        while (x > 0) {
            println( x--)
        }
        println("----do...while 使用-----")
        var y = 5
        do {
            println(y--)
        } while(y>5)
    }

    @Test
    fun switchDataString(){
        println(sampleClass.switchDataString(1445225087,"MM:dd-hh:mm:ss"))
    }

    @Test
    fun isPalindrome(){
        sampleClass.isPalindrome("ad")
    }

    @Test
    fun operator(){
        sampleClass.operator()
    }

    @Test
    fun findElement(){
        sampleClass.findElement()
    }

    @Test
    fun getColor(){
        sampleClass.getColor()
    }

    @Test
    fun regex(){
        sampleClass.regex()
        for (i in 0..10){
            println("index is $i")
        }
    }

    @Test
    fun check(){
        assertEquals(true, sampleClass.check("a","b"))
        assertEquals(false, sampleClass.check("a",""))
    }
}