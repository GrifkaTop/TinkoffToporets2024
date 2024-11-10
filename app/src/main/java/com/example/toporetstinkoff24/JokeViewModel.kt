package com.example.toporetstinkoff24

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JokeViewModel : ViewModel() {
    private val _jokes = MutableLiveData<List<Joke>>()
    val jokes: LiveData<List<Joke>> get() = _jokes

    private val repository: JokeRepository = JokeRepositoryImpl()

    fun loadJokes() {
        _jokes.value = repository.getJokes()
    }
}