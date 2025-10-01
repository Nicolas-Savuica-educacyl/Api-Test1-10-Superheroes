package com.nicolator.miappdeprueba.domain

data class SuperHero(
    val id: String,
    val name: String,
    val slug: String,
    val imageURL: String,
    val powerstats: Powerstats,
    val biography: Biography
) {

}