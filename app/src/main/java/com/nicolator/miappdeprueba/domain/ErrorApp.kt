package com.nicolator.miappdeprueba.domain

sealed class ErrorApp : Throwable() {
    object InternetConnectionError : ErrorApp()
    object ServerErrorApp : ErrorApp()
}