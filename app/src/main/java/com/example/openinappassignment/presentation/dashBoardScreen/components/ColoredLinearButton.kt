package com.example.openinappassignment.presentation.dashBoardScreen.components

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappassignment.R

@Composable
fun ColoredLinearButton(
    title:String,
    icon:Int,
    color: Color
){
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .fillMaxWidth()
            .height(64.dp)
            .background(color = color, shape = RoundedCornerShape(size = 8.dp))
            .padding(start = 12.dp, top = 20.dp, end = 194.dp, bottom = 20.dp)
    ) {
      Row(
          modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Start
      ) {
        Box(modifier = Modifier
            .padding(0.dp)
            .width(24.dp)
            .height(24.dp) ){
        Icon(
            painter = painterResource(icon),
            contentDescription = "",
            tint = color.copy(alpha=.6f),
            modifier = Modifier.fillMaxSize())
        }
        Spacer(modifier = Modifier.width(12.dp))
          Text(
              text =title,
              style = TextStyle(
                  fontSize = 16.sp,
                  lineHeight = 24.sp,
                  //  fontFamily = FontFamily(Font(R.font.figtree)),
                  fontWeight = FontWeight(600),
                  color = Color.Black
              ),

              )

      }


      }
    }


