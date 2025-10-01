package com.nicolator.miappdeprueba.domain

class GetAllSuperHeroesUseCase(private val repository: SuperHeroRepository) {
    operator fun invoke(): Result<List<SuperHero>> {
        val superHero = repository.getAllSuperheroes()


        return superHero
    }
}