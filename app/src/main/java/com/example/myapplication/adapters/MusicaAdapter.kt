package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Musica

class MusicaAdapter(
    private val musicas: List<Musica>,
    private val onItemClick: (Musica) -> Unit
) : RecyclerView.Adapter<MusicaAdapter.MusicaViewHolder>() {

    inner class MusicaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titulo = view.findViewById<TextView>(R.id.txtTitulo)
        private val artista = view.findViewById<TextView>(R.id.txtArtista)
        private val genero = view.findViewById<TextView>(R.id.txtGenero)
        private val portada = view.findViewById<ImageView>(R.id.imgPortada)

        fun bind(musica: Musica) {
            titulo.text = musica.titulo
            artista.text = musica.artista
            genero.text = musica.genero
            portada.setImageResource(musica.portada)

            itemView.setOnClickListener { onItemClick(musica) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_musica, parent, false)
        return MusicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicaViewHolder, position: Int) {
        holder.bind(musicas[position])
    }

    override fun getItemCount() = musicas.size
}