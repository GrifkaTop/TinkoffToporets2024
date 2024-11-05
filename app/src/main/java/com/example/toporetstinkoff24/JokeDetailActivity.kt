package com.example.toporetstinkoff24

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class JokeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_detail)

        val category = intent.getStringExtra("CATEGORY")
        val question = intent.getStringExtra("QUESTION")
        val answer = intent.getStringExtra("ANSWER")

        val categoryTextView: TextView = findViewById(R.id.detail_joke_category)
        val questionTextView: TextView = findViewById(R.id.detail_joke_question)
        val answerTextView: TextView = findViewById(R.id.detail_joke_answer)

        categoryTextView.text = category
        questionTextView.text = question
        answerTextView.text = answer

        val backButton: Button = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }
    }
}