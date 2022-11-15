package com.aqua30.apitesting.data

import com.aqua30.apitesting.data.remote.TestApis
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Saurabh
 */
object RetrofitHelper {

    /**
     * as dependency injection is not used in this project for brevity,
     * static object initialization is done for demo purpose.
     *
     * @param url: Base url for apis
     * @return TestApis: Instance of the test api retrofit interface
     **/
    fun testApiInstance(url: String): TestApis {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TestApis::class.java)
    }
}