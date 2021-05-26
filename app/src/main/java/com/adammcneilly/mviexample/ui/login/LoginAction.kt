package com.adammcneilly.mviexample.ui.login

import com.adammcneilly.mviexample.redux.Action

sealed class LoginAction : Action {
    data class EmailChanged(val email: String) : LoginAction()
    data class PasswordChanged(val password: String) : LoginAction()
    object SignInClicked : LoginAction()
}