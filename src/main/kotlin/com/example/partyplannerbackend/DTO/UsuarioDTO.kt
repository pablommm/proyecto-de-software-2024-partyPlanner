package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.Usuario
import java.time.LocalDate


data class UsuarioLoginDTO (
    val usuario : String ,
    val contrasenia : String
)

fun Usuario.toDTO() = UsuarioLoginDTO(usuario = username, contrasenia = contrasenia)

data class UsuarioCreateDTO(
    val nombreYApellido: String,
    val usuario: String,
    val pwd: String)

fun UsuarioCreateDTO.toUsuario() = Usuario(nombreYApellido = nombreYApellido,  username =  usuario, contrasenia =  pwd)
