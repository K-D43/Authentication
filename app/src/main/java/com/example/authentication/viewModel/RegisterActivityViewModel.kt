package com.example.authentication.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authentication.data.User
import com.example.authentication.data.ValidateEmailBody
import com.example.authentication.repository.AuthRepository

class RegisterActivityViewModel(authRepository: AuthRepository, val application: Application): ViewModel() {

    private var isLoading:MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value=false }
    private var errorMessage:MutableLiveData<HashMap<String,String>> = MutableLiveData()
    private var isUnique: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }
    private var user: MutableLiveData<User> = MutableLiveData()


    fun getIsLoading():LiveData<Boolean> = isLoading
    fun getErrorMessage():LiveData<HashMap<String, String>> = errorMessage
    fun getIsUnique():LiveData<Boolean> = isUnique
    fun getUser(): LiveData<User> = user

    fun validateEmailAddress(body:ValidateEmailBody){

    }
}