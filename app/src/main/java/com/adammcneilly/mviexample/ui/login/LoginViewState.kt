package com.adammcneilly.mviexample.ui.login

import com.adammcneilly.mviexample.redux.State

data class LoginViewState(
    val emailAddress: String = "",
    val password: String = "",
) : State
