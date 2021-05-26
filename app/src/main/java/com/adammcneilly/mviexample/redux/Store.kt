package com.adammcneilly.mviexample.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * A [Store] is our state container for a given screen.
 *
 * @param[initialState] This is the initial state of the screen when it is first created.
 * @param[reducer] A system for taking in the current state, and a new action, and outputting the
 * updated state.
 */
class Store<S: State, A: Action>(
    initialState: S,
    private val reducer: Reducer<S, A>
) {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    fun dispatch(action: A) {
        val currentState = _state.value
        val newState = reducer.reduce(currentState, action)
        _state.value = newState
    }
}
