package com.example.application


import android.content.pm.verify.domain.DomainVerificationManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.application.databinding.FragmentMainBinding
import com.example.application.helper.gone

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        (requireActivity() as BottomNavigationOwner).showBottomNav()
    }

    private fun setListener(){

    }




    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}

