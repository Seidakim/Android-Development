package com.example.mailapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LoginActivity2 : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username","")
        if (username!!.isNotEmpty()){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        setContentView(R.layout.activity_login)
    }

    fun onClick(view: View){
        val usernameText = findViewById<EditText>(R.id.loginEdit)
        val passwordText = findViewById<EditText>(R.id.passwordEdit)
        val username = usernameText.text.toString()
        val password = passwordText.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()){
            val editor = sharedPreferences.edit()
            editor.putString("username",username)
            editor.putString("password",password)
            editor.apply()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}