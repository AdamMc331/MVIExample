package com.adammcneilly.mviexample

import com.adammcneilly.mviexample.redux.Action
import com.adammcneilly.mviexample.redux.Middleware
import com.adammcneilly.mviexample.redux.State
import com.adammcneilly.mviexample.redux.Store
import com.adammcneilly.mviexample.ui.login.LoginAction
import com.adammcneilly.mviexample.ui.login.LoginViewState

class LoginNetworkingMiddleware(
    private val loginRepository: LoginRepository,
) : Middleware<LoginViewState, LoginAction> {

    override fun process(
        action: LoginAction,
        currentState: LoginViewState,
        store: Store<LoginViewState, LoginAction>
    ) {
        when (action) {
            is LoginAction.SignInButtonClicked -> {
                store.dispatch(LoginAction.LoginStarted)

                val isSuccessful = loginRepository.login(
                    email = currentState.email,
                    password = currentState.password,
                )

                if (isSuccessful) {
                    store.dispatch(LoginAction.LoginCompleted)
                } else {
                    store.dispatch(LoginAction.LoginFailed(null))
                }
            }
        }
    }
}