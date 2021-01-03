package com.alex.interviewprojectmvpcountries.framework.repository.contracts

import com.alex.interviewprojectmvpcountries.framework.network.Resource
import com.alex.interviewprojectmvpcountries.framework.network.model.Continent
import com.alex.interviewprojectmvpcountries.framework.network.model.Country

interface ApiRepositoryContract {
    suspend fun fetchContinents(): Resource<List<Continent>>
    suspend fun fetchCountries(code:String) : Resource<List<Country>>
}
