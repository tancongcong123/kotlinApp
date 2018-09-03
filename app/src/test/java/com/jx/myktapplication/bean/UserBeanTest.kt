package com.jx.myktapplication.bean

import org.junit.After
import org.junit.Before

import org.junit.Test

class UserBeanTest {

    lateinit var userBean : UserBean

    @Before
    fun setUp() {
        userBean = UserBean()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testBean(){
        userBean.ageRange = "5"
        userBean.id = "0"
        userBean.name = "haha"
        println("${userBean.name} is a ${userBean.ageRange}")
    }
}