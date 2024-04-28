package com.example.partyplannerbackend.Domain

import java.time.LocalDate
import java.time.LocalDateTime
import javax.print.DocFlavor.URL

class Instalacion(
    val nombreDeInstalacion: String,
    val descripcionDeInstalacion: String,
    val costoDeInstalacion : Int,
    val CapacidadInstalacion: Int,
    val LocalidadDeInstalacion : String,
    val montoDeReserva :Double = costoDeInstalacion * 0.15,
    var recaudacionDeReservas : Double = 0.0,
    var fechasReservadas : MutableList<LocalDateTime> = mutableListOf(),
    val imagenPrincipal : String
): Entidad() {

    fun aniadirReserva(reserva : LocalDateTime) = fechasReservadas.add(reserva)
    fun removerReserva(reserva : LocalDateTime) = fechasReservadas.remove(reserva)

    fun aniadirDineroDeReserva(recaudacion : Double) = recaudacionDeReservas +recaudacion
    // Validaciones
    fun validarReserva(nuevaReserva :LocalDateTime) {
        validarFechaMayorActual(nuevaReserva)
        validarFechaDisponible(nuevaReserva)
    }

    fun esMayorAlaFechaActual(nuevaReserva : LocalDateTime)= nuevaReserva >= LocalDateTime.now()
    fun validarFechaMayorActual(nuevaReserva: LocalDateTime) {
        if(!esMayorAlaFechaActual(nuevaReserva)) throw RuntimeException("La fecha debe ser mayor o igual a la actual")
    }
    fun estaDisponible(nuevaReserva :LocalDateTime) = fechasReservadas.contains(nuevaReserva)

    fun validarFechaDisponible(nuevaReserva: LocalDateTime) {
        if(!estaDisponible(nuevaReserva)) throw RuntimeException("La fecha no esta disponible")
    }

    fun esValidoNombre() = nombreDeInstalacion.isEmpty()
    fun validarNombre() {
        if(esValidoNombre()) throw RuntimeException("El nombre esta vacio")
    }

    fun esValidocostoDeInstalacionn() = costoDeInstalacion > 0
    fun validarcostoDeInstalacion() {
        if(!esValidocostoDeInstalacionn()) throw RuntimeException("El costo de instalacion tiene que ser mayor a 0")
    }

    fun esValidoCapacidadInstalacion() = CapacidadInstalacion > 0
    fun validarCapacidadInstalacion() {
        if(!esValidoCapacidadInstalacion()) throw RuntimeException("La capacidad de instalacion tiene que ser mayor a 0")
    }

    fun esValidoLocalidad() = LocalidadDeInstalacion.isEmpty()
    fun validarLocalidad() {
        if(esValidoLocalidad()) throw RuntimeException("La localidad esta vacio")
    }

    fun esValidodescripcionDeInstalacion() = descripcionDeInstalacion.isEmpty()
    fun validardescripcionDeInstalacion() {
        if(esValidodescripcionDeInstalacion()) throw RuntimeException("La descripcion no puede estar vacio")
    }



    override fun validar() {
        validarLocalidad()
        validardescripcionDeInstalacion()
        validarNombre()
        validarCapacidadInstalacion()
        validarcostoDeInstalacion()
    }


}