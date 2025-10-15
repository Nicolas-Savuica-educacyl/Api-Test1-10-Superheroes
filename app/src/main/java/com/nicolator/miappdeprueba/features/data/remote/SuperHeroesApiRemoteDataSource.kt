package com.nicolator.miappdeprueba.features.data.remote

import com.nicolator.miappdeprueba.core.api.ApiClient
import com.nicolator.miappdeprueba.features.domain.ErrorApp
import com.nicolator.miappdeprueba.features.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SuperHeroesApiRemoteDataSource (private val apiClient: ApiClient){

    val apiService = apiClient.createService(SuperHeroApiService::class.java)

    val responseSuperHero = apiService.findAll()
    suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        return withContext(Dispatchers.Main) {
            val apiService = apiClient.createService(SuperHeroApiService::class.java)
            val resultSuperHero = apiService.findAll().execute()
            if (resultSuperHero.isSuccessful && resultSuperHero.errorBody() == null) {
                val listSuperHeroApiModel: List<SuperHeroApiModel> = resultSuperHero.body()!!
                val listSuperHero = listSuperHeroApiModel.map { superHeroApiModel ->
                    superHeroApiModel.toModel()
                }
                return@withContext Result.success(listSuperHero)

            }
            return@withContext Result.failure(ErrorApp.UnknownError)
        }
    }
    fun getSuperHeroById(id: String): Result<SuperHero> {
        return Result.success(
            SuperHero(id, "Spider-Man", "spider-man", "https://example.com/spiderman.jpg")
        )
    }
}