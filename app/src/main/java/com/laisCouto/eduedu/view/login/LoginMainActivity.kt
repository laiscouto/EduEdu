package com.laisCouto.eduedu.view.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.laisCouto.eduedu.R

class LoginMainActivity : AppCompatActivity() {

    private val viewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observe()
        val bt = findViewById<Button>(R.id.login)
        bt.setOnClickListener {
            println(25)
            observe()
        }
        viewModel.authetication("laiskarliamecouto@gmail.com","lais123456")


    }

    private fun observe(){
        viewModel.observeState().observe(this, {
            when(it){
                is LoginAuthenticationState.Loading->{
                    println("Loanding")}
                is LoginAuthenticationState.Error->{
                    println("error")
                }
                is LoginAuthenticationState.Success->{
                    println("Success")
                }

            }
        }

        )
    }



}