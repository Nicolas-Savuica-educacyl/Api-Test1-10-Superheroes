package com.nicolator.miappdeprueba.domain

class GetSuperHeroByIdUseCase(private val repository: SuperHeroRepository) {
    operator fun invoke(id: String): Result<SuperHero> {
        val superHeroes = repository.getSuperheroById(id)

        return superHeroes
    }
}