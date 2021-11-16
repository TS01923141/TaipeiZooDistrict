package com.example.taipeizoodistrict.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Message
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.taipeizoodistrict.model.network.ZooDistrict
import com.example.taipeizoodistrict.ui.theme.BasicMaterialTheme

private const val TAG = "MainScreen"

//name info Category
@Composable
fun MessageCard(zooDistrict: ZooDistrict, modifier: Modifier = Modifier) {
    Card(
        shape = CutCornerShape(topStart = 24.dp),
        elevation = 2.dp,
        modifier = modifier
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberImagePainter(zooDistrict.E_Pic_URL),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .heightIn(max = 210.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.onSurface)
            )

            Spacer(modifier = Modifier.height(16.dp))

            val padding = Modifier.padding(horizontal = 16.dp)
            Text(
                text = zooDistrict.E_Name,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = padding.padding(bottom = 4.dp)
            )
            Text(
                text = zooDistrict.E_Category, fontSize = 12.sp, modifier = padding
                    .background(MaterialTheme.colors.onSurface.copy(alpha = 0.6f))
                    .padding(2.dp)
            )
            Text(text = zooDistrict.E_Info, letterSpacing = 2.sp, modifier = padding)

            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

@Composable
fun MainScreen(zooDistrictList: List<ZooDistrict>) {
    LazyColumn(modifier = Modifier.animateContentSize()) {
        items(zooDistrictList) {
            MessageCard(zooDistrict = it, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewMessageCard() {
    BasicMaterialTheme {
        MessageCard(ZooDistrict.test)
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewMainScreen() {
    val zooDistrictList = listOf(ZooDistrict.test, ZooDistrict.test, ZooDistrict.test)
    BasicMaterialTheme {
        MainScreen(zooDistrictList = zooDistrictList)
    }
}