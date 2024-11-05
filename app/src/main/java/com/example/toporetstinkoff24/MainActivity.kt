package com.example.toporetstinkoff24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val jokes = listOf(
            Joke(
                "Общая",
                "Почему программисты не любят природу?",
                "Потому что там слишком много багов. Добавлено для проверки троечточия бабубэбаубауабау"
            ),
            Joke(
                "Общая",
                "Какой язык программирования самый оптимистичный?",
                "Java! Она всегда в хорошем настроении."
            ),
            Joke(
                "Общая",
                "Почему у моряков всегда хорошее настроение?",
                "Потому что они всегда под парусами."
            ),
            Joke(
                "Общая",
                "Что делает программист, когда у него плохое настроение?",
                "Он компилирует свои чувства."
            ),
            Joke("Общая", "Почему коты не любят компьютеры?", "Потому что они боятся мышей."),
            Joke(
                "Общая",
                "Какой самый популярный напиток программистов?",
                "Кофе! Без него код не компилируется. (да шутки писала нейросеть)"
            ),
            Joke("Общая", "Почему у программистов нет друзей?", "Потому что они всегда в цикле.")
        )
        val jokeAdapter = JokeAdapter(jokes)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = jokeAdapter
    }
}
