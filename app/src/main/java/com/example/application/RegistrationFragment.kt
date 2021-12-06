package com.example.application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.application.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
   lateinit var binding: FragmentRegistrationBinding
    private val dataModel: DataModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegistrationUser.setOnClickListener {
            openAuthorizationFragment()
            dataModel.messageLogin.value = binding.twLoginRegistration.text.toString()
            dataModel.messagePassword.value = binding.twPasswordRegistration.text.toString()

        }

    }
    private fun openAuthorizationFragment(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.Fragment_Constraint,AuthorizationFragment.newInstance())
            .commit()

    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
         }





    }
