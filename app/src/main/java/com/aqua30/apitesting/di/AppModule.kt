package com.aqua30.apitesting.di

import com.aqua30.apitesting.data.remote.BASE_USER_PATH_URL
import com.aqua30.apitesting.data.remote.TestApis
import com.aqua30.apitesting.data.repository.UserRepositoryImpl
import com.aqua30.apitesting.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): TestApis {
        return Retrofit.Builder()
            .baseUrl(BASE_USER_PATH_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TestApis::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        api: TestApis
    ): UserRepository {
        return UserRepositoryImpl(api)
    }

}