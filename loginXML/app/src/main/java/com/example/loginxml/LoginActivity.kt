package com.example.loginxml

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginxml.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.backButton)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.loginButton.setOnClickListener {
            val username = binding.loginInput.text.toString();
            val password = binding.passwordInput.text.toString();

            if (username == "admin" && password == "1234") {
                val intent = Intent(this, MainMenuActivity::class.java).apply{
                    putExtra("username", username)
                }
                startActivity(intent);
            } else {
                val intent = Intent(this, ErrorActivity::class.java).apply{
                    putExtra("username", username)
                }
                startActivity(intent);
            }
        }
    }
}