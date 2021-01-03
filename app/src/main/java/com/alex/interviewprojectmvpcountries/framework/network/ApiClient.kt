package com.alex.interviewprojectmvpcountries.framework.network

import com.alex.interviewprojectmvpcountries.framework.network.Constants.BASE_URL
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

object ApiClient {
    val client:ApolloClient by lazy { getApolloClient()}

    private fun getApolloClient(): ApolloClient {
        val okHttp = OkHttpClient
            .Builder()
            .build()

        return ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttp)
            .build()
    }

}