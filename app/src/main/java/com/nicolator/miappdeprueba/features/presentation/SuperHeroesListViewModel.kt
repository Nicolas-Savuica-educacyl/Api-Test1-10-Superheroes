package com.nicolator.miappdeprueba.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicolator.miappdeprueba.features.domain.ErrorApp
import com.nicolator.miappdeprueba.features.domain.GetAllSuperHeroesUseCase
import com.nicolator.miappdeprueba.features.domain.SuperHero
import kotlinx.coroutines.launch

class SuperHeroesListViewModel ( val getAll: GetAllSuperHeroesUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState


    fun loadAllSuperHeroes(){
        //ejecuto el caso de uso
        viewModelScope.launch {

            _uiState.value = UiState(isloading = true)


            getAll().fold(
                {onSuccess(superheroes = it)},

                {onError(it as ErrorApp)}
            )


            //UI

        }

    }

    private fun onSuccess(superheroes : List<SuperHero>){
        _uiState.value = UiState(superheroes = superheroes)
    }
    private fun onError(error : ErrorApp){
        _uiState.value
    }
    data class UiState(
        val error: ErrorApp? = null,
        val isloading : Boolean = false,
        val superheroes: List<SuperHero>? = null
    )
}