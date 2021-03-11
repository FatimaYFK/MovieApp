package com.example.movieapp1

import kotlin.properties.Delegates

class Movie {

    lateinit var title: String
    lateinit var description: String
    var rating: Float = 0.0f
    lateinit var genres: String
    lateinit var authors: String
    lateinit var actors: String
}