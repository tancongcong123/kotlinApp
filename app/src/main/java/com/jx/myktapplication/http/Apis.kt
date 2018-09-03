package com.jx.myktapplication.http

import com.jx.myktapplication.bean.DingBean
import com.jx.myktapplication.bean.ItemListBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apis{

    @GET("index/ding.json")
    fun getDing(): Observable<DingBean>
}