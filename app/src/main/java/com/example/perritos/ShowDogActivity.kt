package com.example.perritos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_show_dog.*

class ShowDogActivity : AppCompatActivity() {

    companion object {

        const val NAME = "name"
        const val AGE = "age"
        const val BREED = "breed"
        const val SIZE = "size"
        const val GENDER = "gender"
        const val PHOTO = "photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_dog)

        val name = intent.getStringExtra(NAME)
        val age = intent.getStringExtra(AGE)
        val gender = intent.getStringExtra(GENDER)
        val breed = intent.getStringExtra(BREED)
        val size = intent.getStringExtra(SIZE)



        tvNameResult.text = name
        tvAgeResult.text = age
        tvGenderResult.text = gender
        tvBreedResult.text = breed
        tvSizeResult.text = size

        Log.d("ABG", "El nombre es $name, la edad $age y la raza es ")
    }
}
