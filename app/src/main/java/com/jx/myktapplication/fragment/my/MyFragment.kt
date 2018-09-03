package com.jx.myktapplication.fragment.my

import com.jx.myktapplication.base.BaseFragment
import com.jx.myktapplication.R

class MyFragment: BaseFragment<MyView, MyPresenter>(), MyView{
    override fun getLayoutID(): Int {
        return R.layout.fragment_my
    }

    override fun createPresenter(): MyPresenter {
        return MyPresenter()
    }

    override fun init() {

    }

    override fun loadData() {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

}