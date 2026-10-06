package com.example.primeraapp26

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primeraapp26.databinding.ActivityMainBinding
import com.example.primeraapp26.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "B: onCreate creado")
        enableEdgeToEdge()
        val binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewMensaje.text = intent.getStringExtra("MENSAJE_EXTRA") ?: "No hay mensaje"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            //binding.botonWelcome?.setOnClickListener {

            //}
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("TAG", "B: onStart llamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "B: onResume llamado - ¡La Activity es visible y activa!")
        getString(R.string.toast_actividad_b)
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "B: onPause llamado - Otra Activity toma el foco")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "B: onStop llamado - La Activity ya no es visible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "B: onRestart llamado - Volviendo de estar 'stopped'")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "B: onDestroy llamado - La Activity está siendo destruida")
    }
}