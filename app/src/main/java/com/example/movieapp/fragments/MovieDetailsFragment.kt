package com.example.movieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.movieapp.R
import com.example.movieapp.api.MovieApi
import com.example.movieapp.models.Movie
import org.w3c.dom.Text
import java.lang.Long.parseLong

class MovieDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if(bundle!=null){
            val movieId = bundle.getLong("movieId")

            val movie: Movie = MovieApi.getMovieById(movieId)

            val movieDetailsId = view.findViewById<TextView>(R.id.movieDetailsId)
            val movieDetailsName = view.findViewById<TextView>(R.id.movieDetailsName)
            val movieDetailsDesc = view.findViewById<TextView>(R.id.movieDetailsDesc)
            val movieDetailsDirector = view.findViewById<TextView>(R.id.movieDetailsDirector)
            val movieDetailsActors = view.findViewById<TextView>(R.id.movieDetailsActors)

            movieDetailsId.text = "Id:" + movie.id.toString()
            movieDetailsName.text = "Name: " + movie.name
            movieDetailsDesc.text = "Description: "+movie.description
            movieDetailsDirector.text = "Director: "+movie.director
            movieDetailsActors.text ="Actors:\n" + movie.actors.map{
                a -> a.plus("\n")
            }
        }
    }
}