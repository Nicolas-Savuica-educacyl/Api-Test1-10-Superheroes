package com.nicolator.miappdeprueba.features.domain

class GetAllSuperHeroesUseCase(private val repository: SuperHeroRepository) {
    suspend operator fun invoke(): Result<List<SuperHero>> {
        val superHero = repository.getAllSuperheroes()
        return superHero
    }
}