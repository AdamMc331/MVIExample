package com.adammcneilly.mviexample.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * A [Store] is our state container for a given screen.
 *
 * @param[initialState] This is the initial state of the screen when it is first created.
 * @param[reducer] A system for taking in the current state, and a new action, and outputting the
 * updated state.
 * @param[middlewares] This is a list of [Middleware] entities for handling any side effects
 * for actions dispatched to this store.
 */
class Store<S: State, A: Action>(
    initialState: S,
    private val reducer: Reducer<S, A>,
    private val middlewares: List<Middleware<S, A>> = emptyList(),
) {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    fun dispatch(action: A) {
        val currentState = _state.value

        middlewares.forEach { middleware ->
            middleware.process(action, currentState, this)
        }

        val newState = reducer.reduce(currentState, action)
        _state.value = newState
    }
}
