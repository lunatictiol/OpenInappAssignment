package com.example.openinappassignment.presentation.dashBoardScreen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalDensity
import kotlin.io.path.Path

@Composable
fun CustomShape() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        val pathData =
            "M9.54508 19C18.6883 19 26.6229 13.1666 33.7588 7.45009C39.5783 2.78823 46.9635 0 55 0C63.0365 0 70.4217 2.78823 76.2411 7.4501C83.3771 13.1666 91.3116 19 100.455 19H110H0H9.54508Z"




        }

}

