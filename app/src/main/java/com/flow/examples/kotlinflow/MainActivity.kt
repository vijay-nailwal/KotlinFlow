package com.flow.examples.kotlinflow

import android.os.Bundle
import androidx.annotation.WorkerThread
import androidx.appcompat.app.AppCompatActivity
import com.flow.examples.kotlinflow.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foreGroundThread()
    }

    private fun foreGroundThread() {
        runBlocking {
            getData().catch { e ->
                LogUtil.d(e.message.toString())
            }.collect { data ->
                LogUtil.d(data.toString())
            }
        }
    }

    //always emit the data in background thread.
    private fun getData(): Flow<Int> = flow {
        for (i in 1..5) {
            delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.IO)
}