package com.example.toporetstinkoff24

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JokeListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var jokeAdapter: JokeAdapter
    //private lateinit var databaseHelper: delete   DatabaseHelper

    private val jokes = ArrayList<Joke>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_list)

        recyclerView = findViewById(R.id.recycler_view)
        jokeAdapter = JokeAdapter(jokes) { joke ->
            val intent = Intent(this, JokeDetailActivity::class.java).apply {
                putExtra("joke_id", joke.id)
            }
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = jokeAdapter

        findViewById<FloatingActionButton>(R.id.fab_add).setOnClickListener {
            startActivity(Intent(this, AddJokeActivity::class.java))
        }

        loadTestJokes()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadTestJokes() {
        jokes.add(Joke("1", "Общие", "Почему курица перешла дорогу?", "Чтобы попасть на другую сторону!"))
        jokes.add(Joke("2", "Общие", "Какой день недели самый короткий?", "Суббота!"))

        jokeAdapter.notifyDataSetChanged()
    }
}