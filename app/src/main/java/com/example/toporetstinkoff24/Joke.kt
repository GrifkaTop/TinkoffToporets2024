package com.example.toporetstinkoff24

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

data class Joke(
    val category: String, val question: String, val answer: String
)

class JokeAdapter(private val jokes: List<Joke>) :
    RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.joke_question)
        val answerTextView: TextView = itemView.findViewById(R.id.joke_answer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokes[position]
        holder.questionTextView.text = joke.question
        holder.answerTextView.text = joke.answer
    }

    override fun getItemCount() = jokes.size
}