package com.jx.myktapplication.fragment.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jx.myktapplication.bean.BangumiBean
import com.jx.myktapplication.R
import com.jx.myktapplication.base.GlideApp
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(val context: Context?, private val dataList: List<BangumiBean>): RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(LayoutInflater.from(context).inflate(R.layout.item_home, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

    inner class HomeHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: BangumiBean){
            itemView.tvName.text = item.owner!!.name
            itemView.tvCreateTime.text = item.pubdate
            itemView.tvThem.text = item.tname + item.dynamic
            itemView.tvTitle.text = item.title
            itemView.tvDesc.text = item.desc
            GlideApp.with(context!!).load(item.owner!!.face).circleCrop().into(itemView.ivHeadImg)
            GlideApp.with(context!!).load(item.pic).fitCenter().into(itemView.ivPic)
        }
    }
}