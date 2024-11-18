package com.example.toporetstinkoff24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

@Suppress("DEPRECATION", "INFERRED_TYPE_VARIABLE_INTO_POSSIBLE_EMPTY_INTERSECTION")
class JokeDetailFragment : Fragment() {

    private lateinit var joke: Joke

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_joke_detail, container, false)
        joke = arguments?.getParcelable("joke")!!

        view.findViewById<TextView>(R.id.jokeQuestion).text = joke.question
        view.findViewById<TextView>(R.id.jokeAnswer).text = joke.answer

        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            requireActivity().onBackPressed()
        }

        return view
    }
}