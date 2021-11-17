package com.example.taipeizoodistrict.model.repository

import com.example.taipeizoodistrict.model.network.ZooDistrict
import com.example.taipeizoodistrict.model.network.ZooDistrictEntity
import com.example.taipeizoodistrict.model.network.ZooService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.net.UnknownHostException

class ZooRepositoryTest{

    private lateinit var zooRepository: ZooRepository

    @MockK private lateinit var service: ZooService
    @MockK private lateinit var zooDistrictList: List<ZooDistrict>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        zooRepository = ZooRepository(service)
    }

    @Test
    fun `should return null when throw UnknownHostException`() {
        coEvery { service.getDistrict(null, null, null) } throws UnknownHostException()
        runBlocking {
            val zooDistrictEntity = zooRepository.getZooDistrictEntity(null, null, null)
            Assert.assertEquals(zooDistrictEntity, null)
        }
    }

    @Test
    fun `should return null when response not successful`() {
        coEvery { service.getDistrict(null, null, null).isSuccessful } returns false
        runBlocking {
            val zooDistrictEntity = zooRepository.getZooDistrictEntity(null, null, null)
            Assert.assertEquals(zooDistrictEntity, null)
        }
    }

    @Test
    fun `should return zooDistrictEntity from service`() {
        coEvery { service.getDistrict(null, null, null).isSuccessful } returns true
        coEvery { service.getDistrict(null, null, null).body() } returns ZooDistrictEntity.entity
        runBlocking {
            val zooDistrictEntity = zooRepository.getZooDistrictEntity(null, null, null)
            Assert.assertEquals(zooDistrictEntity, ZooDistrictEntity.entity)
        }
    }
}