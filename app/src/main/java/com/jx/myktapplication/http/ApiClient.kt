package com.jx.myktapplication.http

import com.google.gson.Gson
import com.jx.myktapplication.BuildConfig
import com.jx.myktapplication.base.BaseApplication
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class ApiClient private constructor(){
    private val cacheSize:Long = 10*1024*1024
    private val httpCacheDirectory: File = File(BaseApplication.applicationContext().cacheDir, "jiexinCache")
    private val cache: Cache = Cache(httpCacheDirectory, cacheSize)
    private val client: OkHttpClient = OkHttpClient.Builder()
//            .cookieJar()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    private var apis: Apis? = null

    private object Holder{
        val INSTANCE = ApiClient()
    }
    companion object {
        val instance by lazy{ Holder.INSTANCE }
    }

    fun getApiService(): Apis?{
        if (apis == null){
            apis = Retrofit.Builder().baseUrl(getBaseUrl())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(CustomGsonConverterFactory(Gson()))
                    .client(client)
                    .build().create(Apis::class.java)
        }
        return apis
    }

    private fun getBaseUrl(): String{
        if (BuildConfig.DEBUG){
            return "https://www.bilibili.com/"
        }
        return "http://106.14.39.56:8088/"
    }
}