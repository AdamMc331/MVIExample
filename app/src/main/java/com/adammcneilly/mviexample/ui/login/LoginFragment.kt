package com.adammcneilly.mviexample.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.adammcneilly.mviexample.MainActivity
import com.adammcneilly.mviexample.R
import com.adammcneilly.mviexample.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            navigateToProfile()
        }
    }

    /**
     * Once the user has completed login, we should navigate them to the profile screen.
     *
     * This isn't the best practice to cast the activity directly - instead we should consider
     * interfaces or the navigation component, but we cut corners here to keep the contrived
     * sample focused on MVI.
     */
    private fun navigateToProfile() {
        (requireActivity() as MainActivity).navigateToProfile()
    }
}