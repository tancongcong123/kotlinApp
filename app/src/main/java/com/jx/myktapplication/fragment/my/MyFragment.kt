package com.jx.myktapplication.fragment.my

import com.jx.myktapplication.base.BaseFragment
import com.jx.myktapplication.R
import com.jx.myktapplication.activity.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_my.*
import org.jetbrains.anko.support.v4.startActivity

class MyFragment: BaseFragment<MyView, MyPresenter>(), MyView{
    override fun getLayoutID(): Int {
        return R.layout.fragment_my
    }

    override fun createPresenter(): MyPresenter {
        return MyPresenter()
    }

    override fun init() {
        tvLogin.setOnClickListener({
            startActivity<LoginActivity>()
        })
    }

    override fun loadData() {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

}