package com.arturo.plottest.ui.view

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.androidplot.xy.*
import com.arturo.plottest.databinding.ActivityMainBinding
import com.arturo.plottest.ui.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click events
        binding.loadChartBtn.setOnClickListener {
            mainViewModel.get_data()
        }
        //Observers
        mainViewModel.data.observe(this) {
            val series: XYSeries = SimpleXYSeries(it.ListA, it.ListB, "")
            val series1Format =
                LineAndPointFormatter(Color.RED, Color.GREEN, Color.TRANSPARENT, null)
            binding.plot.clear()
            binding.plot.addSeries(series1Format, series)
            binding.plot.redraw()
        }
        mainViewModel.isLoading.observe(this) {
            binding.loading.isVisible = it
        }

        //Plot design
        binding.plot.setDomainStep(StepMode.SUBDIVIDE, 11.toDouble())
        binding.plot.setRangeStep(StepMode.SUBDIVIDE, 10.toDouble())
        binding.plot.setRangeBoundaries(0, 9, BoundaryMode.FIXED)
        binding.plot.setDomainBoundaries(0, 100, BoundaryMode.FIXED)
        binding.plot.graph.linesPerDomainLabel = 1
    }
}