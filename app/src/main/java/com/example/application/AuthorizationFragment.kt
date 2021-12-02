package com.example.application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.application.databinding.FragmentAuthorizationBinding


class AuthorizationFragment : Fragment() {
    lateinit var binding : FragmentAuthorizationBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorizationBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToGoRegistrationFragment.gone()

        dataModel.messageLogin.observe(activity as LifecycleOwner,{
            binding.twLogin.setText(it)
        })
        dataModel.messagePassword.observe(activity as LifecycleOwner,{
            binding.twPassword.setText(it)
        }

        )



    }


    private  fun View.show(){
        this.visibility = View.VISIBLE
    }
    private fun View.gone(){
        this.visibility = View.GONE
    }

    companion object {
         @JvmStatic
        fun newInstance() = AuthorizationFragment()

    }
}