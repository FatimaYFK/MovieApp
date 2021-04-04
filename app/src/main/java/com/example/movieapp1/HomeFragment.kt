package com.example.movieapp1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.movieapp1.Movie
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.movieapp1.databinding.FragmentHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var tool: Toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.fragment_home)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_home)

        var movie1 = Movie()
        var movie2 = Movie()
        var movie3 = Movie()


        movie1.title = "Queen's Gambit"
        movie1.authors = "Scott Frank, Allan Scott"
        movie1.actors = "Anya Taylor-Joy, Ilja Roßbander, Vlad Chiriac"
        movie1.description = "Nachdem ihre Mutter tödlich verunglückt ist, kommt die neunjährige Beth Harmon (Isla Johnston) in den 1950er Jahren in ein Waisenhaus. Dort freundet sie sich mit dem Hausmeister Mr. Shaibel (Bill Camp) an, der ihr das Schachspielen beibringt. Schnell legt Beth ein außergewöhnliches Talent und mit ihm eine immer größere Leidenschaft für das Spiel der Könige an den Tag. Als sie Jahre später dann schließlich adoptiert wird, beginnt das Mädchen (jetzt: Anya Taylor-Joy), an Schachturnieren teilzunehmen und sich mehr und mehr einen Namen zu machen. Während sie bei zunehmend hochdotierten Wettkämpfen auch international für immer mehr Aufsehen sorgt, wächst allerdings auch der Druck – bis sie droht, sich in Medikamenten und Alkohol zu verlieren und so letztlich nicht nur ihre vielversprechende Karriere zu gefährden"
        movie1.genres = "Drama, Sport"
        movie1.rating = 4.1F
        binding.movie1 = movie1


        movie2.title = "Knives Out"
        movie2.authors = "Rian Johnson"
        movie2.actors = "Daniel Craig, Chris Evans, Ana de Armas"
        movie2.description = "Nachdem der Familienpatriarch und Krimiautor Harlan Thrombey (Christopher Plummer) am Morgen nach seinem 85. Geburtstag tot aufgefunden wird, entwickelt sich eine Familienfeier zu einem Kriminalfall. Die anwesenden Verwandten wollen natürlich nichts mitbekommen haben, werden aber dennoch von Privatdetektiv Benoit Blanc (Daniel Craig) und Lieutenant Elliott (Lakeith Stanfield) festgehalten, bis der Täter gefunden ist. Das passt den Gästen wie Ransom Drysdale (Chris Evans) und seinen Eltern Linda (Jamie Lee Curtis) und Richard Drysdale (Don Johnson) überhaupt nicht. Obwohl sich Thrombeys Partygesellschaft alles andere als kooperativ zeigt, kommt es im Laufe der Ermittlungen zu einigen überraschenden Wendungen und die Lage spitzt sich immer weiter zu. Blanc und seine Mitstreiter müssen sich durch ein verworrenes Netz aus Intrigen, Lügen und falschen Fährten kämpfen, um den mysteriösen Tod aufzuklären."
        movie2.genres = "Krimi, Drama, Komödie"
        movie2.rating = 4.2F
        binding.movie2 = movie2

        movie3.title = "Parasite"
        movie3.authors = "Bong Joon Ho"
        movie3.actors = "Song Kang-Ho, Woo-sik Choi, Park So-Dam"
        movie3.description = "Die vierköpfige Familie Kim ist schon sehr lange arbeitslos, weshalb der Vater Ki-taek (Kang-ho Song) zusammen mit seiner Frau Chung-sook (Hyae Jin Chang) und seinen Kindern Ki-woo (Woo-sik Choi) und Ki-jung (So-dam Park) in einem runtergekommenen Keller unter ärmlichen Bedingungen haust. Wenn sie sich nicht gerade mit Aushilfsjobs, wie dem Zusammenfalten von Pizzakartons über Wasser halten, versuchen sie in die hintersten Winkel ihrer Behausung zu kommen, um etwas vom WLAN der anderen Mitbewohner abzugreifen. Als der jüngste Sprössling es schafft, bei der gut situierten Familie Park einen Job als Nachhilfelehrer an Land zu ziehen, bietet das der Familie einen Ausweg aus der Arbeitslosigkeit. Kaum in der noblen Villa des reichen Geschäftsmanns Mr. Park (Sun-kyun Lee) und seiner Frau Yeon-kyo (Yeo-Jeong Cho) angekommen, sorgt Ki-woo dafür, dass alle anderen Bediensteten der Parks durch seine Familienmitglieder ersetzt werden. Doch was dann folgt, stellt alles vorangegangene in den Schatten"
        movie3.genres = "Action, Adventure, Sci-Fi"
        movie3.rating = 4.3F
        binding.movie3 = movie3


        val button1 = findViewById<Button>(R.id.button1);
        button1.setOnClickListener {
            val intent = Intent(this, Detail::class.java)
            intent.putEXtra("movie", movie1)
            
        }

        val button2 = findViewById<Button>(R.id.button2);
        button2.setOnClickListener {
            val intent = Intent(this, Detail::class.java)
            intent.putExtra("movie", movie2)
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.button3);
        button3.setOnClickListener {
            val intent = Intent(this, Detail::class.java)
            intent.putExtra("movie", movie3)
            startActivity(intent)
        }

        tool = findViewById(R.id.mytool) as Toolbar
        tool.setTitle("Home")
       // setSupportActionBar(tool)

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

private fun Intent.putEXtra(s: String, movie1: Movie) {

}

fun Any.putExtra(s: String, movie2: Movie) {

}




