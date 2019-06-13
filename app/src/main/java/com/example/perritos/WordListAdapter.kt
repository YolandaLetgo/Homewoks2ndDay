package com.example.perritos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class WordListAdapter(private val mWordList: LinkedList<String>, context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){

    inner class WordViewHolder(itemView: View, private val mAdapter: WordListAdapter) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            // Get the position of the item that was clicked.
            val mPosition = layoutPosition

            // Use that to access the affected item in mWordList.
            val element = mWordList[mPosition]
            // Change the word in the mWordList.
            mWordList[mPosition] = "Clicked! $element"
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged()
        }
        val wordItemView: TextView = itemView.findViewById(R.id.word)
        init {
            itemView.setOnClickListener(this)
        }
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    private val mInflater: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false)
        return WordViewHolder(mItemView, this)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val mCurrent = mWordList[position]
        holder.wordItemView.text = mCurrent
    }

}
