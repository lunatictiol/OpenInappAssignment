package com.example.openinappassignment.presentation.dashBoardScreen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LinearButton(
    title:String,
    icon:Int
){
    Box(modifier = Modifier.padding(20.dp) ){
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color(0xFFD8D8D8),
                    shape = RoundedCornerShape(size = 8.dp)
                )
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically


            ) {
                Box(modifier = Modifier
                    .padding(1.dp)
                    .width(32.dp)
                    .height(32.dp)) {


                Icon(painter = painterResource(id = icon), contentDescription = "", modifier = Modifier.fillMaxSize())
            }
               Spacer(modifier = Modifier.width(12.dp))
                Text(text = title,
                    textAlign = TextAlign.Center

                )

            }
        }
    }
}

