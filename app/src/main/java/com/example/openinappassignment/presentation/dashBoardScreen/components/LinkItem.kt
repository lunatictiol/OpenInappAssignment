package com.example.openinappassignment.presentation.dashBoardScreen.components

import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.openinappassignment.R
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun LinkItem(
   imageUrl:String,
    tile:String,
    subtitle:String,
    link:String,
    clicks:String


){

    Log.e("DDD", tile + "\n" + convertDateFormat(subtitle) )

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp))
        .padding(top = 12.dp)
    ){
    Column(modifier = Modifier.fillMaxSize()) {
        FirstRow(title = tile, subtitle = subtitle, Clicks = clicks, imageUrl = imageUrl)
        Spacer(modifier = Modifier.height(16.dp))
        SecondRow(link = link)



    }


}

}
@Composable
fun FirstRow(
    title: String,
    subtitle: String,
    imageUrl: String,
    Clicks:String
){
  Row(modifier = Modifier
      .fillMaxWidth()
      .padding(start = 5.dp, end = 5.dp, top = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween

  ) {
      Row (modifier = Modifier.fillMaxWidth(.8f),
          verticalAlignment = Alignment.CenterVertically
      ){
          Image(painter = rememberAsyncImagePainter(model =imageUrl ), contentDescription = "image",
              modifier = Modifier
                  .border(
                      width = 1.dp,
                      color = Color(0xFFF5F5F5),
                      shape = RoundedCornerShape(size = 8.dp)
                  )
                  .width(48.dp)
                  .height(48.dp)
          )
          Spacer(modifier = Modifier.width(12.dp))
         Column (){
             Text(
                 text =title,
                 maxLines = 1,
                 overflow = TextOverflow.Ellipsis,
                 style = TextStyle(
                     fontSize = 14.sp,
                     lineHeight = 24.sp,
                    // fontFamily = FontFamily(Font(R.font.figtree)),
                     fontWeight = FontWeight(400),
                     color = Color(0xFF000000),

                     )
             )
             Text(
                 text = convertDateFormat(subtitle),
                 style = TextStyle(
                     fontSize = 12.sp,
                     lineHeight = 18.sp,
                     //fontFamily = FontFamily(Font(R.font.figtree)),
                     fontWeight = FontWeight(400),
                     color = Color(0xFF999CA0),

                     )
             )


         }
      }
      Column (){

          Text(
              text =Clicks,
              style = TextStyle(
                  fontSize = 14.sp,
                  lineHeight = 24.sp,
                  //fontFamily = FontFamily(Font(R.font.figtree)),
                  fontWeight = FontWeight(600),
                  color = Color(0xFF000000),

                  textAlign = TextAlign.Right,
              )
          )
          Text(
              text = "Clicks",
              style = TextStyle(
                  fontSize = 12.sp,
                  lineHeight = 18.sp,
                  //fontFamily = FontFamily(Font(R.font.figtree)),
                  fontWeight = FontWeight(400),
                  color = Color(0xFF999CA0),

                  )
          )


      }

  }


}
@Composable
fun SecondRow(
    link:String

){ val stroke = Stroke(width = 2f,
    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
)
    Box(modifier = Modifier


        .fillMaxWidth()
        .height(40.dp)
        .background(color = Color(0xFFE8F1FF), shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)),



    ){
     Row(modifier = Modifier
         .fillMaxSize()
         .drawBehind {
             drawRoundRect(color = Color(0xFFA6C7FF), style = stroke, cornerRadius = CornerRadius(.2f,.2f ) )
         }
         .background(color = Color(0xFFE8F1FF), shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
         .padding(start = 12.dp, end = 12.dp, top = 5.dp),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.SpaceBetween
     ) {
         Text(
             text = link,
             maxLines = 1,
             overflow = TextOverflow.Ellipsis,
             style = TextStyle(
                 fontSize = 14.sp,
                 lineHeight = 16.sp,
                // fontFamily = FontFamily(Font(R.font.figtree)),
                 fontWeight = FontWeight(400),
                 color = Color(0xFF0E6FFF),

                 )
         )
         Image(painter = painterResource(id = R.drawable.copy), contentDescription ="Copy link",

             modifier = Modifier
                 .padding(0.75.dp)
                 .width(24.dp)
                 .height(24.dp),



         )

     }




}

}


fun convertDateFormat(inputDate: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
    val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)

    // Parse input string to Date
    val date = inputFormat.parse(inputDate)

    // Format Date to the desired output format
    return outputFormat.format(date)
}

