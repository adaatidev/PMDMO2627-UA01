package com.example.contactos26

interface ContactoPulsadoListener {
    fun contactoPulsado(contacto: Contacto)
    fun correoEnviado(contacto: Contacto)
    fun infoPulsada(contacto: Contacto)
}