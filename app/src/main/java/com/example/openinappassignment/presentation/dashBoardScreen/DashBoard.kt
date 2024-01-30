package com.example.openinappassignment.presentation.dashBoardScreen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults

import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappassignment.R
import com.example.openinappassignment.presentation.common.BottomBar
import com.example.openinappassignment.presentation.common.MyAppBar
import com.example.openinappassignment.presentation.dashBoardScreen.components.ColoredLinearButton
import com.example.openinappassignment.presentation.dashBoardScreen.components.LinearButton
import com.example.openinappassignment.presentation.dashBoardScreen.components.LinearGraph
import com.example.openinappassignment.presentation.dashBoardScreen.components.LinkItem
import com.example.openinappassignment.presentation.dashBoardScreen.components.TopBox

import org.koin.androidx.compose.koinViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun Dashboard(
    viewModel:DashBoardViewModel= koinViewModel()
) {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

val todaysClicks by remember {
    viewModel.topClicks
}
val topLocation by remember {
    viewModel.topLocation
}
val topSource by remember {
    viewModel.topSource
}

 val greetings by remember {
     viewModel.greetings
 }
 val user by remember {
     viewModel.user
 }
val topLinks =  remember {
    viewModel.Links


}



    val mapString by remember {
        viewModel.mapString
    }

    Scaffold(
        topBar = { MyAppBar() },
        floatingActionButtonPosition = FabPosition.Center,
       modifier = Modifier.padding(bottom = 0.dp),

        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ },
                containerColor =Color(0xFFFFFFFF) ,
                shape = RoundedCornerShape(75.dp),

                modifier = Modifier
                    .offset(y = 70.dp)
                    .padding(0.dp)

                    .height(70.dp)
                    .width(70.dp)

                    

            )

            {
                Box(modifier = Modifier

                    .fillMaxSize(.9f)
                    .background(
                        color = Color(0xFF0E6FFF),
                        shape = RoundedCornerShape(70.dp)
                    ),
                    contentAlignment = Alignment.Center
                ){
                Icon(painter = painterResource(id = R.drawable.add), contentDescription ="", tint = Color.White )
            }

            }
        },

        bottomBar = { BottomBar(selectedItemIndex = selectedItemIndex) },
        containerColor = Color(0xFF0E6FFF),


        ) {
        Box(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding(),


                    )
                .fillMaxSize()
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(size = 20.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 100.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Column(
                    modifier = Modifier
                        .padding(top = 32.dp, start = 15.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = greetings,
                        style = TextStyle(
                            fontSize = 16.sp,
                            //fontFamily = FontFamily(Font(R.font.figtree)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF999CA0),

                            ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp)

                    )
                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement =Arrangement.Start
                    ) {
                        Text(
                            text = user,
                            style = TextStyle(
                                fontSize = 24.sp,
                                lineHeight = 32.sp,
                                //fontFamily = FontFamily(Font(R.font.figtree)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF000000),

                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Box (modifier = Modifier
                            .width(28.dp)
                            .height(28.dp)

                        ){
                            Image(painter = painterResource(id = R.drawable.hii),
                                contentDescription ="hii",
                                modifier = Modifier.fillMaxSize()
                                )

                        }
                        }
                    
                }
                Spacer(modifier = Modifier.height(24.dp))
                Card(
                   colors = CardDefaults.cardColors(
                       containerColor =   Color(0xFFFFFFFF)
                   ),
                    shape = RoundedCornerShape(size = 8.dp),
                    modifier = Modifier
                        .width(450.dp)
                        .height(300.dp)
                        .padding(10.dp)


                ) {
                    Column(modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .background(
                            color = Color(0xFFFFFFFF)
                        )
                    ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFFFFFFFF)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(
                            text = "Overview",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                // fontFamily = FontFamily(Font(R.font.figtree)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF999CA0),

                                )

                        )
                        Box(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFEBEBEB),
                                    shape = RoundedCornerShape(size = 6.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0x14000000),
                                    shape = RoundedCornerShape(size = 6.dp)
                                )
                                .width(123.dp)
                                .height(28.dp)
                                .padding(start = 8.dp, top = 6.dp, end = 4.dp, bottom = 6.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Text(
                                    text = "22 Aug - 23 Sept",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 12.sp,
                                        //fontFamily = FontFamily(Font(R.font.figtree)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),

                                        )
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.time),
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                    LinearGraph(mapString = mapString)
                }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .horizontalScroll(rememberScrollState())
                        .background(color = Color(0xFFF5F5F5)),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TopBox(icon = R.drawable.click, title = todaysClicks, subtitle = "Today's Click", color = Color(0x1F5C33CF))
                    Spacer(modifier = Modifier.width(10.dp))
                    TopBox(icon = R.drawable.pin, title = topLocation, subtitle = "Top Location", color = Color(0x1F0E6FFF))
                    Spacer(modifier = Modifier.width(10.dp))
                    TopBox(icon =R.drawable.topsource, title = topSource, subtitle = "Top Source" , color = Color(0xFFFFE9EC)  )

                }
                Spacer(modifier = Modifier.height(20.dp))
                LinearButton(title = "View Analytics", icon = R.drawable.arrow)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Button(onClick = { viewModel.changeLinkstoTop()},
                         colors = ButtonDefaults.buttonColors(containerColor =Color(0xFF0E6FFF) )

                        ) {
                            Text(text = "Top Link")
                        }
                        Spacer(modifier = Modifier.width(24.dp))
                        Button(onClick = { viewModel.changeLinkstoRecent() },
                            colors = ButtonDefaults.buttonColors(containerColor =Color(0xFF0E6FFF) )) {
                            Text(text = "Recent Link")
                        }

                    }





                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFEBEBEB),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                            .width(36.dp)
                            .height(36.dp)
                            .background(
                                color = Color(0xFFF2F2F2),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                            .padding(start = 6.dp, top = 6.dp, end = 6.dp, bottom = 6.dp)
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "search Icon",
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                }
                Spacer(modifier = Modifier.height(12.dp))


                  Column (modifier = Modifier.padding(start = 10.dp, end = 10.dp)){
                      topLinks.value!!.forEach(){
                          LinkItem(imageUrl = it.original_image,
                               tile = it.title,
                              subtitle = it.created_at,
                              link =it.web_link , clicks =it.total_clicks.toString() )
                          Spacer(modifier = Modifier.height(20.dp))
                          
                      }


                  }

               LinearButton(title = "View All Links", icon = R.drawable.link )
               Column(modifier = Modifier.padding(10.dp)){


               ColoredLinearButton(title = "Talk to us", color = Color(0x524AD15F), icon = R.drawable.whatsapp )
               Spacer(modifier = Modifier.height(20.dp))
               ColoredLinearButton(title = "Frequently Asked Questions", icon =R.drawable.faq , color = Color(0x520E6FFF))
               }
            }

        }
    }

}



