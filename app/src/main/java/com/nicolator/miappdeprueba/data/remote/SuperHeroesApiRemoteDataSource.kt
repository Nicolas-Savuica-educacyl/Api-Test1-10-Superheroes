package com.nicolator.miappdeprueba.data.remote

import com.nicolator.miappdeprueba.domain.SuperHero

class SuperHeroesApiRemoteDataSource {
    fun getSuperHeroes(): Result<List<SuperHero>> {
        return Result.success(listOf(SuperHero("", "", "", "")))
    }
}