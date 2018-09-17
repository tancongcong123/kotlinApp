package com.jx.myktapplication.activity.webview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import com.jx.myktapplication.R
import kotlinx.android.synthetic.main.activity_web.*
import android.webkit.WebChromeClient

@Suppress("DEPRECATION")
class MyWebView: AppCompatActivity(){

    lateinit var url:String
    lateinit var currentUrl:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        url = intent.getStringExtra("url")
        setDefaultWebSettings()
        currentUrl = url
        web.loadUrl(url)
    }

    private fun setDefaultWebSettings(){
        web.webViewClient = object : WebViewClient(){
            @SuppressLint("NewApi")
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                var requestUrl: String = request!!.url.toString()
                if (requestUrl.contains("bilibili://video/")){
                    requestUrl = requestUrl.replace("bilibili://video/","")
                    val aid:String = requestUrl.substring(0, requestUrl.indexOf("?"))
                    requestUrl = "https://m.bilibili.com/video/av$aid.html"
                }
                if (currentUrl==requestUrl){
                    return true
                }
                currentUrl = requestUrl
                println("request url==$requestUrl")
                web!!.loadUrl(requestUrl)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                println("title == "+ view!!.title)
            }
        }
        web.webChromeClient = object :WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress>95){
                    progressBar.visibility = View.GONE
                }else{
                    if (progressBar.visibility == View.GONE)
                        progressBar.visibility = View.VISIBLE
                    progressBar.progress = newProgress
                }
                super.onProgressChanged(view, newProgress)
            }
        }
        var webSettings: WebSettings = web.settings
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.allowFileAccess = true
        // bilibili js 中需要用到本地存储
        webSettings.domStorageEnabled = true
        webSettings.pluginState = WebSettings.PluginState.ON
        // forbid zoom
        webSettings.displayZoomControls = false
        webSettings.builtInZoomControls = false

        webSettings.loadsImagesAutomatically = true
    }

    companion object {
        fun openActivity(context: Context,url: String){
            var intent = Intent(context, MyWebView::class.java)
            intent.putExtra("url", url)
            context.startActivity(intent)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (web.canGoBack()){
                web.goBack()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}