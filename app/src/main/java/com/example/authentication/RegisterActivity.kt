package com.example.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.FocusFinder
import android.view.KeyEvent
import android.view.View
import com.example.authentication.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity(), View.OnClickListener,View.OnFocusChangeListener, View.OnKeyListener {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etFullname.onFocusChangeListener = this
        binding.etEmail.onFocusChangeListener = this
        binding.passwordEt.onFocusChangeListener = this
        binding.confirmPasswordEt.onFocusChangeListener = this
    }

    private fun validatefullname():Boolean{
        var errorMessage:String? = null
        val value:String=binding.etFullname.text.toString()
        if (value.isEmpty()){
            errorMessage="Full Name is required"
        }
        if (errorMessage != null){
            binding.fullNameTil.apply {
                isErrorEnabled = true
                error= errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateemail():Boolean{
        var errorMessage:String? = null
        val value=binding.etEmail.text.toString()
        if (value.isEmpty()){
            errorMessage="Email is required"
        }else if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage="Email address is invalid"
        }
        if (errorMessage != null){
            binding.emailTil.apply {
                isErrorEnabled = true
                error= errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePassword():Boolean{
        var errorMessage:String? = null
        val value=binding.passwordEt.text.toString()
        if (value.isEmpty()){
            errorMessage="Password is required"
        }else if(value.length<6){
            errorMessage="Password must be 6 characters long"
        }
        if (errorMessage != null){
            binding.passwordTil.apply {
                isErrorEnabled = true
                error= errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateconfirmPassword():Boolean{
        var errorMessage:String? = null
        val value=binding.confirmPasswordEt.text.toString()
        if (value.isEmpty()){
            errorMessage="Confirm Password is required"
        }else if(value.length<6){
            errorMessage="Password must be 6 characters long"
        }
        if (errorMessage != null){
            binding.confirmPasswordTil.apply {
                isErrorEnabled = true
                error= errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePasswordAndConfirmPassword():Boolean{
        var errorMessage:String?=null
        val password=binding.passwordEt.text.toString()
        val confirmPassword=binding.confirmPasswordEt.text.toString()
        if (password != confirmPassword){
            errorMessage = "Confirm Password doesn't matches with Password"
        }
        if (errorMessage != null){
            binding.confirmPasswordTil.apply {
                isErrorEnabled = true
                error= errorMessage
            }
        }
        return errorMessage == null
    }

    override fun onClick(p0: View?) {

    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null){
            when(view.id){
                R.id.et_fullname -> {
                    if (hasFocus){
                        if (binding.fullNameTil.isErrorEnabled){
                            binding.fullNameTil.isErrorEnabled = false
                        }
                    }
                    else{
                        validatefullname()
                    }
                }
                R.id.et_email -> {
                    if (hasFocus){
                        if (binding.emailTil.isErrorEnabled){
                            binding.emailTil.isErrorEnabled = false
                        }
                    }
                    else{
                        validateemail()
                    }
                }
                R.id.password_et -> {
                    if (hasFocus){
                        if (binding.passwordTil.isErrorEnabled){
                            binding.passwordTil.isErrorEnabled = false
                        }
                    }
                    else{
                        validatePassword()
                    }
                }
                R.id.confirmPassword_et -> {
                    if (hasFocus){
                        if (binding.confirmPasswordTil.isErrorEnabled){
                            binding.confirmPasswordTil.isErrorEnabled = false
                        }
                    }
                    else{
                        if(validateconfirmPassword() && validatePassword() && validatePasswordAndConfirmPassword()){
                            if (binding.passwordTil.isErrorEnabled){
                                binding.passwordTil.isErrorEnabled = false
                            }
                            binding.confirmPasswordTil.setStartIconDrawable(R.drawable.ic_check)
                        }
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, key: KeyEvent?): Boolean {
        return false
    }
}