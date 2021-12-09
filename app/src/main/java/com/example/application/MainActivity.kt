package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application.databinding.ActivityMainBinding
import com.example.application.helper.gone
import com.example.application.helper.show


class MainActivity : AppCompatActivity(), BottomNavigationOwner {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFragmentAuthorization()
        functionNavigationMenu()

        binding.bottomNavigationMenu.gone()

    }

    private fun openFragmentAuthorization() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.Fragment_Constraint, AuthorizationFragment.newInstance())
            .commit()
    }

    private fun functionNavigationMenu() {
        binding.bottomNavigationMenu.selectedItemId = R.id.windows_home
        binding.bottomNavigationMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.windows_password -> {
                    //Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show()
                    //openFragmentPassword()
                }
                R.id.windows_home -> {
                    //Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
                    //openFragmentHome()
                }
            }
            true
        }

    }

    override fun hideBottomNav() {
        binding.bottomNavigationMenu.gone()
    }

    override fun showBottomNav() {
        binding.bottomNavigationMenu.show()
    }


}