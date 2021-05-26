package com.adammcneilly.mviexample.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adammcneilly.mviexample.R

/**
 * At the moment, this fragment is just a stub to show that we can test navigation, but doesn't
 * actually hold any logic for this sample application.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}