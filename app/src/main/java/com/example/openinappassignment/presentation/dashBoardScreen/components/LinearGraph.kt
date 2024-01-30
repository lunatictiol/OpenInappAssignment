package com.example.openinappassignment.presentation.dashBoardScreen.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine

@Composable
fun LinearGraph( mapString:String ){
    val dataString = mapString.trimIndent().removePrefix("{")

    // Remove unnecessary characters and split into pairs
    // Split the string into pairs

    val keyValuePairs = dataString
        .replace("\"", "")
        .split(",")
        .map { it.split(":") }

   val dateList:MutableList<String>  = emptyList<String>().toMutableList()
   keyValuePairs.forEach {
       it.forEach { string->
          dateList.add( string.substringBefore("="))
       }
   }
    val ClicksPerDate:MutableList<String>  = emptyList<String>().toMutableList()
       keyValuePairs.forEach {
        it.forEach { string->
            ClicksPerDate.add(string.substringAfter("=").trimStart().removeSuffix("}"))
        }
    }


    Log.e("AAA",ClicksPerDate.toString() )






    val steps  = 5
    val pointsData: MutableList<Point> = emptyList<Point>().toMutableList()
    for (i in 0..<dateList.lastIndex){
        pointsData.add(Point(i.toFloat(), ClicksPerDate[i].toFloat()  ))

    }

    Log.e("ZZZZZ",pointsData.toString())
    val yLabelSet = ClicksPerDate.toSet()
    val ylabel = yLabelSet.toList().sorted()

    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(color = Color(0xFFFFFFFF))
        .steps(dateList.size-1)
        .labelData {
            dateList[it]
        }
        .labelAndAxisLinePadding(15.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(color = Color(0xFFFFFFFF))
        .labelAndAxisLinePadding(20.dp)
        .labelData {
                i ->

            ylabel[i]
        }.build()
    if (pointsData.isNotEmpty()) {
        val lineChartData = LineChartData(
            linePlotData = LinePlotData(
                lines = listOf(
                    Line(
                        dataPoints = pointsData,
                        LineStyle(
                            lineType = LineType.Straight(),
                            color = Color.Blue
                        ),
                        IntersectionPoint(
                            color = Color.Transparent
                        ),
                        SelectionHighlightPoint(),
                        ShadowUnderLine(),
                        SelectionHighlightPopUp()
                    )
                ),
            ),
            xAxisData = xAxisData,
            yAxisData = yAxisData,
            gridLines = GridLines(),
            backgroundColor = Color.White
        )
        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            lineChartData = lineChartData
        )
    }
}