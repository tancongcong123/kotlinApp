package com.jx.myktapplication.fragment.my

import com.jx.myktapplication.base.BaseFragment
import com.jx.myktapplication.R
import com.jx.myktapplication.activity.favorite.FavoriteActivity
import com.jx.myktapplication.activity.login.LoginActivity
import com.jx.myktapplication.fragment.home.CustomDialog
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
        tvLogin.setOnClickListener {
            startActivity<LoginActivity>()
        }
        tvList.setOnClickListener {
            startActivity<FavoriteActivity>()
        }

        tvClear.setOnClickListener {
            // 流式结构
            CustomDialog.newInstances(context).
                    showDialog("hello","anko is a very useful tool for program,anko is a very useful tool for program")
        }
    }

    override fun loadData() {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

}