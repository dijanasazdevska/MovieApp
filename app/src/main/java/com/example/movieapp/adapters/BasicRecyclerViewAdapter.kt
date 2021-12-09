package com.example.movieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.models.Movie

class BasicRecyclerViewAdapter(val context: Context, val movies: MutableList<Movie>, val movieClickListener: MovieClickListener) : RecyclerView.Adapter<BasicRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val movieId: TextView
        val movieName: TextView
        val movieDirector: TextView

        init{
            movieId = view.findViewById(R.id.movieId)
            movieName = view.findViewById(R.id.movieName)
            movieDirector = view.findViewById(R.id.movieDirector)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie: Movie = movies[position]

        holder.movieId.text = "Id: " + currentMovie.id.toString()
        holder.movieName.text = "Name: " + currentMovie.name
        holder.movieDirector.text = "Director: " + currentMovie.director
        holder.itemView.setOnClickListener{
            movieClickListener.onMovieClick(movies[position])
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
interface MovieClickListener {
    fun onMovieClick(movie: Movie)
}
