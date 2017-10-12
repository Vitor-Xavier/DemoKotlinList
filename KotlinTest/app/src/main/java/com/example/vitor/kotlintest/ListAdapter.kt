package com.example.vitor.kotlintest

import android.app.Activity
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.vitor.kotlintest.Models.ItemLista
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_item.view.*

/**
 * Created by vitor on 24/09/2017.
 */

data class ListAdapter(var itensLista:List<ItemLista>, var activity: Activity) : BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = View.inflate(activity,R.layout.row_item,null)

        view.textName.setText(itensLista.get(p0).name)
        view.textDescription.setText(itensLista.get(p0).description)
        view.imageView.loadUrl(itensLista.get(p0).imageUrl)

        return view
    }

    fun ImageView.loadUrl(url: String) {
        if (url != null && !url.equals(""))
            Picasso.with(context).load(url).into(this)
    }

    override fun getItem(p0: Int): Any {
        return itensLista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return itensLista.size
    }

}