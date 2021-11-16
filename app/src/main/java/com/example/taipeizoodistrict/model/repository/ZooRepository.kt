package com.example.taipeizoodistrict.model.repository

import com.example.taipeizoodistrict.model.network.ZooDistrict
import com.example.taipeizoodistrict.model.network.ZooDistrictEntity
import com.example.taipeizoodistrict.model.network.ZooService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import javax.inject.Inject

class ZooRepository @Inject constructor(private val service: ZooService) {

    suspend fun getZooDistrictEntity(query: String?, limit: Int?, offset: Int?): ZooDistrictEntity? =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getDistrict(query, limit, offset)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: UnknownHostException) {
                e.printStackTrace()
                null
            }
        }
}