package com.example.examen_ada

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_ada.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    // Declaración del binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Se infla la vista
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Función para imprimir los datos
        imprimirParametros()

        // Cuando el botón de información se pulse se ejecuta su función
        binding.btnInformacion.setOnClickListener {
            solicitarInformacion()
        }

        // Cuando el botón de validar el alquiler se pulse se ejecuta su función
        binding.btnValidarAlquiler.setOnClickListener {
            validarAlquiler()
        }
    }

    // Función que almacena e imprime los datos que se han pasado de la primera activity a esta
    private fun imprimirParametros() {
        val cliente = intent.getStringExtra("cliente")
        val vehiculo = intent.getStringExtra("tipoVehiculo")
        val diasAlquiler = intent.getStringExtra("diasAlquiler")

        binding.tvNombreCliente.text = cliente
        binding.tvVehiculo.text = vehiculo
        binding.tvDiasAlquiler.text = diasAlquiler
    }

    // Función para el botón de solicitar información que abre el navegador buscando el modelo que ha seleccionado el usuario
    private fun solicitarInformacion() {
        val vehiculo = intent.getStringExtra("tipoVehiculo")

        val intentInformacion = Intent(Intent.ACTION_VIEW)
        intentInformacion.data = "https://www.alquilerflota.es/${vehiculo}".toUri()
        startActivity(intentInformacion)
    }

    // Función para validar el alquiler que pasa de la segunda activity a la tercera pasando los datos de la primera a la tercera
    private fun validarAlquiler() {
        val vehiculo = intent.getStringExtra("tipoVehiculo")
        val diasAlquiler = intent.getStringExtra("diasAlquiler")


        val intentValidarAlquiler = Intent(this, ThirdActivity::class.java).apply {
            putExtra("tipoVehiculo", vehiculo)
            putExtra("diasAlquiler", diasAlquiler)
        }
        startActivity(intentValidarAlquiler)
    }
}