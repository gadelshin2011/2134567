package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFragmentAuthorization()


        dataModel.messageLogin.observe(this,{

        })



    }

    fun openFragmentAuthorization(){
        supportFragmentManager
            .beginTransaction().replace(R.id.Fragment_Constraint, AuthorizationFragment.newInstance())
            .commit()
    }




}