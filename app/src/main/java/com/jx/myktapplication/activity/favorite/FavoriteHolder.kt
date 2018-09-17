package com.jx.myktapplication.activity.favorite

import android.view.View
import android.widget.TextView
import com.jx.myktapplication.R
import com.jx.myktapplication.base.CommonHolder
import com.jx.myktapplication.bean.UserBean

class FavoriteHolder<D>(itemView: View): CommonHolder<D>(itemView){
    override fun bindData(data: D, position: Int) {
        data as UserBean
        var tvId = itemView.findViewById(R.id.tv_id) as TextView
        var tvName = itemView.findViewById(R.id.tv_name) as TextView
        tvId.text = "id=${data.id}"
        tvName.text = "name=${data.name}"
    }

}