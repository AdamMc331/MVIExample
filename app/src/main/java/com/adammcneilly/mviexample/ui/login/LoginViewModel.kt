package com.adammcneilly.mviexample.ui.login

import androidx.lifecycle.ViewModel
import com.adammcneilly.mviexample.redux.Store
import kotlinx.coroutines.flow.StateFlow

/**
 * The [LoginViewModel] is responsible for controlling the UI logic of the login screen. It will
 * listen for text changes and button clicks, and update the UI state accordingly and expose that so
 * the View can update.
 */
class LoginViewModel : ViewModel() {
    private val store = Store(
        initialState = LoginViewState(),
        reducer = LoginReducer(),
    )

    val viewState: StateFlow<LoginViewState> = store.state

    fun emailChanged(newEmail: String) {
        val action = LoginAction.EmailChanged(newEmail)
        store.dispatch(action)
    }

    fun passwordChanged(newPassword: String) {
        val action = LoginAction.PasswordChanged(newPassword)
        store.dispatch(action)
    }

    fun signInClicked() {
        val action = LoginAction.SignInClicked
        store.dispatch(action)
    }
}
