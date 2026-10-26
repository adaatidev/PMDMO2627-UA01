package com.example.loginxml

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginxml.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainMenuBinding.inflate(layoutInflater);
        setContentView(binding.root);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.backButton)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = intent.getStringExtra("username");
        binding.welcomeMessage.text = "¡Bienvenida, $username"

        binding.browserButton.setOnClickListener {
            val textInput = binding.textInput.text.toString()
            val browserIntent= Intent(Intent.ACTION_VIEW)
            browserIntent.data= "https://www.google.com/search?q=${binding.textInput.text}".toUri()
            startActivity(browserIntent)
        }

        binding.phoneButton.setOnClickListener {
            val phoneInput = binding.textInput.text.toString()
            val phoneIntent= Intent(Intent.ACTION_DIAL)
            phoneIntent.data= "tel: $phoneInput".toUri()
            startActivity(phoneIntent)
        }

        binding.smsButton.setOnClickListener {
            val smsInput = binding.textInput.text.toString()
            val smsIntent = Intent(Intent.ACTION_VIEW)
            smsIntent.data = Uri.parse("smsto:" + smsInput) // número escrito en el EditText
            smsIntent.putExtra("sms_body", "Hola desde mi app") // texto opcional
            startActivity(smsIntent)
        }

        binding.shareButton.setOnClickListener {
            val shareInput = binding.textInput.text.toString()
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareInput) // texto escrito en el EditText
            startActivity(Intent.createChooser(shareIntent, "Compartir con..."))
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}