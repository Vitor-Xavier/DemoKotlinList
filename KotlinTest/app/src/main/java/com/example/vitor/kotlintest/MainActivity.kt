package com.example.vitor.kotlintest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //private var buttonSignin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSignin = findViewById<Button>(R.id.buttonSigin)
        buttonSignin.setOnClickListener {
            val it = Intent(this, HomeActivity::class.java)
            startActivity(it)
        }

        

    }
}
