package com.example.toporetstinkoff24

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.toporetstinkoff24.databinding.JokeItemBinding

class JokeAdapter(private var jokes: MutableList<Joke>) :
    RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(private val binding: JokeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(joke: Joke) {
            binding.jokeCategory.text = joke.category
            binding.jokeQuestion.text = joke.question
            binding.jokeAnswer.text = joke.answer

            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, JokeDetailActivity::class.java).apply {
                    putExtra("CATEGORY", joke.category)
                    putExtra("QUESTION", joke.question)
                    putExtra("ANSWER", joke.answer)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val binding = JokeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    override fun getItemCount() = jokes.size

    fun updateJokes(newJokes: List<Joke>) {
        jokes.clear()
        jokes.addAll(newJokes)
        notifyDataSetChanged()
    }
}

class JokeDiffCallback(
    private val oldList: List<Joke>, private val newList: List<Joke>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}