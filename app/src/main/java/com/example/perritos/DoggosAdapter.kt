package com.example.perritos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DoggosAdapter(val doggos: List<Doggo>, context: Context) : RecyclerView.Adapter<DoggosAdapter.DoggoViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoggoViewHolder {
        val itemView = inflater.inflate(R.layout.wordlist_item, parent, false)
        return DoggoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return doggos.size
    }

    override fun onBindViewHolder(holder: DoggoViewHolder, position: Int) {
        val current = doggos[position]

    }

    inner class DoggoViewHolder(view:View): RecyclerView.ViewHolder(view)



}

