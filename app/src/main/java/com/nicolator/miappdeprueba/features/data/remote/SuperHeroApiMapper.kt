package com.nicolator.miappdeprueba.features.data.remote

import com.nicolator.miappdeprueba.features.domain.SuperHero

fun SuperHeroApiModel.toModel(): SuperHero{
    return SuperHero(
        this.id,
        this.name,
        this.slug,
        this.images.md)
}