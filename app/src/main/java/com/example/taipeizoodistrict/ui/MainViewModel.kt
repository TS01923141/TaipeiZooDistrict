package com.example.taipeizoodistrict.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.taipeizoodistrict.model.network.ZooDistrict
import com.example.taipeizoodistrict.model.repository.ZooRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ZooRepository): ViewModel() {
    var zooDistrictList = mutableStateListOf<ZooDistrict>()
        private set

    suspend fun refreshZooDistrict(query: String, limit: Int?, offset: Int?) = withContext(Dispatchers.IO) {
        val entity = repository.getZooDistrictEntity(query, limit, offset)
        if (entity != null){
            zooDistrictList.clear()
            zooDistrictList.addAll(entity.result.results)
        }
    }
}