package com.example.movieapp1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class Favorites : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_watchlist_favorites)

        toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle("Favorites")
        setSupportActionBar(toolbar)

    }

    // Source: https://developer.android.com/guide/topics/ui/menus
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.myoption, menu)
        return true
    }

    // Source: https://developer.android.com/guide/topics/ui/menus
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.action_favorites -> {
                val intent = Intent(applicationContext, Favorites::class.java)
                startActivity(intent)
                true
            }
            R.id.action_movies -> {
                val intent = Intent(applicationContext, Home::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
