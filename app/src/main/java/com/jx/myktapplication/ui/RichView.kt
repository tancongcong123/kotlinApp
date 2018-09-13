package com.jx.myktapplication.ui

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity.CENTER
import android.view.ViewManager
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jx.myktapplication.R
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

class RichView: LinearLayout {

    private lateinit var image: ImageView
    private lateinit var text: TextView

    constructor(context: Context):this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?):this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){
        init()
    }

    private fun init() = AnkoContext.createDelegate(this).apply {
        gravity = CENTER
        padding = dip(20)

        image = imageView(imageResource = R.mipmap.ic_launcher_round){
            padding = dip(8)
            layoutParams = LinearLayout.LayoutParams(dip(100), dip(100))
            onClick { startAnim() }
        }

//        text = textView("ANKO View"){ textSize = 15f}
        startAnim()
    }

    private fun startAnim(){
        if (image.animation!=null) return
        image.startAnimation(ScaleAnimation(1f,1.3f,1f,1.3f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f).
            apply {
                repeatCount = 3
                repeatMode = Animation.REVERSE
                duration = 1000
            })
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.myRichView() = myRichView{}
inline fun ViewManager.myRichView(init: RichView.()->Unit) = ankoView(::RichView, 0, init)
