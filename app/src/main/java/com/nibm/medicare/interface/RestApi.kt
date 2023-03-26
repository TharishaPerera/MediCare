package com.nibm.medicare.`interface`

import com.nibm.medicare.models.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("user")
    fun addUser(@Body userData: User): Call<User>

//    @GET("/api/users/{Id}")
//    suspend fun getEmployee(@Path("Id") employeeId: String): Response<ResponseBody>
}