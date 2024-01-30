package com.example.openinappassignment.presentation.dashBoardScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappassignment.R

@Composable
fun TopBox(
    icon: Int,
    title: String,
    subtitle:String,
    color:Color
           ){
    Box(
        Modifier
            .width(120.dp)
            .height(120.dp)
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(start = 12.dp, top = 12.dp, end = 23.dp, bottom = 12.dp)) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start

        )  {
            Box(modifier = Modifier
                .width(32.dp)
                .height(32.dp)
                .background(color, shape = RoundedCornerShape(20.dp),)
                , contentAlignment = Alignment.Center
            ){
            Image(painter = painterResource(id = icon), contentDescription ="", modifier = Modifier.fillMaxSize(.85f) )
            }
            Column {


            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),

                    )
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = subtitle,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.figtree)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF999CA0),

                    )
            )
            }

        }

    }

}

@Preview
@Composable
fun tp() {
   TopBox(icon = R.drawable.topsource, title ="TOP" , subtitle = "TOP", color =Color(0xFFFFE9EC))
}