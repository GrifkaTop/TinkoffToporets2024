package com.example.toporetstinkoff24

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokesListAdapter(private val jokes: List<Joke>, private val onClick: (Joke) -> Unit) :
    RecyclerView.Adapter<JokesListAdapter.JokeViewHolder>() {

    inner class JokeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val categoryTextView: TextView = TextView(view.context)
        private val questionTextView: TextView = TextView(view.context)

        init {
            val layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            categoryTextView.layoutParams = layoutParams
            questionTextView.layoutParams = layoutParams

            (view as ViewGroup).addView(categoryTextView)

            itemView.setOnClickListener { onClick(jokes[adapterPosition]) }
        }

        fun bind(joke: Joke) {
            questionTextView.text = joke.question.truncate(50)
            itemView.setOnClickListener { onClick(joke) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_list_item, parent, false)
        return JokeViewHolder(view as ViewGroup)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    override fun getItemCount(): Int = jokes.size
}