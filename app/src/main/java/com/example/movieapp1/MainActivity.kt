package com.example.movieapp1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var tool: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Source: https://www.youtube.com/watch?v=m1RV0HPuBWo
        drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        navigationView = findViewById(R.id.nav_view) as NavigationView
        tool = findViewById(R.id.mytool) as Toolbar

        // Source: https://guides.codepath.com/android/using-the-app-toolbar
        tool.setTitle("MainActivity")
       // setSupportActionBar(tool)

        // Source: https://www.youtube.com/watch?v=m1RV0HPuBWo
        navigationView.bringToFront()
        val toggle = ActionBarDrawerToggle(this, drawerLayout, tool, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
    }

    // Source: https://developer.android.com/guide/topics/ui/menus
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return true
    }

    // Source: https://developer.android.com/guide/topics/ui/menus
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.action_favorites -> {
                Toast.makeText(applicationContext, "Options Favorites tapped!",
                        Toast.LENGTH_SHORT).show();
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.nav_favorites -> {
                val intent = Intent(applicationContext, Favorites::class.java)
                startActivity(intent)
                true
            }
            R.id.nav_movies -> {
                val intent = Intent(applicationContext, Home::class.java)
                startActivity(intent)
                true
            }
            R.id.nav_detail -> {
                val intent = Intent(applicationContext, Detail::class.java)
                var movie = Movie()
                movie.title = "Queen's Gambit"
                movie.authors = "Scott Frank, Allan Scott"
                movie.actors = "Anya Taylor-Joy, Ilja Roßbander, Vlad Chiriac"
                movie.description = "Nachdem ihre Mutter tödlich verunglückt ist, kommt die neunjährige Beth Harmon (Isla Johnston) in den 1950er Jahren in ein Waisenhaus. Dort freundet sie sich mit dem Hausmeister Mr. Shaibel (Bill Camp) an, der ihr das Schachspielen beibringt. Schnell legt Beth ein außergewöhnliches Talent und mit ihm eine immer größere Leidenschaft für das Spiel der Könige an den Tag. Als sie Jahre später dann schließlich adoptiert wird, beginnt das Mädchen (jetzt: Anya Taylor-Joy), an Schachturnieren teilzunehmen und sich mehr und mehr einen Namen zu machen. Während sie bei zunehmend hochdotierten Wettkämpfen auch international für immer mehr Aufsehen sorgt, wächst allerdings auch der Druck – bis sie droht, sich in Medikamenten und Alkohol zu verlieren und so letztlich nicht nur ihre vielversprechende Karriere zu gefährden"
                movie.genres = "Drama, Sport"
                movie.rating = 4.1F

                intent.putExtra("movie", movie)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }
}
