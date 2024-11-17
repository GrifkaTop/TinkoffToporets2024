package com.example.toporetstinkoff24

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toporetstinkoff24.R

class JokeAdapter(private val jokes: List<Joke>, private val onClick: (Joke) -> Unit) :
    RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)

        @SuppressLint("SetTextI18n")
        fun bind(joke: Joke) {
            questionTextView.text =
                joke.question.take(50) + if (joke.question.length > 50) "..." else ""
            itemView.setOnClickListener { onClick(joke) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    override fun getItemCount(): Int = jokes.size
}