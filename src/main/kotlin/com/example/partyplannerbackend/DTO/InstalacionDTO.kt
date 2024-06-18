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
    val owner :Long,
    val calle : String,
    val altura : Int,
    val provincia : String,
    val numeroDeTelefono :Int,
    val mail : String,
    val baños : Int,
    val terraza :Boolean,
    val jardin :Boolean,
    val estacionamiento :Boolean,
    val alojamiento :Boolean,
    val cocina :Boolean

)

fun instalacionDTO.toInstalacion() = Instalacion(
    nombreDeInstalacion = nombreDeInstalacion,
    descripcionDeInstalacion = descripcionDeInstalacion,
    costoDeInstalacion = costoDeInstalacion,
    CapacidadInstalacion = capacidadInstalacion,
    calle = calle,
    altura = altura,
    LocalidadDeInstalacion = localidadDeInstalacion,
    provincia = provincia,
    montoDeReserva = montoDeReserva,
    imagenPrincipal = imagenPrincipal,
    mail = mail,
    numeroDeTelefono = numeroDeTelefono,
    terraza = terraza,
    cocina = cocina,
    alojamiento = alojamiento,
    jardin = jardin,
    baños = baños
)