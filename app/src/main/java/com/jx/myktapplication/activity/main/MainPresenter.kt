package com.jx.myktapplication.activity.main

import com.jx.myktapplication.base.BasePresenter

class MainPresenter : BasePresenter<MainView>() {

    fun getContent(){
        mView!!.onGetContentSuccess("hello kotlin")
    }
}