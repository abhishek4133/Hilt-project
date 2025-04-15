package com.coredata.myapplication.di

import android.app.Application
import android.content.Context
import com.coredata.myapplication.MyApp
import com.coredata.myapplication.api.UniversityApi
import com.coredata.myapplication.client.ApiService.getRetrofitInstance
import com.coredata.myapplication.database.UniversityDao
import com.coredata.myapplication.database.UniversityDatabase
import com.coredata.myapplication.helper.Constant
import com.coredata.myapplication.repository.UniversityRepository
import com.coredata.myapplication.usecase.UniversityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUniversityApi(): UniversityApi {
        return getRetrofitInstance(Constant.BASE_URL).create(
            UniversityApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUniversityRepository(
        universityApi: UniversityApi
    ): UniversityRepository {
        return UniversityRepository(universityApi)
    }

    @Provides
    @Singleton
    fun provideUniversityUseCase(
        universityRepository: UniversityRepository
    ): UniversityUseCase {
        return UniversityUseCase(universityRepository)
    }
}