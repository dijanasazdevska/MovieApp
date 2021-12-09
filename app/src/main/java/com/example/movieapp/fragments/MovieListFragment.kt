package com.example.movieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.adapters.BasicRecyclerViewAdapter
import com.example.movieapp.adapters.MovieClickListener
import com.example.movieapp.api.MovieApi
import com.example.movieapp.models.Movie

class MovieListFragment : Fragment(), MovieClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.movieList)

        recyclerView.layoutManager = LinearLayoutManager(activity)

        val recyclerViewAdapter = activity?.let {
            BasicRecyclerViewAdapter(
                it,
                MovieApi.getMovies(),
            this)}

        recyclerView.adapter = recyclerViewAdapter
    }

    override fun onMovieClick(movie: Movie) {
        val bundle = Bundle()
        bundle.putLong("movieId",movie.id)
        findNavController().navigate(R.id.action_movieListFragment_to_movieDetailsFragment, bundle)

    }
}