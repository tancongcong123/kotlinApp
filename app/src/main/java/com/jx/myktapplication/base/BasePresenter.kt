package com.jx.myktapplication.base

open class BasePresenter<T> {

    open var mView : T? = null

    open fun attachView(view : T){
        mView = view
    }

    open fun getView():T? {
        if (mView == null) throw IllegalStateException("view is not attached")
        return mView
    }

    open fun detachView() {
        if (mView!=null){
            mView = null
        }
    }
}