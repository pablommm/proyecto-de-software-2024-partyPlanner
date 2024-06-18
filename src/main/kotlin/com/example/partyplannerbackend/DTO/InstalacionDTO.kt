package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.Categoria
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Usuario

data class instalacionDTO(
    val nombreDeInstalacion: String,
    val descripcionDeInstalacion: String,
    val costoDeInstalacion: Int,
    val capacidadInstalacion : Int,
    val localidadDeInstalacion : String,
    val montoDeReserva :Double,
    val imagenPrincipal : String,
    val owner :Long


)

fun instalacionDTO.toInstalacion() = Instalacion(
    nombreDeInstalacion = nombreDeInstalacion,
    descripcionDeInstalacion = descripcionDeInstalacion,
    costoDeInstalacion = costoDeInstalacion,
    CapacidadInstalacion = capacidadInstalacion,
    LocalidadDeInstalacion = localidadDeInstalacion,
    montoDeReserva = montoDeReserva,
    imagenPrincipal = imagenPrincipal,

)