package com.alex.interviewprojectmvpcountries.di

import com.alex.interviewprojectmvpcountries.framework.network.ApiService
import com.alex.interviewprojectmvpcountries.framework.repository.ApiRepository
import com.alex.interviewprojectmvpcountries.framework.repository.LocationsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideApiService() : ApiService{
        return ApiService
    }

    @Provides
    fun provideApiRepository(
        apiService:ApiService
    ): ApiRepository {
        return ApiRepository(apiService)
    }

    @Provides
    fun provideLocationsRepository() : LocationsRepository{
        return LocationsRepository
    }

}