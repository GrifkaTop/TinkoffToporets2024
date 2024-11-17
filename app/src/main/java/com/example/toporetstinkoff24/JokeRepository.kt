package com.example.toporetstinkoff24

object JokeRepository {
    private var idCounter = 1

    fun getJokes(): List<Joke> {
        return listOf(
            Joke(
                idCounter++,
                "Christmas",
                "What does Santa suffer from if he gets stuck in a chimney?",
                "Claustrophobia!"
            ),
            Joke(
                idCounter++,
                "Science",
                "Why can't you trust an atom?",
                "Because they make up everything!"
            ),
            Joke(
                idCounter++,
                "Math",
                "Why was the equal sign so humble?",
                "Because it knew it wasn't less than or greater than anyone else!"
            ),
            Joke(
                idCounter++,
                "Programming",
                "Why do programmers prefer dark mode?",
                "Because light attracts bugs!"
            ),
            Joke(idCounter++, "Animals", "What do you call a bear with no teeth?", "A gummy bear!"),
            Joke(
                idCounter++,
                "Food",
                "Why did the tomato turn red?",
                "Because it saw the salad dressing!"
            ),
            Joke(idCounter++, "Music", "What kind of music do mummies listen to?", "Wrap music!")
        )
    }
}