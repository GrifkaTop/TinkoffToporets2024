package com.example.toporetstinkoff24

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter(private val jokes: List<Joke>, private val onClick: (Joke) -> Unit) : RecyclerView.Adapter<JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return JokeViewHolder(inflater.inflate(R.layout.item_joke, parent, false))
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position], onClick)
    }

    override fun getItemCount(): Int = jokes.size
}
