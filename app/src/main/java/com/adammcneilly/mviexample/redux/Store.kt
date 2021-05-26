package com.adammcneilly.mviexample.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Store<S: State, A: Action>(
    initialState: S,
    private val reducer: Reducer<S, A>,
) {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    fun dispatch(action: A) {
        val newState = reducer.reduce(_state.value, action)
        _state.value = newState
    }
}
