package com.alex.interviewprojectmvpcountries.framework.repository

import androidx.test.filters.LargeTest
import com.alex.interviewprojectmvpcountries.framework.network.ApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
@ExperimentalCoroutinesApi
@LargeTest
class ApiRepositoryTest {
    lateinit var apiService: ApiService
    lateinit var apiRepository: ApiRepository

    @Before
    fun setUp() {
        apiService = ApiService
        apiRepository = ApiRepository(apiService)
    }

    @Test
    @LargeTest
    fun fetchContinents() = runBlocking{
        val actual = apiRepository.fetchContinents().data!!.first().name
        val expected = "Africa"
        assertEquals(expected,actual)

    }

    @Test
    @LargeTest
    fun fetchCountries() = runBlocking{
        val actual = apiRepository.fetchCountries("AF").data!!.first().name
        val expected = "Africa"
        assertEquals(expected,actual)

    }

}