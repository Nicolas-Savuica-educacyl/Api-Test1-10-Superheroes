package com.nicolator.miappdeprueba.features.domain

interface SuperHeroRepository {
    suspend fun getAllSuperheroes(): Result<List<SuperHero>>
    suspend fun getSuperheroById(id: String): Result<SuperHero>
}