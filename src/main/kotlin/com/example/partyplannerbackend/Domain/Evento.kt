package com.example.partyplannerbackend.Domain

import java.time.LocalDateTime

class Evento
    (val nombreDelEvento: String,
     val lugar: Instalacion,
     val fechaEvento: LocalDateTime,
     //  val cantidadDeInvitados :Int, de momento se deja
     var serviciosAdquiridos : MutableList<Servicio> = mutableListOf()) :Entidad(){


// el evento debe sumar la lista de costo, generar un qr o target por evento
     fun costoTotalDeServicio() = serviciosAdquiridos.sumOf { it.monto }

    fun costoDelEvento() = costoTotalDeServicio() + lugar.costoDeInstalacion

    fun aniadirServicio(servicio :Servicio) = serviciosAdquiridos.add(servicio)

    fun esValidoNombre() = nombreDelEvento.isEmpty()
    fun validarNombre() {
        if(esValidoNombre()) throw RuntimeException("El nombre debe ser vacio")
    }

    override fun validar() {
        validarNombre()
    }


}