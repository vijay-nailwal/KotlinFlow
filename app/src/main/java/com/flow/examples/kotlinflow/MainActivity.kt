package com.flow.examples.kotlinflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flow.examples.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = flowOf(1, 2, 3, 4, 5).flowOn(Dispatchers.IO)

//        for filter the values use filter
        runBlocking {
            data.filter { value ->
                value%2==0
            }.collect { it ->
                LogUtil.d(it.toString())
            }
        }

    }
}