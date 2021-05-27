package com.adammcneilly.mviexample.ui.login

import android.util.Log
import com.adammcneilly.mviexample.redux.Reducer

/**
 * This reducer is responsible for handling any [LoginAction], and using that to create
 * a new [LoginViewState].
 */
class LoginReducer : Reducer<LoginViewState, LoginAction> {

    /**
     * Side note: Notice that all of the functions are named in a way that they signify they're
     * returning a new state, and not just processing information. This helps keep your when statements
     * clear that they're returning stuff, so that context isn't lost.
     */
    override fun reduce(currentState: LoginViewState, action: LoginAction): LoginViewState {
        return when (action) {
            is LoginAction.EmailChanged -> {
                stateWithNewEmail(currentState, action)
            }
            is LoginAction.PasswordChanged -> {
                stateWithNewPassword(currentState, action)
            }
            LoginAction.LoginStarted -> {
                stateAfterLoginStarted(currentState)
            }
            LoginAction.LoginCompleted -> {
                stateAfterLoginCompleted(currentState)
            }
            is LoginAction.LoginFailed -> {
                stateAfterLoginFailed(currentState)
            }
            else -> currentState
        }
    }

    private fun stateAfterLoginStarted(currentState: LoginViewState) =
        currentState.copy(
            showProgressBar = true,
        )

    private fun stateAfterLoginCompleted(currentState: LoginViewState) =
        currentState.copy(
            showProgressBar = false,
        )

    private fun stateAfterLoginFailed(currentState: LoginViewState) =
        currentState.copy(
            showProgressBar = false,
        )

    private fun stateWithNewPassword(
        currentState: LoginViewState,
        action: LoginAction.PasswordChanged
    ) = currentState.copy(
        password = action.newPassword,
    )

    private fun stateWithNewEmail(
        currentState: LoginViewState,
        action: LoginAction.EmailChanged
    ) = currentState.copy(
        email = action.newEmail,
    )
}