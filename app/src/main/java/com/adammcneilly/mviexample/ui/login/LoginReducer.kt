package com.adammcneilly.mviexample.ui.login

import com.adammcneilly.mviexample.redux.Reducer

class LoginReducer : Reducer<LoginViewState, LoginAction> {
    override fun reduce(state: LoginViewState, action: LoginAction): LoginViewState {
        return when (action) {
            is LoginAction.EmailChanged -> {
                state.copy(
                    emailAddress = action.email,
                )
            }
            is LoginAction.PasswordChanged -> {
                state.copy(
                    password = action.password,
                )
            }
            else -> state
        }
    }
}
