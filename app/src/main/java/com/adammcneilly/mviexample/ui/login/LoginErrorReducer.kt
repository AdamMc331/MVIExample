package com.adammcneilly.mviexample.ui.login

import com.adammcneilly.mviexample.redux.Reducer

/**
 * This reducer is responsible for handling any [LoginAction], and using that to create
 * a new [LoginViewState].
 */
class LoginErrorReducer : Reducer<LoginViewState, LoginAction> {

    /**
     * Side note: Notice that all of the functions are named in a way that they signify they're
     * returning a new state, and not just processing information. This helps keep your when statements
     * clear that they're returning stuff, so that context isn't lost.
     */
    override fun reduce(currentState: LoginViewState, action: LoginAction): LoginViewState {
        return when (action) {
            is LoginAction.LoginFailed -> {
                stateAfterLoginFailed(currentState)
            }
            LoginAction.InvalidEmailSubmitted -> {
                stateWithInvalidEmailError(currentState)
            }
            else -> currentState
        }
    }

    private fun stateWithInvalidEmailError(currentState: LoginViewState) =
        currentState.copy(
            emailError = "Please enter an email address.",
        )

    private fun stateAfterLoginFailed(currentState: LoginViewState) =
        currentState.copy(
            showProgressBar = false,
        )
}