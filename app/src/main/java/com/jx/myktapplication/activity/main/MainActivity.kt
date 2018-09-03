package com.jx.myktapplication.activity.main

import android.os.Bundle
import android.support.v4.app.Fragment
import com.jx.myktapplication.R
import com.jx.myktapplication.base.BaseActivity
import com.jx.myktapplication.fragment.home.HomeFragment
import com.jx.myktapplication.fragment.my.MyFragment
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    lateinit var mFragments: MutableList<Fragment>
    var currentTag: String = "home"

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFragments = ArrayList<Fragment>()
        mPresenter.getContent()
        init()
    }

    fun init(){
        mFragments.clear()
        mFragments.add(HomeFragment())
        mFragments.add(MyFragment())
        supportFragmentManager.beginTransaction().add(R.id.mainContent, mFragments[0],"home").commit()
        rgBottom.setOnCheckedChangeListener { group, checkedId ->
            run {
                when (checkedId) {
                    R.id.rbHome -> {
                        println("click home")
                        switchFragment(0, "home")
                    }
                    R.id.rbMy -> {
                        println("click my")
                        switchFragment(1, "my")
                    }
                    else -> println("click nothing")
                }
            }
        }
    }

    private fun switchFragment(index: Int, tag: String){
        val trasaction = supportFragmentManager.beginTransaction()
        val detachFragment = supportFragmentManager.findFragmentByTag(currentTag)
        if (detachFragment != null) {
            trasaction.hide(detachFragment)
        }

        var attachFragment = supportFragmentManager.findFragmentByTag(tag)

        if (attachFragment != null) {
            trasaction.show(attachFragment)
        }else{
            trasaction.add(R.id.mainContent, mFragments[index],tag)
        }
        trasaction.commit()
        currentTag = tag
    }

    override fun onGetContentSuccess(content: String) {
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }
}
