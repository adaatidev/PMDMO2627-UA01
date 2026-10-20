package com.example.contactos26

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactos26.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.vistaContactos.layoutManager = LinearLayoutManager(this)
        binding.vistaContactos.adapter = ContactosAdapter(
            listOf(
                Contacto("Juan", "611123456", "juan@correo.com"),
                Contacto("María", "678456123", "maria@correo.com"),
                Contacto("Raúl", "644789456", "raul@correo.com"),
                Contacto("Ana","693882147", "ana@correo.com"),
                Contacto("Pedro", "6551237", "pedro@correo.com"),
                Contacto("José María", "123456789", "jmgove@correo.com"),
                Contacto("Sergio", "234567891", "sergio@correo.com"),
                Contacto("Jaime", "345678912", "jaime@correo.com"),
                Contacto("Raquel", "456789123", "raquel@correo.com"),
                Contacto("Jade", "567891234", "jade@correo.com"),
                Contacto("Marta", "678912345", "marta@correo.com"),
                Contacto("Rocío", "912345678", "rocio@correo.com"),
                Contacto("Mario", "123456788", "mario@correo.com")
            ),
            object : ContactoPulsadoListener {

                override fun contactoPulsado(contacto: Contacto) {
                    Snackbar.make(
                        binding.root,
                        "Iniciando llamada a ${contacto.nombre}...",
                        Snackbar.LENGTH_SHORT
                    ).show()

                    val dial = Intent(
                        Intent.ACTION_DIAL,
                        ("tel:" + contacto.telefono).toUri()
                    )
                    startActivity(dial)
                }

                override fun correoEnviado(contacto: Contacto) {
                    // OPCIÓN A: Material 3 Snackbar
                    Snackbar.make(
                        binding.root,
                        "Enviando correo a ${contacto.email}...",
                        Snackbar.LENGTH_SHORT
                    ).show()

                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = ("mailto:" + contacto.email).toUri()
                        putExtra(Intent.EXTRA_SUBJECT, "Hola")
                        putExtra(Intent.EXTRA_TEXT, "Hola, ${contacto.nombre}")
                    }
                    startActivity(intent)
                }

                override fun infoPulsada(contacto: Contacto) {
                    Toast.makeText(
                        this@MainActivity,
                        "Mostrando información de ${contacto.nombre}",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this@MainActivity, InfoActivity::class.java).apply {
                        putExtra("EXTRA_NOMBRE", contacto.nombre)
                        putExtra("EXTRA_TELEFONO", contacto.telefono)
                        putExtra("EXTRA_EMAIL", contacto.email)
                    }
                    startActivity(intent)
                }
            }
        )
    }
}