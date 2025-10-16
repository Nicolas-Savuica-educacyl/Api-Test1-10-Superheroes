package com.nicolator.miappdeprueba.features.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolator.miappdeprueba.R
import com.nicolator.miappdeprueba.core.api.ApiClient
import com.nicolator.miappdeprueba.features.data.SuperheroDataRepository
import com.nicolator.miappdeprueba.features.data.remote.SuperHeroesApiRemoteDataSource
import com.nicolator.miappdeprueba.features.domain.ErrorApp
import com.nicolator.miappdeprueba.features.domain.GetAllSuperHeroesUseCase
import com.nicolator.miappdeprueba.features.domain.SuperHero

class SuperHeroesListActivity : AppCompatActivity() {

    private val viewModel = SuperHeroesListViewModel(
        GetAllSuperHeroesUseCase(
            SuperheroDataRepository(
                SuperHeroesApiRemoteDataSource( ApiClient())
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupObserver()

    }


    private fun setupObserver() {
         val observer = Observer<SuperHeroesListViewModel.UiState>{ uiState ->
            //el viewmodel me pasa el uiState

             if (uiState.isloading){
                 //muestro un spinner
             }else {
                 //oculto el spinner
             }


             uiState.error?.let {
                //visualizar pantalla de error
            } ?: {
                //ocultar error
             }


             uiState.superheroes?.let { superHeroes ->
                 superHeroes


                 findViewById<RecyclerView>(R.id.amRvSuperheores).layoutManager = LinearLayoutManager(this)
                 findViewById<RecyclerView>(R.id.amRvSuperheores).adapter = AdaptadorSuperheroes(
                     superHeroes as ArrayList<SuperHero>, this)

             }

         }
        viewModel.uiState.observe(this, observer)
    }


    private fun isFailure(errorApp: ErrorApp) {
        Log.d("HeroesError", "Error: ${errorApp.javaClass.simpleName}")
    }

    private fun isSuccess(superHeroes: List<SuperHero>) {
        Log.d(
            "HeroesSuccess", superHeroes.toString()
        )
    }

}