package com.flow.examples.kotlinflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flow.examples.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //convert list to flow
        val data = listOf<Int>(1, 2, 3, 4).asFlow().flowOn(Dispatchers.IO)

        runBlocking {
            data.collect { it ->
                LogUtil.d(it.toString())
            }
        }
    }
}