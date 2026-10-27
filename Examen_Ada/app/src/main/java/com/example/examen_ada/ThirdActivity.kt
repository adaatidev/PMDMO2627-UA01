package com.example.examen_ada

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_ada.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    // Declaración del binding
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Se infla la vista
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Función para imprimir los datos
        imprimirProducto()

        // Función que calcula e imprime el importe
        calcularImporte()
    }

    // Función para imprimir el producto
    private fun imprimirProducto() {
        val vehiculo = intent.getStringExtra("tipoVehiculo")
        binding.tvProducto.text = vehiculo
    }

    // Función para calcular el importe total según el vehículo y la tarifa
    private fun calcularImporte() {
        val vehiculo = intent.getStringExtra("tipoVehiculo")
        var diasAlquiler = intent.getStringExtra("diasAlquiler")
        var tarifaDiaria = 0

        if (vehiculo.equals("turismo", ignoreCase = true)) {
            tarifaDiaria = 40
        } else if (vehiculo.equals("suv", ignoreCase = true)) {
            tarifaDiaria = 60
        } else if (vehiculo.equals("furgoneta", ignoreCase = true)) {
            tarifaDiaria = 80
        } else {
            tarifaDiaria = 50
        }

//        diasAlquiler = diasAlquiler.toInt()
//        var subtotal = diasAlquiler * tarifaDiaria
//        var iva = subtotal * 0.21
//        var importeTotal = subtotal + iva

        binding.tvImporte.text = "." // importeTotal :(
    }

}