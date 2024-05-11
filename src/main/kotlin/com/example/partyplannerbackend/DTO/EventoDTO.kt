package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Servicio
import java.time.LocalDateTime

data class eventoDTO(
    val nombreDelEvento : String,
    val Lugar : Long,
    val fechaEventoIni : LocalDateTime,
    val fechaEventoFin : LocalDateTime,
    val serviciosAdquiridos : MutableList<Servicio>,
    val owner : Long// ver si se pasa id o objeto completo
    )


fun eventoDTO.toEvento(instalacion : Instalacion) = Evento(
nombreDelEvento = nombreDelEvento,
    lugar = instalacion,
    fechaEventoIni = fechaEventoIni,
    fechaEventoFin =fechaEventoFin,
    serviciosAdquiridos = serviciosAdquiridos

)