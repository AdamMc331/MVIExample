package com.adammcneilly.mviexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adammcneilly.mviexample.ui.login.LoginFragment
import com.adammcneilly.mviexample.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commitNow()
        }
    }

    fun navigateToProfile() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ProfileFragment())
            .commitNow()
    }
}