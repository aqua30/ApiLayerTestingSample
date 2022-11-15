package com.aqua30.apitesting.domain.model

import java.net.HttpURLConnection

/**
 * Created by Saurabh
 */
data class ApiResponse<T>(
    val httpCode: Int = HttpURLConnection.HTTP_OK,
    val body: T? = null,
    val errorMessage: String? = null,
)
