package com.nicolator.miappdeprueba.data.remote

import com.nicolator.miappdeprueba.domain.ErrorApp
import com.nicolator.miappdeprueba.domain.SuperHero

class SuperHeroesApiRemoteDataSource {
    fun getSuperHeroes(): Result<List<SuperHero>> {
        return Result.success(
            listOf(
                SuperHero("1", "Spider-Man", "spider-man", "https://example.com/spiderman.jpg"),
                SuperHero("2", "Iron Man", "iron-man", "https://example.com/ironman.jpg"),
                SuperHero("3", "Batman", "batman", "https://example.com/batman.jpg")
            )
        )
        return Result.failure(ErrorApp.UnknownError)
    }

    fun getSuperHeroById(id: String): Result<SuperHero> {
        return Result.success(
            SuperHero(id, "Spider-Man", "spider-man", "https://example.com/spiderman.jpg")
        )
    }
}