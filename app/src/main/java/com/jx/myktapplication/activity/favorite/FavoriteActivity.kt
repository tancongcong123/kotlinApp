package com.jx.myktapplication.activity.favorite

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jx.myktapplication.R
import com.jx.myktapplication.base.BaseActivity
import com.jx.myktapplication.bean.UserBean
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity: BaseActivity<FavoriteView, FavoritePresenter>(){
    override fun createPresenter(): FavoritePresenter {
        return FavoritePresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        init()
    }

    fun init(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FavoriteAdapter(this,getList())
    }

    private fun getList(): MutableList<UserBean>{
        var list: MutableList<UserBean> = ArrayList()
        for (i in 0..10){
            var user = UserBean()
            user.id = i.toString()
            user.name = "aa"+ i.toString()
            list.add(user)
        }
        return list
    }
}