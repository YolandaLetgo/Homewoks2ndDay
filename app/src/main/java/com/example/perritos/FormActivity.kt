package com.example.perritos

import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_tiny_dog.imageView


class FormActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        createSpinner1()
        createSpinner2()
    }

    private fun createSpinner1() {
        val spinner: Spinner? = findViewById(R.id.lbSpinnerSize)
        spinner?.onItemSelectedListener = this
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter
            .createFromResource(this, R.array.lbSpinnerSize, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = adapter
    }

    private fun createSpinner2() {
        val spinner: Spinner? = findViewById(R.id.lbSpinnerBreed)
        spinner?.onItemSelectedListener = this
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter
            .createFromResource(this, R.array.lbSpinnerBreed, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = adapter
    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked: Boolean = (view as? RadioButton)?.isChecked == true
        // Check which radio button was clicked.
        when (view.id) {
            R.id.rbFemale -> {
                if (checked) {
                }
            }
            R.id.rbMale -> {
                if (checked) {
                }
            }
        }
    }
    fun onClickTakePhoto(view: View) {
        val takephotoIntent = Intent(this, btnPhoto::class.java)
        startActivity(takephotoIntent)

    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

    fun displayDogInfo(view: View) {
        val name = etName.text.toString()
        val age = etAge.text.toString()

        val gender = if (rbMale.isChecked) "male" else "female"

        val breedArray = resources.getStringArray(R.array.lbSpinnerBreed)
        val positionBreed = lbSpinnerBreed.selectedItemPosition
        val breed = breedArray[positionBreed]

        val sizeArray = resources.getStringArray(R.array.lbSpinnerSize)
        val positionSize = lbSpinnerSize.selectedItemPosition
        val size = sizeArray[positionSize]


        displayDog(name, age, breed, size, gender)
    }

    fun displayDog(name: String, age: String, breed: String , size: String, gender: String) {
        var intent = Intent(this, ShowDogActivity::class.java)
        intent.putExtra(ShowDogActivity.NAME, name)
        intent.putExtra(ShowDogActivity.AGE, age)
        intent.putExtra(ShowDogActivity.BREED, breed)
        intent.putExtra(ShowDogActivity.SIZE,size)
        intent.putExtra(ShowDogActivity.GENDER, gender)
        startActivity(intent)
    }
}

