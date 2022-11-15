package com.aqua30.apitesting.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Saurabh
 */

const val BASE_USER_PATH_URL = "/aqua30/users"
const val DOUBLE_QUOTES = "\""

interface TestApis {

    @GET(BASE_USER_PATH_URL)
    suspend fun getAllUsers(): List<User>

    @GET("$BASE_USER_PATH_URL/{id}")
    suspend fun getUserById(@Path("id") id: Int): User
}

data class User(
    val id: Int,
    val name: String,
    val city: String,
    val country: String
)