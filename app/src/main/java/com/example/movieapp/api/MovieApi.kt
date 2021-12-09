package com.example.movieapp.api

import com.example.movieapp.models.Movie

class MovieApi {
    companion object {
       private val data: MutableList<Movie> = mutableListOf(
            Movie(
                1, "The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "Frank Darabont",
                mutableListOf("Tim Robbins",
                        "Morgan Freeman",
                        "Bob Gunton",
                        "William Sadler",
                        "Clancy Brown",
                        "Gil Bellows",
                        "James Whitmore")
            ),
           Movie(
                2, "The Godfather", "The Godfather follows Vito Corleone, Don of the Corleone family, as he passes the mantel to his unwilling son, Michael.", "Francis Ford Coppola",
                mutableListOf(
                        "Marlon Brando",
                        "Al Pacino",
                        "James Caan",
                        "Richard Castellano",
                        "Robert Duvall",
                        "Sterling Hayden",
                        "John Marley",
                        "Richard Conte",
                        "Diane Keaton")
            ),
           Movie(3, "The Godfather: Part II", "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.", "Francis Ford Coppola",
               mutableListOf(
                   "Al Pacino",
                   "Robert Duvall",
                   "Diane Keaton",
                   "Robert De Niro",
                   "Talia Shire",
                   "Morgana King",
                   "John Cazale",
                   "Mariana Hill",
                   "Lee Strasberg"
               )
           ),
           Movie(4, "The Good, the Bad and the Ugly", "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.","Sergio Leone",
           mutableListOf("Clint Eastwood",
                   "Eli Wallach",
                   "Lee Van Cleef",
                   "Aldo Giuffrè",
                   "Antonio Casas",
                   "Rada Rassimov",
                   "Aldo Sambrel",
                   "Enzo Petito",
                   "Luigi Pistilli",
                   "Livio Lorenzon",
                   "Al Mulloch",
                   "Sergio Mendizábal",
                   "Molino Rojo",
                   "Lorenzo Robledo",
                   "Mario Brega"))
        )

        fun getMovies(): MutableList<Movie> {
            return data;
        }

        fun addMovie(movie: Movie) {
            movie.id = data.size.toLong()+1
            data.add(movie)
        }

        fun getMovieById(id: Long): Movie {
            return data.filter { m ->
                m.id==id
            }[0]
        }
    }
}