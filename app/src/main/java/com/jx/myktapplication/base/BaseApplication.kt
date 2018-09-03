package com.jx.myktapplication.base

import android.app.Application
import android.content.Context

class BaseApplication: Application(){

    init{
        instance = this
    }

    companion object {
        private var instance: BaseApplication? = null
        fun applicationContext():Context{
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

}