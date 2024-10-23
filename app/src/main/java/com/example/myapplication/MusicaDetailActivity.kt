package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MusicaDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musica_detail)

        val titulo = findViewById<TextView>(R.id.txtTituloDetail)
        val artista = findViewById<TextView>(R.id.txtArtistaDetail)
        val genero = findViewById<TextView>(R.id.txtGeneroDetail)
        val portada = findViewById<ImageView>(R.id.imgPortadaDetail)

        intent?.let {
            titulo.text = it.getStringExtra("titulo")
            artista.text = it.getStringExtra("artista")
            genero.text = it.getStringExtra("genero")
            portada.setImageResource(it.getIntExtra("portada", 0))
        }
    }
}
