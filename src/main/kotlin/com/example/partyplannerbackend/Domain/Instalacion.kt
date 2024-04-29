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
    var fechasReservadas : MutableList<Reserva> = mutableListOf(),
    val imagenPrincipal : String
): Entidad() {

    fun aniadirReserva(reserva : Reserva) = fechasReservadas.add(reserva)
    fun removerReserva(reserva : Reserva) = fechasReservadas.remove(reserva)

    fun aniadirDineroDeReserva(recaudacion : Double) = recaudacionDeReservas +recaudacion
    // Validaciones
    fun validarReserva(nuevaReserva :Reserva) {
        validarFechaMayorActual(nuevaReserva)
        validarFechaMayorIni(nuevaReserva)
        estaDisponible(nuevaReserva)
        aniadirReserva(nuevaReserva)
    }

    fun esMayorAlaFechaActual(nuevaReserva : Reserva)= nuevaReserva.fechaIni >= LocalDateTime.now()
    fun esLaFechaFinEsMayorALaIni(nuevaReserva : Reserva)= nuevaReserva.fechaFin > nuevaReserva.fechaIni
    fun validarFechaMayorIni(nuevaReserva: Reserva) {
        if(!esLaFechaFinEsMayorALaIni(nuevaReserva)) throw RuntimeException("La fecha debe ser mayor o igual a la actual")
    }
    fun validarFechaMayorActual(nuevaReserva: Reserva) {
        if(!esMayorAlaFechaActual(nuevaReserva)) throw RuntimeException("La fecha debe ser mayor o igual a la actual")
    }
    fun estaDisponible(nuevaReserva :Reserva): Boolean {
        /*
        *   1 - ambas fechas esten dentro de la reserva anterior
        *   dos casos que esten dentro de la reserva
        *    caso fecha ini entre reserva && otro caso fecha fin dentro de la reserva anterior
        *   nueva reserva serva contenga dentro del rango un evento existe
        *
        * testear y validar si faltan casos
        * */
        for (reserva in fechasReservadas) {
        // 1
        if(nuevaReserva.fechaIni > reserva.fechaIni && nuevaReserva.fechaFin< reserva.fechaFin){
            throw RuntimeException("aaa")
        }
        if(nuevaReserva.fechaIni < reserva.fechaFin && nuevaReserva.fechaFin > reserva.fechaFin){
            throw RuntimeException("bbb")

        }
        if(nuevaReserva.fechaIni < reserva.fechaIni && nuevaReserva.fechaFin > reserva.fechaIni){
            throw RuntimeException("ccc")
        }

        }
        return true
    }





    fun validarFechaDisponible(nuevaReserva: Reserva) {
      //  if(estaDisponible(nuevaReserva)) throw RuntimeException("La fecha no esta disponible")
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
