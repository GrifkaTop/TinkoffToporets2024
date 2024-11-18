import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toporetstinkoff24.Joke
import com.example.toporetstinkoff24.R

class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
    private val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
    private val answerTextView: TextView = itemView.findViewById(R.id.answerTextView)

    fun bind(joke: Joke, clickListener: (Joke) -> Unit) {
        categoryTextView.text = joke.category
        questionTextView.text = joke.question

        // Ограничиваем длину ответа до 50 символов с добавлением "..."
        answerTextView.text = if (joke.answer.length > 50) "${joke.answer.take(50)}..." else joke.answer

        itemView.setOnClickListener { clickListener(joke) }
    }
}