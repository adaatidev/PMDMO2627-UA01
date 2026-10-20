package com.example.contactos26

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactosAdapter(
    private val contactos: List<Contacto>,
    private val contactoPulsadoListener: ContactoPulsadoListener
) : RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactos[position]
        holder.tvNombre.text = contacto.nombre
        holder.tvTelefono.text = contacto.telefono

        holder.itemView.setOnClickListener {
            contactoPulsadoListener.contactoPulsado(contacto)
        }

        holder.btnInfo.setOnClickListener {
            contactoPulsadoListener.infoPulsada(contacto)
        }

        holder.btnEmail.setOnClickListener {
            contactoPulsadoListener.correoEnviado(contacto)
        }

        val ultimoDigito = contacto.telefono.last()
        when(ultimoDigito) {
            '0'->holder.avatar.setImageResource(R.drawable._0)
            '1'->holder.avatar.setImageResource(R.drawable._1)
            '2'->holder.avatar.setImageResource(R.drawable._2)
            '3'->holder.avatar.setImageResource(R.drawable._3)
            '4'->holder.avatar.setImageResource(R.drawable._4)
            '5'->holder.avatar.setImageResource(R.drawable._5)
            '6'->holder.avatar.setImageResource(R.drawable._6)
            '7'->holder.avatar.setImageResource(R.drawable._7)
            '8'->holder.avatar.setImageResource(R.drawable._8)
            '9'->holder.avatar.setImageResource(R.drawable._9)
        }
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.imageView)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefono)

        val btnInfo: View = itemView.findViewById(R.id.btnInfo)

        // Referencia al botón del correo
        val btnEmail: View = itemView.findViewById(R.id.btnEmail)
    }
}