package com.example.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.View
import com.example.authentication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener,View.OnFocusChangeListener, View.OnKeyListener {
     private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etFullname.onFocusChangeListener=this
        binding.etEmail.onFocusChangeListener =this
        binding.etPassword.onFocusChangeListener=this
        binding.etConfirmPassword.onFocusChangeListener=this

    }

    private fun validatefullname():Boolean{
        var errorMessage:String?=null
        val value:String=binding.etFullname.editText.toString()
        if (value.isEmpty()){
            errorMessage="Name is required"
        }
        if (errorMessage!=null){
            binding.etFullname.apply {
                isErrorEnabled=true
                error=errorMessage
            }
        }
        return errorMessage == null
    }


    private fun validateemail():Boolean{
        var errorMessage:String?=null
        val value:String=binding.etEmail.editText.toString()
        if (value.isEmpty()){
            errorMessage="Email is required"
        }else if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage="Email Address is invalid"
        }
        if (errorMessage!=null){
            binding.etEmail.apply {
                isErrorEnabled=true
                error=errorMessage
            }
        }
        return errorMessage == null
    }


    private fun validatepassword():Boolean{
        var errorMessage:String?=null
        val value=binding.etPassword.editText.toString()
        if (value.isEmpty()){
            errorMessage="Password is required"
        }else if(value.length<6){
            errorMessage="Password should be 6 characters long"
        }
        if (errorMessage!=null){
            binding.etPassword.apply {
                isErrorEnabled=true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateconfirmPassword():Boolean{
        var errorMessage:String?=null
        val pass:String=binding.etPassword.editText.toString()
        val cpass:String=binding.etConfirmPassword.editText.toString()
        if (cpass.isEmpty()){
            errorMessage="Confirm Password is required"
        }else if (pass!=cpass){
            errorMessage="Confirm Password should match with Password"
        }
        if (errorMessage!=null){
            binding.etConfirmPassword.apply {
                isErrorEnabled=true
                error=errorMessage
            }
        }
        return errorMessage==null



    }
//    private fun validatePasswordAndConfirmPassword():Boolean{
//        var error:String?= null
//        val pass=binding.etPassword.editText.toString()
//        val confirmPass=binding.etConfirmPassword.editText.toString()
//        if (pass!=confirmPass){
//            error="Confirm Password doesn't matches with Password"
//        }
//        return error == null
//    }

    override fun onClick(p0: View?) {

    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view!=null){
            when(view.id){
                R.id.et_fullname -> {
                    if (hasFocus){
                        if (binding.etFullname.isErrorEnabled){
                            binding.etFullname.isErrorEnabled=true
                        }
                    }
                    else{
                        validatefullname()
                    }
                }
                R.id.et_email -> {
                    if (hasFocus){
                        if (binding.etEmail.isErrorEnabled){
                            binding.etEmail.isErrorEnabled=true
                        }
                    }
                    else{
                        validateemail()
                    }
                }R.id.et_password -> {
                    if (hasFocus){
                        if (binding.etPassword.isErrorEnabled){
                            binding.etPassword.isErrorEnabled=true
                        }
                    }
                else{
                    validatepassword()
                    }
                }R.id.et_confirmPassword -> {
                    if (hasFocus){
                        if (binding.etConfirmPassword.isErrorEnabled){
                            binding.etConfirmPassword.isErrorEnabled=true
                        }
                    }
                else{
                    validateconfirmPassword()
                    }
                }
            }
        }
    }












//    override fun onFocusChange(view: View?, hasFocus: Boolean) {
//        if (view!=null){
//            when(view.id){
//                R.id.et_fullname -> {
//                    if (hasFocus){
//                        if (binding.etFullname.isErrorEnabled){
//                            binding.etFullname.isErrorEnabled = false
//                        }
//
//                    }else{
//                        validateFullName()
//                    }
//                }
//                R.id.et_email -> {
//                    if (hasFocus){
//                        if (binding.etEmail.isErrorEnabled){
//                            binding.etEmail.isErrorEnabled = false
//                        }
//
//                    }else{
//                        validateemail()
//                    }
//
//                }
//                R.id.et_password -> {
//                    if (hasFocus){
//                        if (binding.etPassword.isErrorEnabled){
//                            binding.etPassword.isErrorEnabled = false
//                        }
//
//                    }else{
//                        validatepassword()
//                    }
//
//                }
//                R.id.et_confirmPassword -> {
//                    if (hasFocus){
//                        if (binding.etConfirmPassword.isErrorEnabled){
//                            binding.etConfirmPassword.isErrorEnabled = false
//                        }
//
//                    }else{
//                        validateConfirmPassword()
//                    }
//
//                }
//            }
//        }
//    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }
}