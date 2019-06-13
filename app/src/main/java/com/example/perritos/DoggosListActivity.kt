package com.example.perritos

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_doggos_list.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class DoggosListActivity : AppCompatActivity() {
    private val mWordList = LinkedList<String>()
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: WordListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doggos_list)
        setSupportActionBar(toolbar)
        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView?
        // Create an adapter and supply the data to be displayed.
        mAdapter = WordListAdapter(mWordList, this)
        // Connect the adapter with the RecyclerView.
        mRecyclerView?.adapter = mAdapter
        // Give the RecyclerView a default layout manager.
        mRecyclerView?.layoutManager = LinearLayoutManager(this)

    }
    private fun doggoList() = listOf(
        Doggo("Runa", "8 years", "Big", R.drawable.ath1),
        Doggo("Snowy", "2 months", "Big", R.drawable.ath2),
        Doggo("Luca", "8 months", "Medium", R.drawable.chino1),
        Doggo("Chispi", "2 years", "Small", R.drawable.chino2),
        Doggo("Willy", "6 months", "Big", R.drawable.xolo1),
        Doggo("Coco", "3 years", "Small", R.drawable.xolo2),
        Doggo("Balto", "3 months", "Big", R.drawable.peru1),
        Doggo("Boby", "2 months", "Big", R.drawable.peru2)
    )
}


