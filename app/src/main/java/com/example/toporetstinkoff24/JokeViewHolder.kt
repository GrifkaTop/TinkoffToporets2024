package com.example.toporetstinkoff24

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val questionTextView: TextView = itemView.findViewById(R.id.questionText)

    fun bind(joke: Joke, onClick: (Joke) -> Unit) {
        questionTextView.text = if (joke.answer.length > 50) "${joke.answer.take(47)}..." else joke.answer

        itemView.setOnClickListener { onClick(joke) }
    }
}
