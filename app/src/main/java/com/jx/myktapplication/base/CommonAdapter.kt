package com.jx.myktapplication.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.jx.myktapplication.bean.BaseBean

abstract class CommonAdapter<D: BaseBean,T:CommonHolder<D>>(context: Context, dataList: List<D>): RecyclerView.Adapter<T>(){

    val context = context
    private val dataList = dataList

    protected abstract fun onCreateEDunViewHolder(parent: ViewGroup, viewType: Int): T

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        return onCreateEDunViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(dataList[position], position)
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].layoutType
    }

}