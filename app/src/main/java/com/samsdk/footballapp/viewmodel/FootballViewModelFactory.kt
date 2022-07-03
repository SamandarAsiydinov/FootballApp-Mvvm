package com.samsdk.footballapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.samsdk.footballapp.repository.FootballRepository
import com.samsdk.footballapp.util.NetworkHelper

@Suppress("UNCHECKED_CAST")
class FootballViewModelFactory(
    private val networkHelper: NetworkHelper,
    private val footballRepository: FootballRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FootballViewModel::class.java)) {
            return FootballViewModel(footballRepository, networkHelper) as T
        }
        throw Exception("Error")
    }
}