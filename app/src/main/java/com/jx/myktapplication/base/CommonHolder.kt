package com.jx.myktapplication.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class CommonHolder<D>(itemView: View): RecyclerView.ViewHolder(itemView){
    abstract fun bindData(data: D, position: Int)
}