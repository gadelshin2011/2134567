package com.example.application

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {

    val messageLogin : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messagePassword : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}