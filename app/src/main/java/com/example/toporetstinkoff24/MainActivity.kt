package com.example.toporetstinkoff24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var jokeAdapter: JokeAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        val jokes = mutableListOf(
            Joke(
                "Тест",
                "??????????????????????????????",
                "БАБАББАБАБАББАБАББАБАБАБАБАБУБАУБАБУБАУБАУБАБУАБУБАУБАУБАБУБАУББУАБУБАБАУБУАБАБАУБУАБАУБУАБУАБАУБУБАУБУАБУБУАБАУБУАБАУБУАБУА"
            ),
            Joke(
                "Наука",
                "Почему ученые не доверяют атомам?",
                "Потому что они все составляют."
            ),
            Joke(
                "Математика",
                "Почему 6 боится 7?",
                "Потому что 7 8 (съел) 9."
            ),
            Joke(
                "Животные",
                "Почему коты не любят компьютеры?",
                "Потому что они боятся мышей."
            ),
            Joke(
                "Спорт",
                "Почему футболисты не могут играть в прятки?",
                "Потому что они всегда попадают в офсайд."
            ),
            Joke(
                "Еда",
                "Почему ананас никогда не выигрывает в покер?",
                "Потому что он всегда показывает свои колоды."
            ),
            Joke(
                "Отношения",
                "Почему отношения как код?",
                "Если не компилируются, надо искать баги."
            ),
            Joke(
                "Путешествия",
                "Что говорит один чемодан другому?",
                "Давай, у нас много мест, куда поехать!"
            ),
            Joke(
                "История",
                "Почему история всегда скучна?",
                "Потому что она никогда не меняется!"
            ),
            Joke(
                "Музыка",
                "Почему музыканты всегда берут с собой лестницу?",
                "Чтобы достать высокие ноты!"
            )
        )

        jokeAdapter = JokeAdapter(jokes)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = jokeAdapter
    }
}