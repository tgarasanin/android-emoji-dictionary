package com.example.emojidictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager : GridLayoutManager
    val TAG = "LRN"
    lateinit var adapter: EmojiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = GridLayoutManager(this, 3)
        recycleView.layoutManager = layoutManager
        Log.d(TAG, "MY message")


        adapter = EmojiAdapter(arrayListOf("🤓", "😱", "🙃", "🦉", "🐈"))
        recycleView.adapter = adapter
    }
}
