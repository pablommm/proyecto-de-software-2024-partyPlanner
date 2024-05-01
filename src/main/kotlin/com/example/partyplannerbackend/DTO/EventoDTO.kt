package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Servicio
import java.time.LocalDateTime

data class eventoDTO(
    val nombreDelEvento : String,
    val Lugar : Int,
    val fechaEventoIni : LocalDateTime,
    val fechaEventoFin : LocalDateTime,
    val serviciosAdquiridos : MutableList<Servicio>,
    val owner : Int// ver si se pasa id o objeto completo
    )


fun eventoDTO.toEvento(instalacion : Instalacion) = Evento(
nombreDelEvento = nombreDelEvento,
    lugar = instalacion,
    fechaEventoIni = fechaEventoIni,
    fechaEventoFin =fechaEventoFin,
    serviciosAdquiridos = serviciosAdquiridos

)