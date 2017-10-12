package com.example.vitor.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //val textName = findViewById<TextView>(R.id.textNam)
        textName.setText(intent.getStringExtra("name"))

        //val textDescription = findViewById<TextView>(R.id.textDesc)
        textDescricao.setText(intent.getStringExtra("description"))

        //val picasso = findViewById<ImageView>(R.id.tst)
        imageView.loadUrl("https://image.flaticon.com/icons/png/128/148/148767.png")

        var t = "t"
    }

    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}
