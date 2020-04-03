package com.example.emojidictionary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item_row.view.*


class EmojiAdapter(val emojis: ArrayList<String>) :
    RecyclerView.Adapter<EmojiAdapter.TextHolder>() {

    class TextHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var view: View = v
        var emoji: String = ""

        fun bindEmoji(emoji: String) {
            this.emoji = emoji
            view.itemTextView.text = emoji
        }

        init {
            v.setOnClickListener(this)
        }

        // option + command + L -> formatting
        override fun onClick(v: View?) {
            val detailIntent = Intent(view.context, EmojiDetailActivity::class.java)
            detailIntent.putExtra("emoji", emoji)
            startActivity(view.context, detailIntent, null)
        }

    }

    override fun getItemCount(): Int {
        return emojis.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextHolder {
        return TextHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_view_item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EmojiAdapter.TextHolder, position: Int) {
        var emoji = emojis[position]
        holder.bindEmoji(emoji)
    }


}