package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Servicio
import java.time.LocalDate
import java.time.LocalDateTime

data class eventoDTO(
    val nombreDelEvento : String,
    val Lugar : Int,
    val fechaEvento : LocalDateTime,
    val serviciosAdquiridos : MutableList<Servicio> // ver si se pasa id o objeto completo
    )


fun eventoDTO.toEvento(instalacion : Instalacion) = Evento(
nombreDelEvento = nombreDelEvento,
    lugar = instalacion,
    fechaEvento = fechaEvento,
    serviciosAdquiridos = serviciosAdquiridos

)