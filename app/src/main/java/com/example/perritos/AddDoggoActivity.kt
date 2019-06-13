package com.example.perritos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


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
        btnTinyDog.setOnClickListener {
            onClickTinyDog()
        }
        btnSeeMore.setOnClickListener {
            onClickSeeMore()
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

    private fun onClickTinyDog() {
        val tinydogIntent = Intent(this, TinyDogActivity::class.java)
        startActivity(tinydogIntent)
    }

    private fun onClickSeeMore() {
        val seemoreIntent = Intent(this, DoggosListActivity::class.java)
        startActivity(seemoreIntent)
    }
}


