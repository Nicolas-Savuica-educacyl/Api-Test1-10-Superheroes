package com.nicolator.miappdeprueba.data

import com.nicolator.miappdeprueba.data.remote.SuperHeroesApiRemoteDataSource
import com.nicolator.miappdeprueba.domain.SuperHero
import com.nicolator.miappdeprueba.domain.SuperHeroRepository

class SuperHeroDataRepository(private val apiRemoteDataSource: SuperHeroesApiRemoteDataSource) :
    SuperHeroRepository {
    override fun getAllSuperheroes(): Result<List<SuperHero>> {
        return apiRemoteDataSource.getSuperHeroes()
    }

    override fun getSuperheroById(id: String): Result<SuperHero> {
        return apiRemoteDataSource.getSuperHeroById(id)
    }

}