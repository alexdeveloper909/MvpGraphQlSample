package com.alex.interviewprojectmvpcountries.framework.network

import GetContinentsQuery
import GetCountriesQuery
import com.apollographql.apollo.coroutines.toDeferred

object ApiService {

    fun getContinentsAsync() = ApiClient.client.query(GetContinentsQuery()).toDeferred()

    fun getCountriesAsync(code:String) = ApiClient.client.query(GetCountriesQuery(code)).toDeferred()


}