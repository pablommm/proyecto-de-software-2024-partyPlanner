package com.example.partyplannerbackend.DTO

import com.example.partyplannerbackend.Domain.Rol
import com.example.partyplannerbackend.Domain.Usuario
import java.time.LocalDate


data class UsuarioLoginDTO (
    val usuario : String ,
    val contrasenia : String
)

fun Usuario.toDTO() = UsuarioLoginDTO(
    usuario = username,
    contrasenia = contrasenia)

data class UsuarioCreateDTO(
    val nombre:String,
    val apellido: String,
    val usuario: String,
    val pwd: String,
    val rol :Rol
    )



fun UsuarioCreateDTO.toUsuario() = Usuario(
    nombreYApellido = "$nombre"+" "+"$apellido",
    username =  usuario,
    contrasenia =  pwd,
    rol= rol
)

data class UsuarioModificado (
    val nombreYApellido : String ,
    val username : String ,
    val contrasenia : String,
    val saldo: Double
)

fun UsuarioModificado.toUsuario()= Usuario(
    nombreYApellido = nombreYApellido,
    username = username,
    contrasenia = contrasenia,
    saldo = saldo)
