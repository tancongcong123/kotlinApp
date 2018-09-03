package com.jx.myktapplication.ui.loadmore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jx.myktapplication.bean.UserBean
import com.jx.myktapplication.R
import kotlinx.android.synthetic.main.item_load_more.view.*

class AdapterWrapper(val adapter :RecyclerView.Adapter<RecyclerView.ViewHolder>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /** view type : "上拉加载更多"  */
    private val ITEM_TYPE_LOAD = Integer.MAX_VALUE / 2

    private var mAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> = adapter
    private var mWrapperHolder: WrapperHolder? = null
    private var mShowLoadItem: Boolean = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_TYPE_LOAD){
            if (mWrapperHolder == null){
                mWrapperHolder = WrapperHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_load_more, parent, false))
            }
            return mWrapperHolder!!
        }else{
            return mAdapter.onCreateViewHolder(parent, viewType)
        }
    }

    override fun getItemCount(): Int {
        return if (mShowLoadItem) mAdapter.itemCount + 1 else mAdapter.itemCount
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mShowLoadItem && position == itemCount-1){
            // do nothing
        }else{
            holder.itemView.visibility = View.VISIBLE
            mAdapter.onBindViewHolder(holder, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (mShowLoadItem && position == itemCount-1){
            return ITEM_TYPE_LOAD
        }
        return mAdapter.getItemViewType(position)
    }

    internal inner class WrapperHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(msg: String, textVisibility: Int, pbVisibility: Int){
            itemView.item_load_tv.text = msg!!
            itemView.item_load_tv.visibility = textVisibility
            itemView.item_load_pb.visibility = pbVisibility
        }
    }

    fun setLoadItemVisibility(isShow: Boolean){
        if (mShowLoadItem != isShow){
            mShowLoadItem = isShow
            notifyDataSetChanged()
        }
    }

    fun setLoadItemState(isLoading: Boolean, status: Int){
        if (mWrapperHolder == null) return
        if (mAdapter.itemCount<5){
            mWrapperHolder!!.bind("",View.GONE,View.GONE)
            return
        }
        if (isLoading){
            mWrapperHolder!!.bind("loading...",View.VISIBLE,View.VISIBLE)
        }else{
            when(status){
                SwipeToLoadMore.STATUS_LOADING_ERROR->mWrapperHolder!!.bind("load error",View.VISIBLE,View.GONE)
                SwipeToLoadMore.STATUS_LOADING_DONE->mWrapperHolder!!.bind("load done",View.VISIBLE,View.GONE)
                else->mWrapperHolder!!.bind("",View.GONE,View.GONE)
            }
        }

    }

}