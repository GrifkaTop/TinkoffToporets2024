package com.example.toporetstinkoff24

import android.app.Application
import androidx.lifecycle.MutableLiveData

class MyApp : Application() {

    private val _jokesList = MutableLiveData<List<Joke>>(emptyList())
    private val jokesList = ArrayList<Joke>()

    fun addJoke(joke: Joke) {
        jokesList.add(joke)
    }

    fun getJokes(): List<Joke> {
        return jokesList
    }

    fun getJoke(jokeId: String): Joke? {
        return _jokesList.value?.find { it.id == jokeId }
    }
}