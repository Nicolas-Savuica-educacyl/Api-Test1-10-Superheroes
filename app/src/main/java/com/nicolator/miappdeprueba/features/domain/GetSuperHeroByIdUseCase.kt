package com.nicolator.miappdeprueba.features.domain

class GetSuperHeroByIdUseCase(private val repository: SuperHeroRepository) {
    suspend operator fun invoke(id: String): Result<SuperHero> {
        val superHeroes = repository.getSuperheroById(id)
        return superHeroes
    }
}