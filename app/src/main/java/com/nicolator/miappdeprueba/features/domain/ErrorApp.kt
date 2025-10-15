package com.nicolator.miappdeprueba.features.domain

sealed class ErrorApp : Throwable() {
    object InternetConnectionError : ErrorApp()
    object ServerError : ErrorApp()
    object UnknownError : ErrorApp()
}