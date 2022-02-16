package com.flow.examples.kotlinflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flow.examples.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = flowOf(1, 2, 3, 4, 5).flowOn(Dispatchers.IO)

//        for changing the values use map
        runBlocking {
            data.map { value ->
                value * value
            }.collect { it ->
                LogUtil.d(it.toString())
            }
        }

    }
}