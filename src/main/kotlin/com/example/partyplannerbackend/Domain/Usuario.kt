package com.example.partyplannerbackend.Domain

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import java.time.LocalDateTime

class Usuario (
    val nombreYApellido :String,
    val username: String,
    val contrasenia : String,
    val eventos : MutableList<Evento> = mutableListOf(),
    val rol : Rol = Rol.CONSUMIDOR,
    var saldo : Double = 0.0
): Entidad(){

    fun aniadirEvento(evento: Evento) = eventos.add(evento)

    fun tengoSaldoParaSeniar(instalacion: Instalacion) = saldo >= instalacion.costoDeInstalacion

    fun pagoDeReserva(instalacion: Instalacion) {
        saldo -= instalacion.montoDeReserva
        instalacion.aniadirDineroDeReserva(instalacion.montoDeReserva)
    }

    fun reservarLugar(instalacion: Instalacion, fecha : LocalDateTime) {
        instalacion.validarReserva(fecha)
        puedoSeniar(instalacion)
        pagoDeReserva(instalacion)
    }

     fun puedoSeniar(instalacion: Instalacion) {
        if (!tengoSaldoParaSeniar(instalacion)) {
            throw RuntimeException("No hay suficiente salgo para reservar")
        }
    }


    fun eventosActivos() = eventos.filter { it.fechaEvento > LocalDateTime.now() }


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