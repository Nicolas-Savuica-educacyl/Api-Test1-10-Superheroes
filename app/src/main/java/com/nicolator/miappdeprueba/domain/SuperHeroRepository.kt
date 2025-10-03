package com.nicolator.miappdeprueba.domain

interface SuperHeroRepository {
    fun getAllSuperheroes(): Result<List<SuperHero>>
    fun getSuperheroById(id: String): Result<SuperHero>
}