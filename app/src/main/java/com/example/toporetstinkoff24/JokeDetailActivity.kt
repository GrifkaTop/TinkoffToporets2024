package com.example.toporetstinkoff24

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JokeDetailActivity : AppCompatActivity() {

    private lateinit var textViewCategory: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var textViewAnswer: TextView

    var =

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_joke_detail)

        textViewCategory = findViewById(R.id.text_view_category)
        textViewQuestion = findViewById(R.id.text_view_question)
        textViewAnswer = findViewById(R.id.text_view_answer)


        val jokeId = intent.getStringExtra("joke_id") ?: return

        findViewById<Button>(R.id.button_back).setOnClickListener { finish() }

        loadJokeDetails(jokeId)
    }

    private fun loadJokeDetails(jokeId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val joke = { myApp: MyApp, jokeId: String -> myApp.getJoke(jokeId) }
            withContext(Dispatchers.Main) {
                if (joke != null) {
                    textViewCategory.text = joke.category
                    textViewQuestion.text = joke.question
                    textViewAnswer.text = joke.answer
                } else {
                    Log.e("JokeDetailActivity", "Joke not found for ID: $jokeId")
                }
            }
        }
    }
}
