package com.jx.myktapplication.fragment.home

import com.jx.myktapplication.base.BasePresenter
import com.jx.myktapplication.bean.BangumiBean
import com.jx.myktapplication.bean.DingBean
import com.jx.myktapplication.http.ApiClient
import com.jx.myktapplication.http.ApiException
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomePresenter: BasePresenter<HomeView>(){
    private var totalPage: Int = 0
    private var currentPage: Int = 0
    private var map: LinkedHashMap<Int,List<BangumiBean>>? = null
    fun getContent(){
        mView!!.showProgress()
        currentPage = 0
        ApiClient.instance.getApiService()!!.getDing()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object: Observer<DingBean> {
                    override fun onNext(s: DingBean) {
                        mView!!.hideProgress()
                        map = s.getList()
                        totalPage = s.totalPage
                        mView!!.getItems(map!![currentPage])
                    }

                    override fun onComplete() {
                        mView!!.hideProgress()
                        println("onComplete")
                    }

                    override fun onError(e: Throwable) {
                        mView!!.hideProgress()
                        if (e is ApiException) {
                            mView!!.onFail(e.message)
                        } else {
                            mView!!.onFail("请检查网络")
                        }
                    }

                    override fun onSubscribe(s: Disposable) {
                    }
                })
    }

    fun getMore(){
        if (currentPage<map!!.size){
            currentPage++
            mView!!.getMoreItems(map!![currentPage])
        }else{
            mView!!.loadDone()
        }
    }
}