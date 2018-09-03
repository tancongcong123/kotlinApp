package com.jx.myktapplication.http

import com.google.gson.annotations.SerializedName

/**
 * Created by AX on 2017/10/25.
 */

class HttpStatus {
    @SerializedName("code")
    val code: Int = 0
    @SerializedName("error")
    private val mError: String? = null

    /**
     * API是否请求失败
     *
     * @return 失败返回true, 成功返回false
     * code 773 被挤掉登录
     * 1001 未登录
     */
    val isCodeInvalid: Boolean
        get() = if (isLoginOut) {
            false
        } else code != 0

    val isLoginOut: Boolean
        get() = code == 773 || code == 1003

    fun getmError(): String? {
        return mError
    }

}
