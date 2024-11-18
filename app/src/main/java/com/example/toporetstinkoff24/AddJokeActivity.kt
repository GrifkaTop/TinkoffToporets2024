package com.example.toporetstinkoff24

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class AddJokeActivity : AppCompatActivity() {

    private lateinit var editTextCategory: EditText
    private lateinit var editTextQuestion: EditText
    private lateinit var editTextAnswer: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_joke)

        findViewById<Button>(R.id.button_add).setOnClickListener {
            addJoke()
        }
    }

    private fun addJoke() {
        val category = editTextCategory.text.toString()
        val question = editTextQuestion.text.toString()
        val answer = editTextAnswer.text.toString()

        if (category.isEmpty() || question.isEmpty() || answer.isEmpty()) {
            Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
            return
        }

        val id = UUID.randomUUID().toString()
        val newJoke = Joke(id, category, question, answer)
        (application as MyApp).addJoke(newJoke)

        finish()
    }
}