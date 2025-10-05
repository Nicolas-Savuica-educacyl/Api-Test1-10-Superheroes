package com.nicolator.miappdeprueba.domain

import com.nicolator.miappdeprueba.data.SuperHeroDataRepository
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GetAllSuperHeroesUseCaseTest {

    @Test
    fun `when invoke request a Result of List of superheroes` () {

        //given
        val superHeroesList = listOf(
            SuperHero( "1",  "Superman", "", ""),
            SuperHero( "2",  "Batman", "", "")
        )
        val expected = Result.success(superHeroesList)

        val dataRepositoryMockk = mockk<SuperHeroDataRepository>(relaxed = true)
        coEvery { dataRepositoryMockk.getAllSuperheroes() } returns expected

        val getAllSuperHeroesUseCase = GetAllSuperHeroesUseCase(dataRepositoryMockk)

        //when
        val result = getAllSuperHeroesUseCase.invoke()

         //then

        verify (exactly = 1) { dataRepositoryMockk.getAllSuperheroes()  }
        assertEquals(expected, result)

    }




}