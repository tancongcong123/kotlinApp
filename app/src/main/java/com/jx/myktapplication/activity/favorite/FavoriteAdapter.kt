package com.jx.myktapplication.activity.favorite

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import com.jx.myktapplication.R
import com.jx.myktapplication.base.CommonAdapter
import com.jx.myktapplication.base.CommonHolder
import com.jx.myktapplication.bean.UserBean
import org.jetbrains.anko.*

class FavoriteAdapter(context: Context, list:MutableList<UserBean>): CommonAdapter<UserBean, CommonHolder<UserBean>>(context, list){
    @SuppressLint("NewApi")
    override fun onCreateEDunViewHolder(parent: ViewGroup, viewType: Int): CommonHolder<UserBean> {
        val commonStyle = {v:Any->
            when(v){
                is LinearLayout->{
                    v.layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
                }
            }
        }
        when(viewType){
            0-> return FavoriteHolder(with(context){
                linearLayout {
                    orientation = HORIZONTAL
                    backgroundResource = R.color.white
                    textView {
                        id = R.id.tv_id
                        textSize = 15f
                        padding = dip(10)
                    }

                    textView {
                        id = R.id.tv_name
                        textSize = 15f
                        padding = dip(10)
                    }.lparams{
                        setMargins(dip(10),dip(0),dip(0),dip(0))
                    }
                }
            }.applyRecursively(commonStyle))
            1-> return FavoriteHolder(with(context){
                linearLayout {
                    orientation = HORIZONTAL
                    backgroundResource = R.color.main_hint_gray
                    textView {
                        id = R.id.tv_id
                        textSize = 15f
                        textColorResource = R.color.white
                        padding = dip(10)
                    }

                    textView {
                        id = R.id.tv_name
                        textSize = 15f
                        padding = dip(10)
                        textColorResource = R.color.white
                    }.lparams{
                        setMargins(dip(10),dip(0),dip(0),dip(0))
                    }
                }
            }.applyRecursively(commonStyle))
            else -> return FavoriteHolder(with(context){
                linearLayout {
                    orientation = HORIZONTAL
                    textView {
                        id = R.id.tv_id
                        textSize = 15f
                        padding = dip(10)
                    }

                    textView {
                        id = R.id.tv_name
                        textSize = 15f
                        padding = dip(10)
                        textColorResource = R.color.main_text_red
                    }.lparams{
                        setMargins(dip(10),dip(0),dip(0),dip(0))
                    }
                }
            }.applyRecursively(commonStyle))
        }
    }

}