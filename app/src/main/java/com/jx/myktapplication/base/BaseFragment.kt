package com.jx.myktapplication.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Fragment创建：setUserVisibleHint()->onAttach()->onCreate()->onCreateView()->onActivityCreated()->onStart()->onResume()；
 * Fragment变为不可见状态（锁屏、回到桌面、被Activity完全覆盖）：onPause()->onSaveInstanceState()->onStop()；
 * Fragment变为部分可见状态（打开Dialog样式的Activity）：onPause()->onSaveInstanceState()；
 * Fragment由不可见变为活动状态：onStart()->OnResume()；
 * Fragment由部分可见变为活动状态：onResume()；
 * 退出应用：onPause()->onStop()->onDestroyView()->onDestroy()->onDetach()（注意退出不会调用onSaveInstanceState方法，因为是人为退出，没有必要再保存数据）；
 * Fragment被回收又重新创建：被回收执行onPause()->onSaveInstanceState()->onStop()->onDestroyView()->onDestroy()->onDetach()，
 * 重新创建执行onAttach()->onCreate()->onCreateView()->onActivityCreated()->onStart()->onResume()->setUserVisibleHint()；
 */
abstract class BaseFragment<V, T : BasePresenter<V>> : Fragment(), BaseView{

    private var mContext: Context? = null
    private var mBundle: Bundle? = null
    lateinit var mPresenter: T
    private val STATE_SAVE_IS_HIDDEN = "state_save_is_hidden"
    lateinit var viewStub: ViewStub
    private var emptyView: View? = null

    fun getFragment(): Fragment{
        return this
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mBundle!=null){
            outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden)
            outState.putBundle("bundle", mBundle)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //获取bundle,并保存起来
        if (savedInstanceState != null) {
            val isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN)
            mBundle = savedInstanceState.getBundle("bundle")
            val ft = fragmentManager!!.beginTransaction()
            if (isSupportHidden) {
                ft.hide(this)
            } else {
                ft.show(this)
            }
            ft.commit()
        } else {
            mBundle = if (arguments == null)
                Bundle()
            else
                arguments
        }

        mPresenter = createPresenter()
        mPresenter.attachView(this as V)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    override fun onResume() {
        super.onResume()

        loadData()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    abstract fun getLayoutID():Int
    abstract fun createPresenter():T
    abstract fun init()
    abstract fun loadData()

    fun showEmpty(){
        if (emptyView!=null){
            emptyView!!.visibility = View.VISIBLE
            return
        }
        if(viewStub!=null){
            emptyView = viewStub.inflate()
        }
    }

    fun hideEmpty(){
        if (emptyView!=null){
            emptyView!!.visibility = View.GONE
        }
    }

    override fun showProgress() {
        swipeRefreshLayout!!.isRefreshing = true
    }

    override fun hideProgress() {
        swipeRefreshLayout!!.isRefreshing = false
    }
}