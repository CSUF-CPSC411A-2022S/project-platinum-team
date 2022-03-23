package com.example.mapapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.data2viz.charts.chart.Chart
import io.data2viz.charts.chart.chart
import io.data2viz.charts.chart.quantitative
import io.data2viz.geom.Size
import io.data2viz.charts.*
import io.data2viz.charts.dimension.*
import io.data2viz.charts.chart.*
import io.data2viz.charts.chart.mark.*
import io.data2viz.charts.viz.*
import io.data2viz.charts.layout.*
import io.data2viz.charts.core.*
import io.data2viz.geom.*
import io.data2viz.color.*
import io.data2viz.color.EncodedColors.Companion.set1
import io.data2viz.color.EncodedColors.Companion.set2
import io.data2viz.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Graph(this))
    }
}

