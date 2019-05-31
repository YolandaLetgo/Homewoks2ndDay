package com.example.perritos

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_form.*


class AddDoggoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()

    }

    private fun initListeners() {
        btnHugeDog.setOnClickListener {
            onClickHugeDog()
        }

    }

    fun onClickFormActivity(view: View) {
        val formactivityIntent = Intent(this, FormActivity::class.java)
        startActivity(formactivityIntent)
    }

    private fun onClickHugeDog() {
        val hugedogIntent = Intent(this, HugeDogActivity::class.java)
        startActivity(hugedogIntent)

    }

    fun onClickTinyDog() {
        val tinydogIntent = Intent(this, btnTinyDog::class.java)
        startActivity(tinydogIntent)
    }
}


