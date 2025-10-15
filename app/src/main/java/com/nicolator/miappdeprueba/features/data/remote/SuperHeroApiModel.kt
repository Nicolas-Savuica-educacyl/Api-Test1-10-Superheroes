package com.nicolator.miappdeprueba.features.data.remote

data class SuperHeroApiModel (val id: String,
                         val name: String,
                         val slug: String,
                        val images: SuperHeroImages)

data class SuperHeroImages(
    val xs: String,
    val xm: String,
    val md: String,
    val lg: String
)