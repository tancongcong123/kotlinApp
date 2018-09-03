package com.jx.myktapplication.activity.main

import com.jx.myktapplication.base.BaseView

interface MainView : BaseView{
    fun onGetContentSuccess(content: String)
}