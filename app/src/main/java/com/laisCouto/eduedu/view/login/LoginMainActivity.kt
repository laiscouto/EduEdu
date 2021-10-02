package com.laisCouto.eduedu.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.laisCouto.eduedu.R
import com.laisCouto.eduedu.view.searchstudent.SearchStudentActivity

class LoginMainActivity : AppCompatActivity() {

    private val viewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observe()
        setupButton()


    }

    private fun observe(){
        viewModel.observeState().observe(this, {

            when(it){
                is AddState.Loading->{
                    Toast.makeText(this, "Carregando", Toast.LENGTH_LONG).show()
                }

                is AddState.Error->{
                    Toast.makeText(this, "Não foi possivel realizar o login, tente novamente.", Toast.LENGTH_LONG).show()
                }
                is AddState.Success->{
                    navigateToHomeScreen()
                }

            }
        })
    }


    private fun validateLogin(){
        val email = findViewById<EditText>(R.id.name_add).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()

         if(email != "" && password != ""){
             viewModel.authetication(email, password)
         }else{
             Toast.makeText(this, "Por favor, preencha os dados corretamente.", Toast.LENGTH_LONG).show()
         }
    }

    private fun navigateToHomeScreen(){
        val intent = Intent(this, SearchStudentActivity::class.java)
        startActivity(intent)
    }

    private fun setupButton(){
        val bt = findViewById<Button>(R.id.login)
        bt.setOnClickListener {
            validateLogin()
        }
    }



}