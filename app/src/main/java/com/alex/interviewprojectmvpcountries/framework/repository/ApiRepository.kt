package com.alex.interviewprojectmvpcountries.framework.repository

import com.alex.interviewprojectmvpcountries.framework.network.ApiService
import com.alex.interviewprojectmvpcountries.framework.network.Resource
import com.alex.interviewprojectmvpcountries.framework.network.model.Continent
import com.alex.interviewprojectmvpcountries.framework.network.model.Country
import com.alex.interviewprojectmvpcountries.framework.repository.contracts.ApiRepositoryContract

class ApiRepository(
    private val apiService:ApiService,
) : ApiRepositoryContract {
    override suspend fun fetchContinents(): Resource<List<Continent>> {
        val i = apiService.getContinentsAsync().await()
        return if(!i.hasErrors()){
            Resource.success(i.data!!.continents().map { Continent(it.name(),it.code()) })
        }else{
            Resource.error("Something went wrong",null)
        }
    }

    override suspend fun fetchCountries(code: String): Resource<List<Country>> {
        val i = apiService.getCountriesAsync(code).await()
        return if(!i.hasErrors()){
            Resource.success(i.data!!.continent()!!.countries().map {
                Country(
                    name = it.name(),
                    native = it.native_(),
                    phone = it.phone(),
                    capital = it.capital(),
                    currency = it.currency(),
                    emojiU = it.emojiU()
                )
            })
        }else{
            Resource.error("Something went wrong",null)
        }
    }
}
