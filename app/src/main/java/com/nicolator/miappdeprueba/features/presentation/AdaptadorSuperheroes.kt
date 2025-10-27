package com.nicolator.miappdeprueba.features.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.nicolator.miappdeprueba.R

import com.nicolator.miappdeprueba.features.domain.SuperHero
import kotlin.jvm.java

/* Creamos una clase adaptador que comunique las tarjetas con el RecyclerView. Para rellenar el RecyclerView, creamos un ArrayList que se irá rellenando con los datos
de cada uno de los elementos que necesitamos. También es necesario pasarle el contexto de la actividad. Esta clase heredará de la clase RecyclerView.Adapter que
define el comportamiento de una clase adaptador que sea capaz de comunicar cada uno de los elementos de la lista con el RecyclerView para visualizar en forma de lista
todos los elementos de la misma
 */
class AdaptadorSuperheroes (private var lista: ArrayList<SuperHero>, private var contexto: Context) : RecyclerView.Adapter<AdaptadorSuperheroes.ViewHolder>(){


    /* Clase auxiliar que rellena cada tarjeta con los correspondientes datos*/
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lista_superheroes, parent, false), contexto)

    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
       return lista.size
    }

    class ViewHolder(var vista: View, var contexto: Context) : RecyclerView.ViewHolder(vista){
        fun bind(superhero: SuperHero){
            Glide.with(contexto)
                .load(superhero.imageURL)
                .into(vista.findViewById(R.id.lsIvFoto))
            vista.findViewById<TextView>(R.id.lsTvNombre).text = superhero.name
            vista.findViewById<TextView>(R.id.lsTvSlug).text = superhero.slug

            vista.setOnClickListener {
                contexto.startActivity(Intent(contexto, CardPage::class.java).putExtra("sh", superhero))
            }
        }
    }
}