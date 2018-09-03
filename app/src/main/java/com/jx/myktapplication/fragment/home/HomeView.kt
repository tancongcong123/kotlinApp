package com.jx.myktapplication.fragment.home

import com.jx.myktapplication.base.BaseView
import com.jx.myktapplication.bean.BangumiBean
import com.jx.myktapplication.bean.DingBean
import com.jx.myktapplication.bean.ItemListBean

interface HomeView : BaseView{
    open fun getItems(itemList: List<BangumiBean>?)
    open fun getMoreItems(itemList: List<BangumiBean>?)
    open fun onFail(error: String?)
    open fun loadDone()
}