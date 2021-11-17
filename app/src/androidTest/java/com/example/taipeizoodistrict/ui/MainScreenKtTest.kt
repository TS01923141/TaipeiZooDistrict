package com.example.taipeizoodistrict.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.taipeizoodistrict.model.network.ZooDistrict
import com.example.taipeizoodistrict.ui.theme.BasicMaterialTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun MainScreen_messageCardhasName() {
        val zooDistrictList = listOf<ZooDistrict>(ZooDistrict.test, ZooDistrict.test, ZooDistrict.test)
        composeTestRule.setContent {
            BasicMaterialTheme {
                MainScreen(zooDistrictList = zooDistrictList)
            }
        }

        composeTestRule.onRoot().printToLog("currentLabelExists")

//        Thread.sleep(10000)
        composeTestRule
            .onNodeWithText(ZooDistrict.test.E_Name)
    }
}