package com.example.application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.activityViewModels
import com.example.application.databinding.FragmentAuthorizationBinding
import com.example.application.helper.gone
import com.example.application.helper.show


class AuthorizationFragment : Fragment() {
    lateinit var binding: FragmentAuthorizationBinding
    private val dataModel: DataModel by activityViewModels()
    private lateinit var UserLogin: String
    private lateinit var UserPassword: String


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
        binding.tvShowInfoAuthorization.gone()
        //Принять и отобразить данные
        acceptData()
        // Выполнить действия кнопок
        setListeners()

    }


    private fun setListeners() {
        binding.btnAuthorization.setOnClickListener {
            getDataTextView()

            when (comparedValue()) {
                true -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.Fragment_Constraint, MainFragment.newInstance())
                        .commit()
                }

                false -> {
                    falseData()
                    binding.btnToGoRegistrationFragment.show()

                }
            }

        }

        binding.btnToGoRegistrationFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.Fragment_Constraint, RegistrationFragment.newInstance()).commit()
        }


    }


    private fun comparedValue(): Boolean {
        return UserLogin == getString(R.string.login) && UserPassword == getString(R.string.password)
    }

    private fun getDataTextView() {
        UserLogin = binding.tvLogin.text.toString()
        UserPassword = binding.tvPassword.text.toString()
    }

    //Принять информацию с другого фрагмента и отобразить в Edit text
    private fun acceptData() {
        dataModel.messageLogin.observe(viewLifecycleOwner, {
            binding.tvLogin.setText(it)
        })
        dataModel.messagePassword.observe(viewLifecycleOwner, {
            binding.tvPassword.setText(it)
        })
    }

    private fun falseData() {
        binding.tvShowInfoAuthorization.show()
        binding.tvShowInfoAuthorization.text = getText(R.string.errorInfo)
    }


    companion object {
        @JvmStatic
        fun newInstance() = AuthorizationFragment()

    }

}