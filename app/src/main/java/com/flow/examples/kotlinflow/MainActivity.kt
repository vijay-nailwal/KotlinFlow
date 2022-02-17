package com.flow.examples.kotlinflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flow.examples.kotlinflow.databinding.ActivityMainBinding
import com.flow.examples.util.ConnectivityLiveData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityLiveData: ConnectivityLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding()
        internetConnection()
    }

    private fun layoutBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun internetConnection() {
        connectivityLiveData = ConnectivityLiveData(application)
        connectivityLiveData.observe(this) { isAvailable ->
            when (isAvailable) {
                true -> binding.textView.text = "Connected with Internet"
                false -> binding.textView.text = "No Network"
            }
        }
    }
}