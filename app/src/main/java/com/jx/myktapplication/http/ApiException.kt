package com.jx.myktapplication.http

open class ApiException(errorCode: Int, errorMsg: String?): RuntimeException(errorMsg){

}