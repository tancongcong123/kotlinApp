package com.jx.myktapplication.ui.loadmore

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE
import android.view.View

class SwipeToLoadMore(val recyclerView : RecyclerView, private val mAdapterWrapper: AdapterWrapper?, private val loadMoreListener: LoadMoreListener) : RecyclerView.OnScrollListener() {
    companion object {
        const val STATUS_LOADING = 0
        const val STATUS_LOADING_ERROR = 1
        const val STATUS_LOADING_DONE = 2
        const val STATUS_LOADING_GONE = 3
    }

    private var currentStatus: Int = STATUS_LOADING_GONE
    private var layoutManager : RecyclerView.LayoutManager = recyclerView.layoutManager
    private var mLoading: Boolean = false
    private var isCanSwipeToLoadMore: Boolean = true

    init {
        recyclerView.addOnScrollListener(this)
    }

    private fun isCanLoad():Boolean{
        return currentStatus != STATUS_LOADING_DONE
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        if (isCanSwipeToLoadMore && SCROLL_STATE_IDLE == newState && !mLoading){
            if (layoutManager is LinearLayoutManager){
                val linearLayoutManager: LinearLayoutManager = layoutManager as LinearLayoutManager
                val lastCompletePos = linearLayoutManager.findLastCompletelyVisibleItemPosition()
                if (lastCompletePos == layoutManager.itemCount-2){
                    val firstCompletePos = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val child: View? = linearLayoutManager.findViewByPosition(lastCompletePos)
                            ?: return
                    val deltaY:Int = recyclerView!!.bottom - recyclerView.paddingBottom - child!!.bottom
                    if (deltaY>0 && firstCompletePos!=0){
                        recyclerView.scrollBy(0,-deltaY)
                    }
                }else if (lastCompletePos == layoutManager.itemCount - 1 && isCanLoad() && layoutManager.itemCount > 1){
                    mLoading = true
                    mAdapterWrapper!!.setLoadItemState(true, STATUS_LOADING)
                    loadMoreListener.loadMore()
                }
            }
        }
    }

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
    }

    /** 设置LoadMore Item为加载完成状态, 上拉加载更多完成时调用  */
    fun setLoadMoreStatus(status: Int) {
        currentStatus = status
        mLoading = false
        mAdapterWrapper!!.setLoadItemState(false, status)
    }
}