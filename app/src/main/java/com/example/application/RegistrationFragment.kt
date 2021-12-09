package com.example.application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.application.databinding.FragmentRegistrationBinding
import com.example.application.helper.gone
import com.example.application.helper.show

class RegistrationFragment : Fragment() {
    lateinit var binding: FragmentRegistrationBinding
    private val dataModel: DataModel by activityViewModels()
    private lateinit var UserLogin: String
    private lateinit var UserPassword: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvShowInfoRegistration.gone()
        setListeners()


    }

    private fun setListeners() {
        binding.btnRegistrationUser.setOnClickListener {
            getDataTextView()
            when (comparedValue()) {
                true -> {
                    openAuthorizationFragment()
                    dataModel.messageLogin.value = binding.tvLoginRegistration.text.toString()
                    dataModel.messagePassword.value = binding.tvPasswordRegistration.text.toString()
                }
                false -> {
                    falseData()
                }


            }


        }

    }

    private fun openAuthorizationFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.Fragment_Constraint, AuthorizationFragment.newInstance())
            .commit()

    }

    private fun comparedValue(): Boolean {
        return UserLogin != "" && UserPassword != ""
    }

    private fun getDataTextView() {
        UserLogin = binding.tvLoginRegistration.text.toString()
        UserPassword = binding.tvPasswordRegistration.text.toString()
    }


    private fun falseData() {
        binding.tvShowInfoRegistration.show()
        binding.tvShowInfoRegistration.text = getText(R.string.errorInfoRegistration)
    }


    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }


}
