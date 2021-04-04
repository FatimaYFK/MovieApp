package com.example.movieapp1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.movieapp1.databinding.FragmentDetailBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Detail : AppCompatActivity() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var mytool: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_detail)
        binding.movie = intent.getParcelableExtra("movie")

        val fabButton: FloatingActionButton = findViewById(R.id.fab)
        fabButton.setOnClickListener { showToast() }

        mytool = findViewById(R.id.tool) as Toolbar
        mytool.setTitle("Detail")
        setSupportActionBar(mytool)

    }

    private fun showToast() {
        val text = "Hello toast!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(this, text, duration)
        toast.show()

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
