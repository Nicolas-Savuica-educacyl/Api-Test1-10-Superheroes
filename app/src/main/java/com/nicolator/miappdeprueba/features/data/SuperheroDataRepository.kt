package com.nicolator.miappdeprueba.features.data

import com.nicolator.miappdeprueba.features.data.remote.SuperHeroesApiRemoteDataSource
import com.nicolator.miappdeprueba.features.domain.SuperHero
import com.nicolator.miappdeprueba.features.domain.SuperHeroRepository

class SuperheroDataRepository(val apiDataSource: SuperHeroesApiRemoteDataSource) : SuperHeroRepository{
    override suspend fun getAllSuperheroes(): Result<List<SuperHero>> {
       return apiDataSource.getSuperHeroes()
    }

    override suspend fun getSuperheroById(id: String): Result<SuperHero> {
        return apiDataSource.getSuperHeroById(id)
    }

}