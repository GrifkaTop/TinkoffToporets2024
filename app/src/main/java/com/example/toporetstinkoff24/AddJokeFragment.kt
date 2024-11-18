package com.example.toporetstinkoff24

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddJokeFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_add_joke, container, false)

        view.findViewById<Button>(R.id.saveButton).setOnClickListener {
            val question = view.findViewById<EditText>(R.id.questionEditText).text.toString()
            val answer = view.findViewById<EditText>(R.id.answerEditText).text.toString()
            val category = view.findViewById<EditText>(R.id.categoryEditText).text.toString()


            findNavController().popBackStack()
        }

        return view
    }

}
