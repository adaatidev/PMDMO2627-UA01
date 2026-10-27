package com.example.examen_ada

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_ada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declaración del binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Se infla la vista
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Cuando se pulse el botón de continuar se ejecuta la función
        binding.btnContinuar.setOnClickListener {
            comprobarValores()
        }
    }

    // Función para comprobar y asignar los valores
    private fun comprobarValores() {
        // Se guardan los datos en sus variables
        val cliente = binding.etNombreCliente.text.toString().trim()
        val tipoVehiculo = binding.etTipoVehiculo.text.toString().trim()
        val diasAlquiler = binding.etDiasAlquiler.text.toString().trim()

        // Se comprueban que los datos no están vacíos, si no están vacíos se inicia la siguiente activity
        if (cliente.isEmpty() || diasAlquiler.isEmpty() || tipoVehiculo.isEmpty()) {
            Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("cliente", cliente)
                putExtra("diasAlquiler", diasAlquiler)
                putExtra("tipoVehiculo", tipoVehiculo)
            }
            startActivity(intent)
        }
    }

}