package com.example.movieapp.models

class Movie {
    var id:Long = 0
    var name:String
    var description:String
    var director: String
    var actors: List<String>

    constructor(
        id: Long,
        name: String,
        description: String,
        director: String,
        actors: List<String>
    ) {
        this.id = id
        this.name = name
        this.description = description
        this.director = director
        this.actors = actors
    }

    constructor(name: String, description: String, director: String, actors: List<String>) {
        this.name = name
        this.description = description
        this.director = director
        this.actors = actors
    }


}