package com.example.partyplannerbackend.Domain

import java.time.LocalDate
import javax.print.DocFlavor.URL

class Instalacion(
    val nombreDeInstalacion: String,
    val descripcionDeInstalacion: String,
    val costoDeInstalacion : Int,
    val CapacidadInstalacion: Int,
    val LocalidadDeInstalacion : String,
    val montoDeReserva :Double = costoDeInstalacion * 0.15,
    var fechasReservadas : MutableList<LocalDate> = mutableListOf(),
    val imagenPrincipal : String
): Entidad() {

    fun aniadirReserva(reserva : LocalDate) = fechasReservadas.add(reserva)
    fun removerReserva(reserva : LocalDate) = fechasReservadas.remove(reserva)

    // Validaciones
    fun validarReserva(nuevaReserva :LocalDate) {
        validarFechaMayorActual(nuevaReserva)
        validarFechaDisponible(nuevaReserva)
    }
    fun esMayorAlaFechaActual(nuevaReserva :LocalDate)= nuevaReserva >= LocalDate.now()
    fun validarFechaMayorActual(nuevaReserva: LocalDate) {
        if(!esMayorAlaFechaActual(nuevaReserva)) throw RuntimeException("La fecha debe ser mayor o igual a la actual")
    }
    fun estaDisponible(nuevaReserva :LocalDate) = fechasReservadas.any { it == nuevaReserva }

    fun validarFechaDisponible(nuevaReserva: LocalDate) {
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