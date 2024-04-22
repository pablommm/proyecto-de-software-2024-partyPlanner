package com.example.partyplannerbackend.Domain

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO

class Usuario (
    val nombreYApellido :String,
    val username: String,
    val contrasenia : String,
    val eventosRealizados : MutableList<Evento> = mutableListOf(),
    val rol : Rol = Rol.CONSUMIDOR
): Entidad(){

    fun aniadirEvento(evento: Evento) = eventosRealizados.add(evento)






    // Validaciones
    fun esValidoNombre() = nombreYApellido.isEmpty()
    fun validarNombre() {
        if(esValidoNombre()) throw RuntimeException("El nombre esta vacio")
    }

    fun esValidoUsername() = username.isEmpty()
    fun validarUsername() {
        if(esValidoUsername()) throw RuntimeException("El username esta vacio")
    }

    fun esValidoContrasenia() = contrasenia.isEmpty()
    fun validarContrasenia() {
        if(esValidoContrasenia()) throw RuntimeException("El contraseña esta vacio")
    }

    override fun validar() {
        validarNombre()
        validarContrasenia()
        validarUsername()
    }

    fun accesoUsuario(user: UsuarioLoginDTO): Boolean {
        return user.usuario == username && user.contrasenia == contrasenia
    }

}