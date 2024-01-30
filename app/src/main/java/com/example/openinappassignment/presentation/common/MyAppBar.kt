package com.example.openinappassignment.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappassignment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar() { 
    TopAppBar(

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF0E6FFF),
            titleContentColor = Color.White,
            actionIconContentColor = Color.White

        ),
        title = { Box(modifier = Modifier
            .background(Color(0xFF0E6FFF))
            .fillMaxSize()) {

        Text(
            text = "Dashboard",
            modifier =Modifier.background(Color.Transparent),
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 24.sp,
                //fontFamily = FontFamily(Font(R.font.figtree)),
                fontWeight = FontWeight(600),
                //color = Color.Transparent,


                ),
            textAlign = TextAlign.Center
        )
        }
         },
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .background(color = Color(0xFF0E6FFF))
            .padding(top = 40.dp, end = 16.dp, bottom = 44.dp),
       actions = {
           Box (modifier=Modifier
               .width(40.dp)
               .height(40.dp)
               .background(color = Color(0x1FFFFFFF), shape = RoundedCornerShape(size = 8.dp))
               .padding(start = 6.66667.dp, top = 6.66667.dp, end = 6.66667.dp, bottom = 6.66667.dp),
               contentAlignment = Alignment.Center

           ){
               IconButton(onClick = { /*TODO*/ },

               ) {
                Icon(painter = painterResource(id = R.drawable.media), contentDescription ="" )
               }
           }
       }




        )






}
@Preview
@Composable
fun prv(){
    MyAppBar()
}