package com.nicolator.miappdeprueba.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nicolator.miappdeprueba.R
import com.nicolator.miappdeprueba.data.SuperHeroDataRepository
import com.nicolator.miappdeprueba.data.remote.SuperHeroesApiRemoteDataSource
import com.nicolator.miappdeprueba.domain.ErrorApp
import com.nicolator.miappdeprueba.domain.GetAllSuperHeroesUseCase
import com.nicolator.miappdeprueba.domain.GetSuperHeroByIdUseCase
import com.nicolator.miappdeprueba.domain.SuperHero

class SuperHeroesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


        test()
    }

    fun test() {
        val api = SuperHeroesApiRemoteDataSource()
        val superHeroDataRepository = SuperHeroDataRepository(api)
        val getAllSuperHeroesUseCase = GetAllSuperHeroesUseCase(superHeroDataRepository)
        val getSuperHeroByIdUseCase = GetSuperHeroByIdUseCase(superHeroDataRepository)

        val viewModel = SuperHeroesListViewModel(
            getAllSuperHeroesUseCase,
            getSuperHeroByIdUseCase
        )

        val superHeroesList = viewModel.gotAll()

        superHeroesList.fold(
            { superHeroes ->
                isLoginSuccess(superHeroes)
            },
            { errorApp -> isFailure(errorApp as ErrorApp) }
        )
    }

    private fun isFailure(errorApp: ErrorApp) {
        Log.d("HeroesError", "Error: ${errorApp.javaClass.simpleName}")
    }

    private fun isLoginSuccess(superHeroes: List<SuperHero>) {
        Log.d(
            "HeroesSuccess", superHeroes.toString()
        )
    }

}