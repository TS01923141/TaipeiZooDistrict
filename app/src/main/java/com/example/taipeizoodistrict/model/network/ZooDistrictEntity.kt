package com.example.taipeizoodistrict.model.network

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class ZooDistrictEntity (
    val result: Result
) {
    companion object{
        val entity = ZooDistrictEntity(
            Result.empty
        )
    }
}

@JsonClass(generateAdapter = true)
data class Result(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<ZooDistrict>
) {
    companion object {
        val empty = Result(
            -1,
            0,
            0,
            "",
            arrayListOf()
        )
    }
}

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class ZooDistrict(
    val E_Pic_URL: String,
    val E_Geo: String,
    val E_Info: String,
    val E_no: Int,
    val E_Category: String,
    val E_Name: String,
    val E_Memo: String,
    val _id: String,
    val E_URL: String
) : Parcelable {
    companion object {
        val empty = ZooDistrict(
            "",
            "",
            "",
            -1,
            "",
            "",
            "",
            "",
            ""
        )

        val test = ZooDistrict(
            "https://www.zoo.gov.tw/iTAP/05_Exhibit/01_FormosanAnimal.jpg",
            "" ,
            "臺灣動物區以臺灣原生動物與棲息環境為展示重點，佈置模擬動物原生棲地之生態環境，讓動物表現如野外般自然的生活習性，引導觀賞者更正確地認識本土野生動物。臺灣位處於亞熱帶，雨量充沛、氣候溫暖，擁有各種地形景觀，因而孕育了豐富龐雜的生物資源。",
            -1,
            "戶外區",
            "臺灣動物區",
            "",
            "",
            "")
    }
}

/*
{
"result": {
    "limit": 1000,
    "offset": 0,
    "count": 15,
    "sort": "",
    "results": [
        {
            "E_Pic_URL": "http://www.zoo.gov.tw/iTAP/05_Exhibit/01_FormosanAnimal.jpg",
            "E_Geo": "MULTIPOINT ((121.5805931 24.9985962))",
            "E_Info": "臺灣動物區以臺灣原生動物與棲息環境為展示重點，佈置模擬動物原生棲地之生態環境，讓動物表現如野外般自然的生活習性，引導觀賞者更正確地認識本土野生動物。臺灣位處於亞熱帶，雨量充沛、氣候溫暖，擁有各種地形景觀，因而孕育了豐富龐雜的生物資源。",
            "E_no": "1",
            "E_Category": "戶外區",
            "E_Name": "臺灣動物區",
            "E_Memo": "",
            "_id": 1,
            "E_URL": "http://www.zoo.gov.tw/introduce/gq.aspx?tid=12"
        },
 */