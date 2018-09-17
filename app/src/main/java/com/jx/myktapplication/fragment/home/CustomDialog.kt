package com.jx.myktapplication.fragment.home

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.TextView
import com.jx.myktapplication.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class CustomDialog private constructor(context: Context?){

    private var dialog: Dialog? = null
    private val mContext: Context? = context

    companion object {
        fun newInstances(context: Context?) = CustomDialog(context)
    }

    private val commonStyle = {v:Any->
        when(v){
            is Button -> {
                v.textSize = 13f
                (v.layoutParams as LinearLayout.LayoutParams).weight = 1f
            }
            is TextView -> {
                v.textSize = 14f
                v.textColorResource = R.color.main_text_gray
                v.gravity = Gravity.CENTER
            }
        }
    }

    @SuppressLint("NewApi")
    fun showDialog(title: String, content: String){
        if (dialog==null){
            dialog = Dialog(mContext)
            val view = dialog!!.context.verticalLayout {
                lparams(width = dip(150), height = wrapContent)
                setPadding(dip(16),dip(16),dip(16),dip(0))
                gravity = Gravity.CENTER
                textView(title)
                textView(content)
                linearLayout {
                    orientation = HORIZONTAL
                    lparams(width= matchParent, height = wrapContent)
                    button("cancel"){
                        background = null
                        textColorResource = R.color.main_text_gray
                        onClick {
                            mContext!!.toast("cancel")
                            hideDialog()
                        }
                    }

                    button("confirm"){
                        background = null
                        textColorResource = R.color.main_text_red
                        onClick {
                            mContext!!.toast("confirm")
                        }
                    }
                }
            }.applyRecursively(commonStyle)
            dialog!!.setContentView(view)
        }
        dialog!!.show()
    }

    fun hideDialog(){
        if (dialog!=null){
            dialog!!.dismiss()
        }
    }
}