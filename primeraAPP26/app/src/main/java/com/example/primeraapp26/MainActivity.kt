package com.example.primeraapp26

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener
import androidx.core.view.WindowInsetsCompat
import com.example.primeraapp26.databinding.ActivityMainBinding
import kotlin.jvm.java


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "A: onCreate creado")
        Log.d(":::tag", "Estoy en onCreate")
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val boton = findViewById<Button>(R.id.miBoton)
        //boton.text="Púlsame, Sergio"
        binding.miBoton.text = "Púlsame Chuchi"
        binding.miBoton.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                "Hola Chuchi",
                Toast.LENGTH_SHORT
            ).show()
            val intento = Intent(this, WelcomeActivity::class.java)
            startActivity(intento)
        }
        // EXPLÍCITO
        binding.buttonSend?.setOnClickListener {
            val mensaje = binding.editTextMessage?.text.toString()
            val intento = Intent(this, WelcomeActivity::class.java).apply {
                putExtra("MENSAJE_EXTRA", mensaje)
            }
               startActivity(intento)
        }

        // IMPLÍCITO
        binding.buttonOpenBrowser?.setOnClickListener {
            val webpage: Uri = "https://www.google.com".toUri()
            val intento = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intento)
        }

        binding.dialogoSistema?.setOnClickListener {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 1001)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "A: onStart llamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "A: onResume llamado - ¡La Activity es visible y activa!")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "A: onPause llamado - Otra Activity toma el foco")
    }

    override fun onStop() {
        super.onStop()
        Log.d(":::tag", "Estoy en onStop")
        Log.d("TAG", "A: onStop llamado - La Activity ya no es visible")
        // setContentView(R.layout.stop)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "A: onRestart llamado - Volviendo de estar 'stopped'")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "A: onDestroy llamado - La Activity está siendo destruida")
    }
}