package com.jx.myktapplication.http

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Converter
import java.nio.charset.Charset
import okhttp3.internal.Util.UTF_8
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

class CustomGsonResponseBodyConvert<T> internal constructor(private val gson: Gson,private val adapter:TypeAdapter<T>) : Converter<ResponseBody, T>{
    override fun convert(value: ResponseBody?): T {
        val response = value!!.string()
        val httpStatus: HttpStatus = gson.fromJson(response, HttpStatus::class.java)
        if (httpStatus.isCodeInvalid){
            value.close()
            throw ApiException(httpStatus.code, httpStatus.getmError())
        }
        val contentType: MediaType? = value.contentType()
        val charset: Charset? = if (contentType==null) UTF_8 else contentType.charset(UTF_8)
        val inputStream: InputStream = ByteArrayInputStream(response.toByteArray())
        val reader: Reader = InputStreamReader(inputStream, charset)
        val jsonReader: JsonReader? = gson.newJsonReader(reader)
        value.use {
            return adapter.read(jsonReader)
        }
    }

}