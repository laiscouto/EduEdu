package com.laisCouto.eduedu.view.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.laisCouto.eduedu.R

class LoginMainActivity : AppCompatActivity() {

    private val viewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observe()
        val bt = findViewById<Button>(R.id.login)
        bt.setOnClickListener {
            validateLogin()
        }


    }

    private fun observe(){
        viewModel.observeState().observe(this, {
            when(it){
                is LoginAuthenticationState.Loading->{

                    }

                is LoginAuthenticationState.Error->{

                }
                is LoginAuthenticationState.Success->{

                }

            }
        }

        )
    }

    private fun validateLogin(){
        val email = findViewById<EditText>(R.id.name_add).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()

         if(email != "" && password != ""){
             viewModel.authetication(email, password)
         }else{
             Toast.makeText(this, "Informe a validação", Toast.LENGTH_LONG).show()
         }
    }



}