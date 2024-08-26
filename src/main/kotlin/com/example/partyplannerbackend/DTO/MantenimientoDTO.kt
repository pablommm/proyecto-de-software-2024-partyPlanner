package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.Mantenimiento
import com.example.partyplannerbackend.Domain.*
import java.time.LocalDateTime


data class MantenimientoDTO(
    val Lugar : Long,
    var fechaIni : LocalDateTime,
    var fechaFin : LocalDateTime,
    var descripcion : String,
    val owner: Long
)

fun MantenimientoDTO.toMantenimiento() = Mantenimiento(
    fechaIni=fechaIni,
    fechaFin = fechaFin,
    descripcion=descripcion

)


