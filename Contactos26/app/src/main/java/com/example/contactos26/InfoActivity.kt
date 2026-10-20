package com.example.contactos26

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contactos26.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener la información del Intent
        val nombre = intent.getStringExtra("EXTRA_NOMBRE")
        val telefono = intent.getStringExtra("EXTRA_TELEFONO")
        val email = intent.getStringExtra("EXTRA_EMAIL")

        // Asignar los valores a las vistas del layout
        binding.tvNombre.text = nombre
        binding.tvTelefono.text = telefono
        binding.tvEmail.text = email
    }
}