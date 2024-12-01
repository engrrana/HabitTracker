package com.example.habittracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Initialize SharedPrefManager
        sharedPrefManager = SharedPrefManager(this)

        // Find views by ID
        val usernameInput = findViewById<EditText>(R.id.usernameRegisterInput)
        val passwordInput = findViewById<EditText>(R.id.passwordRegisterInput)
        val registerButton = findViewById<Button>(R.id.registerButton)

        // Handle register button click
        registerButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else {
                // Save user data
                sharedPrefManager.saveUser(username, password)
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                // Navigate back to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
