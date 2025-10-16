package com.nicolator.miappdeprueba.features.domain

import java.io.Serializable

data class SuperHero(
    val id: String,
    val name: String,
    val slug: String,
    val imageURL: String,
) : Serializable{

}