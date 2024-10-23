package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.MusicaAdapter
import com.example.myapplication.models.Musica
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerMusica)

        // Lista de canciones
        val canciones = listOf(
            Musica("Problemon", "Álvaro Díaz", "Trap", R.drawable.img),
            Musica("Brilloteo", "Álvaro Díaz", "Reguetón", R.drawable.img_1),
            Musica("Llori Pari", "Álvaro Díaz", "Pop Urbano", R.drawable.img_2)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MusicaAdapter(canciones) { musica ->
            val intent = Intent(this, MusicaDetailActivity::class.java).apply {
                putExtra("titulo", musica.titulo)
                putExtra("artista", musica.artista)
                putExtra("genero", musica.genero)
                putExtra("portada", musica.portada)
            }
            startActivity(intent)
        }
    }
}
