package com.samsdk.footballapp.repository

import com.samsdk.footballapp.network.ApiService

class LeagueRepository(
    private val apiService: ApiService
) {
    suspend fun getClubById(id: String) = apiService.getClubById(id)
}