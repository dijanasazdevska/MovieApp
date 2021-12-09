package com.example.movieapp.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.models.Movie

class AddMovieDialog : AppCompatDialogFragment(){

    lateinit var listener: AddMovieDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val layoutInflater = activity?.layoutInflater

        val view = layoutInflater?.inflate(R.layout.dialog_layout, null)

        var movieName: EditText? = view?.findViewById(R.id.dialogMovieName)
        var movieDesc: EditText? = view?.findViewById(R.id.dialogMovieDesc)
        var movieDirector: EditText? = view?.findViewById(R.id.dialogMovieDirector)
        var movieActors: EditText? = view?.findViewById(R.id.dialogMovieActors)

        builder.setView(view)
            .setTitle("Add new movie")
            .setPositiveButton("Save", DialogInterface.OnClickListener{ dialog, which ->
               var actors: List<String>? = movieActors?.text?.lines()
                if (actors != null) {
                    listener.setText(movieName = movieName?.text.toString(), movieDesc = movieDesc?.text.toString(), movieDirector = movieDirector?.text.toString(), movieActors = actors)
                }
                findNavController().navigate(R.id.movieListFragment)

            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialog, which ->
            })

        return builder.create()

    }
    fun setAddMovieDialogListener(listener: AddMovieDialogListener){
        this.listener = listener
    }

    interface AddMovieDialogListener {
        fun setText(movieName: String, movieDesc: String, movieDirector: String, movieActors: List<String>);

    }
}
