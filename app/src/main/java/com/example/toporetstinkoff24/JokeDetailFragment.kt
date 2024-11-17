package com.example.toporetstinkoff24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.toporetstinkoff24.R

class JokeDetailFragment : Fragment() {

    private lateinit var joke: Joke

    companion object {
        private const val ARG_JOKE = "joke"

        fun newInstance(joke: Joke): JokeDetailFragment {
            val fragment = JokeDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_JOKE, joke)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_joke_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.jokeQuestionTextView).text = joke.question
        view.findViewById<TextView>(R.id.jokeAnswerTextView).text = joke.answer

        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}