package com.adammcneilly.mviexample.ui.login

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginReducerTest {

    /**
     * A standard reducer test will take an input state and input action and have the reducer
     * reduce that into a new state.
     *
     * We then want to compare that new state with what is expected.
     */
    @Test
    fun emailChangedUpdatesEmail() {
        val inputState = LoginViewState()
        val inputAction = LoginAction.EmailChanged("testy@mctestface.com")

        val expectedState = inputState.copy(
            email = "testy@mctestface.com",
        )

        val reducer = LoginReducer()
        val newState = reducer.reduce(inputState, inputAction)
        assertThat(newState).isEqualTo(expectedState)
    }

    /**
     * An example of a simplified reducer test is to take an input state and action, have the reducer
     * reduce this to a new state, and then perform assertions only on the properties we expected
     * to be updated.
     *
     * This can make for simpler and shorter tests, but we should acknowledge that this means potential
     * side effects could sneak in our tests.
     */
    @Test
    fun loginStartedShowsProgressBar() {
        val inputState = LoginViewState()
        val inputAction = LoginAction.LoginStarted

        val reducer = LoginReducer()
        val newState = reducer.reduce(inputState, inputAction)

        assertThat(newState.showProgressBar).isTrue()
    }

    /**
     * This tests ensures that our fallback scenario - dispatching an action that isn't processed
     * by this reducer - will return the original state.
     */
    @Test
    fun unsupportedActionReturnsOriginalState() {
        val inputState = LoginViewState()
        val inputAction = LoginAction.SignInButtonClicked

        val reducer = LoginReducer()
        val newState = reducer.reduce(inputState, inputAction)

        assertThat(newState).isEqualTo(inputState)
    }
}