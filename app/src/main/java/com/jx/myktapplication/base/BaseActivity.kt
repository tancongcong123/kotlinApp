package com.jx.myktapplication.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<V, T : BasePresenter<V>>: AppCompatActivity() {

    open lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        if (mPresenter!=null){
            mPresenter.attachView(this as V)
        }
    }

    abstract fun createPresenter(): T

    override fun onDestroy() {
        if (mPresenter!=null) mPresenter.detachView()
        super.onDestroy()
    }
}