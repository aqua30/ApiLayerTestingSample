package com.aqua30.apitesting.domain.repository

import com.aqua30.apitesting.data.remote.User
import com.aqua30.apitesting.domain.model.ApiResponse

/**
 * Created by Saurabh
 */
interface UserRepository {

    suspend fun getAllUsers(): ApiResponse<List<User>>

    suspend fun getUserById(id: Int): ApiResponse<User>
}