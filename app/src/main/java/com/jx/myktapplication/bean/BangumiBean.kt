package com.jx.myktapplication.bean

import com.jx.myktapplication.util.CommonMethod

class BangumiBean{
    var aid: String = ""
    var tid: String = ""
    var tname: String = ""
    var pic: String = ""
    var title: String = ""
    var desc: String = ""
    var dynamic: String = ""
    var redirect_url: String = ""
    var ctime: String = ""
        get() = CommonMethod.switchDataString(field.toLong(), "yyyy-MM-dd hh:mm:ss")
    var pubdate: String = ""
        get() = CommonMethod.switchDataString(field.toLong(), "yyyy-MM-dd hh:mm:ss")
    var owner: Owner? = null
}