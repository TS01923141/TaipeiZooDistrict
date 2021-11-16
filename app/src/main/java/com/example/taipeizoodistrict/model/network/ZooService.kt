package com.example.taipeizoodistrict.model.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ZooService {
    /**
     * q -> 關鍵字
     * limit -> 限制筆數
     * offset -> 從第幾筆開始(位移筆數)
     */
    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    suspend fun getDistrict(
        @Query("q") query: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Response<ZooDistrictEntity>
}