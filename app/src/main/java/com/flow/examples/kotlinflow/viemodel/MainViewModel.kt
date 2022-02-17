package com.flow.examples.kotlinflow.viemodel


/**
 * Created by Vijay on 17-02-2022.
 */
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val _counterState: MutableStateFlow<Int>
    = MutableStateFlow(0)

    //    val counterState:StateFlow<Int> = _counterState
    //    or
    val counterState = _counterState

    fun incrementCount() {
        _counterState.value++
    }

    fun decrementCount() {
        _counterState.value--
    }
}