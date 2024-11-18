package com.example.toporetstinkoff24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JokeListFragment : Fragment() {
    private lateinit var jokeAdapter: JokeAdapter
    private val jokes = mutableListOf<Joke>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_joke_list, container, false)
        jokeAdapter = JokeAdapter(jokes) { joke -> findNavController().navigate(R.id.action_jokeListFragment_to_jokeDetailFragment) }
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = jokeAdapter

        view.findViewById<Button>(R.id.addJokeButton).setOnClickListener {
            findNavController().navigate(R.id.action_jokeListFragment_to_addJokeFragment)
        }

        loadJokes()
        return view
    }

    private fun loadJokes() {
        lifecycleScope.launch {
            delay(2000)
        }
    }
}