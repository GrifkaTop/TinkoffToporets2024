package com.example.toporetstinkoff24

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.content.Intent

data class Joke(
    val category: String, val question: String, val answer: String
)

class JokeAdapter(private val jokes: MutableList<Joke>) :
    RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.joke_category)
        val questionTextView: TextView = itemView.findViewById(R.id.joke_question)
        val answerTextView: TextView = itemView.findViewById(R.id.joke_answer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokes[position]
        holder.categoryTextView.text = joke.category
        holder.questionTextView.text = joke.question
        holder.answerTextView.text = joke.answer

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, JokeDetailActivity::class.java).apply {
                putExtra("CATEGORY", joke.category)
                putExtra("QUESTION", joke.question)
                putExtra("ANSWER", joke.answer)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = jokes.size

    fun updateJokes(newJokes: List<Joke>) {
        val diffCallback = JokeDiffCallback(jokes, newJokes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        jokes.clear()
        jokes.addAll(newJokes)
        diffResult.dispatchUpdatesTo(this)
    }


}

class JokeDiffCallback(
    private val oldList: List<Joke>, private val newList: List<Joke>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].answer == newList[newItemPosition].answer && oldList[oldItemPosition].question == newList[newItemPosition].question && oldList[oldItemPosition].category == newList[newItemPosition].category
    }
}