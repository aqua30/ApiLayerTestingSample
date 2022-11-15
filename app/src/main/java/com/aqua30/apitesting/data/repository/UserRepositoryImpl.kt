package com.aqua30.apitesting.data.repository

import com.aqua30.apitesting.data.remote.TestApis
import com.aqua30.apitesting.data.remote.User
import com.aqua30.apitesting.domain.model.ApiResponse
import com.aqua30.apitesting.domain.repository.UserRepository
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Saurabh
 */
class UserRepositoryImpl(
    private val testApis: TestApis
): UserRepository {

    override suspend fun getAllUsers(): ApiResponse<List<User>> {
        return try {
            ApiResponse(
                body = testApis.getAllUsers()
            )
        } catch (e: HttpException) {
            ApiResponse(
                httpCode = e.code(),
                errorMessage = "server error"
            )
        } catch (e: IOException) {
            ApiResponse(
                errorMessage = "connection error"
            )
        }
    }

    override suspend fun getUserById(id: Int): ApiResponse<User> {
        return try {
            ApiResponse(
                body = testApis.getUserById(id)
            )
        } catch (e: HttpException) {
            ApiResponse(
                httpCode = e.code(),
                errorMessage = "server error"
            )
        } catch (e: IOException) {
            ApiResponse(
                errorMessage = "connection error"
            )
        }
    }
}