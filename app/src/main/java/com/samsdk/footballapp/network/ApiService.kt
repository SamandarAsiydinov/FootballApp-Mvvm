package com.samsdk.footballapp.network

import com.samsdk.footballapp.model.Club
import com.samsdk.footballapp.model.League
import com.samsdk.footballapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAllLeagues(): Response<League>

    @GET("leagues/{id}/standings")
    suspend fun getClubById(
        @Path("id") id: String,
        @Query("season") season: String = "2021"
    ): Response<Club>
}