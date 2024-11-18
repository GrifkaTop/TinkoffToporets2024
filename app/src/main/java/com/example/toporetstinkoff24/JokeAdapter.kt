package com.example.toporetstinkoff24

import JokeViewHolder
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toporetstinkoff24.R

class JokeAdapter(private val jokes: List<Joke>, private val clickListener: (Joke) -> Unit) : RecyclerView.Adapter<JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return JokeViewHolder(inflater.inflate(R.layout.item_joke, parent, false))
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position], clickListener)
    }

    override fun getItemCount(): Int = jokes.size
}