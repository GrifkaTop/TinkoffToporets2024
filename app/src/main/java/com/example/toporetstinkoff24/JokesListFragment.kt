import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toporetstinkoff24v4.R

class JokeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: JokeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_joke_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = JokeAdapter(JokeRepository.getJokes()) { joke ->
            openJokeDetailFragment(joke)
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun openJokeDetailFragment(joke: Joke) {
        val fragment = JokeDetailFragment.newInstance(joke)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
