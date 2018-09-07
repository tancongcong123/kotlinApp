package com.jx.myktapplication.bean

import android.annotation.SuppressLint

@SuppressLint("NewApi")
class DingBean{
    var results: Int = 0
    var totalPage: Int = 0
    private var douga: LinkedHashMap<String, BangumiBean>? = null
    private var teleplay: LinkedHashMap<String, BangumiBean>? = null
    private var kichiku: LinkedHashMap<String, BangumiBean>? = null
    private var dance: LinkedHashMap<String, BangumiBean>? = null
    private var bangumi: LinkedHashMap<String, BangumiBean>? = null
    private var fashion: LinkedHashMap<String, BangumiBean>? = null
    private var life: LinkedHashMap<String, BangumiBean>? = null
    private var ad: LinkedHashMap<String, BangumiBean>? = null
    private var guochuang: LinkedHashMap<String, BangumiBean>? = null
    private var movie: LinkedHashMap<String, BangumiBean>? = null
    private var music: LinkedHashMap<String, BangumiBean>? = null
    private var technology: LinkedHashMap<String, BangumiBean>? = null
    private var ent: LinkedHashMap<String, BangumiBean>? = null

    private fun getDouga():List<BangumiBean>{
        return iteratorMap(douga!!)
    }
    private fun getTeleplay():List<BangumiBean>{
        return iteratorMap(teleplay!!)
    }
    private fun getKichiku():List<BangumiBean>{
        return iteratorMap(kichiku!!)
    }
    private fun getDance():List<BangumiBean>{
        return iteratorMap(dance!!)
    }
    private fun getBangumi():List<BangumiBean>{
        return iteratorMap(bangumi!!)
    }
    private fun getFashion():List<BangumiBean>{
        return iteratorMap(fashion!!)
    }
    private fun getLife():List<BangumiBean>{
        return iteratorMap(life!!)
    }
    private fun getAd():List<BangumiBean>{
        return iteratorMap(ad!!)
    }
    private fun getGuochuang():List<BangumiBean>{
        return iteratorMap(guochuang!!)
    }
    private fun getMovie():List<BangumiBean>{
        return iteratorMap(movie!!)
    }
    private fun getMusic():List<BangumiBean>{
        return iteratorMap(music!!)
    }
    private fun getTechnology():List<BangumiBean>{
        return iteratorMap(technology!!)
    }
    private fun getEnt():List<BangumiBean>{
        return iteratorMap(ent!!)
    }

    fun getList(): LinkedHashMap<Int,List<BangumiBean>>{
        var list: LinkedHashMap<Int,List<BangumiBean>> = LinkedHashMap()
        if (getDouga().isNotEmpty()){
            list[totalPage] = getDouga()
            totalPage++
        }
        if (getTeleplay().isNotEmpty()){
            list[totalPage] = getTeleplay()
            totalPage++
        }
        if (getKichiku().isNotEmpty()){
            list[totalPage] = getKichiku()
            totalPage++
        }
        if (getDance().isNotEmpty()){
            list[totalPage] = getDance()
            totalPage++
        }
        if (getBangumi().isNotEmpty()){
            list[totalPage] = getBangumi()
            totalPage++
        }
        if (getFashion().isNotEmpty()){
            list[totalPage] = getFashion()
            totalPage++
        }
        if (getLife().isNotEmpty()){
            list[totalPage] = getLife()
            totalPage++
        }
//        if (getAd().isNotEmpty()){
//            list[totalPage] = getAd()
//            totalPage++
//        }
        if (getGuochuang().isNotEmpty()){
            list[totalPage] = getGuochuang()
            totalPage++
        }
        if (getMovie().isNotEmpty()){
            list[totalPage] = getMovie()
            totalPage++
        }
        if (getMusic().isNotEmpty()){
            list[totalPage] = getMusic()
            totalPage++
        }
        if (getTechnology().isNotEmpty()){
            list[totalPage] = getTechnology()
            totalPage++
        }
        if (getEnt().isNotEmpty()){
            list[totalPage] = getEnt()
            totalPage++
        }
        return list
    }

    private fun iteratorMap(map:LinkedHashMap<String, BangumiBean>):List<BangumiBean>{
        val it = map!!.iterator()
        var list:MutableList<BangumiBean> = ArrayList<BangumiBean>()
        while (it.hasNext()){
            list.add(it.next().value)
        }
        return list
    }
}