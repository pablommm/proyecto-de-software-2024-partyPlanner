package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.Usuario


data class UsuarioLoginDTO (
    val usuario : String ,
    val contrasenia : String
)

fun Usuario.toDTO() = UsuarioLoginDTO(usuario = username, contrasenia = contrasenia)


