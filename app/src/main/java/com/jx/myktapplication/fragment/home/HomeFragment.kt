package com.jx.myktapplication.fragment.home

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jx.myktapplication.base.BaseFragment
import com.jx.myktapplication.R
import com.jx.myktapplication.bean.BangumiBean
import com.jx.myktapplication.ui.loadmore.AdapterWrapper
import com.jx.myktapplication.ui.loadmore.LoadMoreListener
import com.jx.myktapplication.ui.loadmore.SwipeToLoadMore
import kotlinx.android.synthetic.main.fragment_home.*
import com.jx.myktapplication.exec.toast

class HomeFragment : BaseFragment<HomeView, HomePresenter>(), HomeView,SwipeRefreshLayout.OnRefreshListener,LoadMoreListener{
    override fun getMoreItems(itemList: List<BangumiBean>?) {
        if (itemList!=null){
            datas!!.addAll(itemList!!)
            initView()
        }
        swipeToLoadMore!!.setLoadMoreStatus(SwipeToLoadMore.STATUS_LOADING_GONE)
    }

    override fun loadDone() {
        swipeToLoadMore!!.setLoadMoreStatus(SwipeToLoadMore.STATUS_LOADING_DONE)
    }

    override fun onRefresh() {
        mPresenter.getContent()
    }

    override fun loadMore() {
        mPresenter.getMore()
    }

    private var adapter:HomeAdapter? = null
    private var adapterWrapper:AdapterWrapper? = null
    private var swipeToLoadMore:SwipeToLoadMore? = null
    private var datas: MutableList<BangumiBean>? = ArrayList()

    override fun getItems(itemList: List<BangumiBean>?) {
        datas!!.clear()
        datas!!.addAll(itemList!!)
        initView()
        swipeToLoadMore!!.setLoadMoreStatus(SwipeToLoadMore.STATUS_LOADING_GONE)
    }

    override fun onFail(error: String?) {
        context?.toast(error)
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun createPresenter(): HomePresenter{
        return HomePresenter()
    }

    override fun init() {
        viewStub = emptyRoot
        swipeRefreshLayout.setColorSchemeResources(R.color.pink)
        swipeRefreshLayout.setOnRefreshListener(this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        mPresenter.getContent()
    }

    private fun initView(){
        if (adapter==null){
            adapter = HomeAdapter(context, datas!!)
            adapterWrapper = AdapterWrapper(adapter as RecyclerView.Adapter<RecyclerView.ViewHolder>)
            recyclerView.adapter = adapterWrapper
            swipeToLoadMore = SwipeToLoadMore(recyclerView, adapterWrapper, this)
        }
        adapterWrapper!!.notifyDataSetChanged()
    }

    override fun loadData() {

    }

}