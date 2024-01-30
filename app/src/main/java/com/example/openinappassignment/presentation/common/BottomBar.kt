package com.example.openinappassignment.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.openinappassignment.utils.BottomNavigationItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.openinappassignment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun BottomBar(selectedItemIndex:Int){

    val items = listOf(
        BottomNavigationItem(
            title = "Link",
            icon = R.drawable.linkss,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Courses",
            icon = R.drawable.courses  ,
            hasNews = false,

        ),
        BottomNavigationItem(
            title = "Campaign",
            icon = R.drawable.campaign,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Profile",
            icon = R.drawable.contact,
            hasNews = false,
        ),

    )
    BottomAppBar(
      containerColor =  Color(0xFFFFFFFF),
        actions= {

        items.forEachIndexed { index, item ->

            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {

                    // navController.navigate(item.title)
                },
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = true,
                icon = {
                    BadgedBox(
                        badge = {
                            if(item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if(item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Image(
                            painter = painterResource(id =item.icon ),
                            contentDescription = item.title,

                        )
                    }
                }
            )
        }
    }
    )
}
