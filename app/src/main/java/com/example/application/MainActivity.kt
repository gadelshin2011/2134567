package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFragmentAuthorization()

    }

    fun openFragmentAuthorization(){
        supportFragmentManager
            .beginTransaction().replace(R.id.Fragment_Constraint, AuthorizationFragment.newInstance())
            .commit()
    }




}