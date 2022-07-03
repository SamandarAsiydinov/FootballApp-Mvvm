package com.samsdk.footballapp.repository

import com.samsdk.footballapp.database.FootballDatabase
import com.samsdk.footballapp.model.Data
import com.samsdk.footballapp.network.ApiService

class FootballRepository(
    private val apiService: ApiService,
    private val db: FootballDatabase
) {
    suspend fun saveAllFootballs(dataList: List<Data>) = db.dao().saveLeagues(dataList)
    suspend fun getLocalFootballs() = db.dao().getAllLeagues()

    suspend fun getRemoteFootballs() = apiService.getAllLeagues()
}