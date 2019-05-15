package com.example.perritos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner


class FormActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dogform)
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
        val spinner: Spinner? = findViewById(R.id.lbSpinnerRaza)
        spinner?.onItemSelectedListener = this
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter
            .createFromResource(this, R.array.lbSpinnerRaza, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = adapter
    }
}

