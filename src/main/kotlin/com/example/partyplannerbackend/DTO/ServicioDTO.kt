package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.*
import java.time.LocalDateTime

data class servicioDTO(
    val nombreDeServicio: String,
    val descripcion: String,
    val categoria: Categoria,
    val monto : Double,
    val eventoID :Long
)


fun servicioDTO.toServicio() = Servicio(
    nombreDeServicio = nombreDeServicio,
    descripcion = descripcion,
    categoria = categoria,
    monto = monto

)