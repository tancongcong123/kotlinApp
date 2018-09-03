package com.jx.myktapplication.http

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class CustomGsonConverterFactory (private val gson: Gson): Converter.Factory(){

    init {
        if (gson==null) throw NullPointerException("gson is null")
    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<out Annotation>?, methodAnnotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody>? {
        var adapter: TypeAdapter<out Any> = gson.getAdapter(TypeToken.get(type))
        return CustomGsonRequestBodyConver(gson, adapter)
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        var adapter: TypeAdapter<out Any> = gson.getAdapter(TypeToken.get(type))
        return CustomGsonResponseBodyConvert(gson, adapter)
    }
}