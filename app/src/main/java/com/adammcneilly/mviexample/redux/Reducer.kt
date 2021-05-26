package com.adammcneilly.mviexample.redux

interface Reducer<S: State, A: Action> {
    fun reduce(state: S, action: A): S
}
