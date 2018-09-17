package com.jx.myktapplication.bean

class UserBean: BaseBean(){

    var id: String =""
        get() = field
        set

    var name: String =""
        get() = field.toUpperCase()
        set

    var ageRange: String ="adult"
        get() = field
        set(value) {
            if (value.toInt()<15){
                field = "child"
            }else if (value.toInt()<25){
                field = "teenager"
            }else{
                field = "adult"
            }
        }
}