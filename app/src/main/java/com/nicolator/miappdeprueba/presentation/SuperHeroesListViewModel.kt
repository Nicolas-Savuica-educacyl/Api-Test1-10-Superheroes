package com.nicolator.miappdeprueba.presentation

import androidx.lifecycle.ViewModel
import com.nicolator.miappdeprueba.domain.GetAllSuperHeroesUseCase
import com.nicolator.miappdeprueba.domain.GetSuperHeroByIdUseCase
import com.nicolator.miappdeprueba.domain.SuperHero

class SuperHeroesListViewModel(
    private val getAllSuperHeroes: GetAllSuperHeroesUseCase,
    private val getSuperHeroById: GetSuperHeroByIdUseCase
) : ViewModel() {
    fun gotAll(): Result<List<SuperHero>> {
        return getAllSuperHeroes.invoke()
    }

    fun gotById(id: String): Result<SuperHero> {
        return getSuperHeroById.invoke(id)
    }
}