package com.jx.myktapplication.activity.login

import android.os.Bundle
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.EditText
import com.jx.myktapplication.base.BaseActivity
import com.jx.myktapplication.ui.myRichView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LoginActivity:BaseActivity<LoginView, LoginPresenter>(){

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginActivityUI().setContentView(this)
    }

    private fun login(name: CharSequence?, password: CharSequence?){
        if (check(name.toString(), password.toString())){
            toast("login success")
        }else{
            toast("please input right name and password")
        }
    }

    private fun check(name: String, pwd: String)= name=="11"&& pwd=="22"

    class LoginActivityUI: AnkoComponent<LoginActivity>{
        private val commonStyle = {v:Any->
            when(v){
                is Button -> v.textSize = 18f
                is EditText -> v.textSize = 14f
            }
        }
        override fun createView(ui: AnkoContext<LoginActivity>) = with(ui){
            verticalLayout {
                padding = dip(32)
//                imageView(R.mipmap.bili).lparams{
//                    margin = dip(16)
//                    gravity = Gravity.CENTER
//                }

                myRichView()
                val name = editText{
                    hint = "please input account"
                }
                val password = editText{
                    hint = "please input password"
                    inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                }
                button("login"){
                    onClick {
//                        toast("login success")
                        ui.owner.login(name.text, password.text)
                    }
                }.lparams{
                    width = MATCH_PARENT
                    height = WRAP_CONTENT
                    topMargin = dip(32)
                }

            }.applyRecursively(commonStyle)
        }

    }

}