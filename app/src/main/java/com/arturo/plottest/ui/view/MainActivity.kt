package com.arturo.plottest.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.arturo.plottest.databinding.ActivityMainBinding
import com.arturo.plottest.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loadChartBtn.setOnClickListener{
            mainViewModel.loadChart()
        }

        mainViewModel.data.observe(this, Observer {
            Log.d("DATA RECEIVED", it.toString())
        })
    }
}