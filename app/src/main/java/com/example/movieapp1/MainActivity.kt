package com.example.movieapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.movieapp1.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    //data binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var movie = Movie()
        movie.title = "Queen's Gambit"
        movie.authors = "Creator:"
        movie.actors = "Actors:"
        movie.description = "Story"
        movie.genres = "Drama, Sport"
        movie.rating
        binding.movie = movie




      val cookies: FloatingActionButton = findViewById(R.id.floatingActionButton2)
        cookies.setOnClickListener { cookie() }

    }

    private fun cookie(){
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

    }
}