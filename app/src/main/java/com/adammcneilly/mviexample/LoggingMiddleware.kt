package com.adammcneilly.mviexample

import android.util.Log
import com.adammcneilly.mviexample.redux.Action
import com.adammcneilly.mviexample.redux.Middleware
import com.adammcneilly.mviexample.redux.State
import com.adammcneilly.mviexample.redux.Store

/**
 * This [Middleware] is responsible for logging every [Action] that is processed to the Logcat, so
 * that we can use this for debugging.
 */
class LoggingMiddleware<S: State, A: Action> : Middleware<S, A> {
    override fun process(action: A, currentState: S, store: Store<S, A>) {
        Log.v(
            "LoggingMiddleware",
            "Processing action: $action; Current state: $currentState"
        )
    }
}