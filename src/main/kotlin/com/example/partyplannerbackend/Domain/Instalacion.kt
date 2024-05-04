package com.example.partyplannerbackend.Domain

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import javax.print.DocFlavor.URL
@Entity
@Table(name = "instalacion")
class Instalacion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val nombreDeInstalacion: String = "",
    @Column
    val descripcionDeInstalacion: String= "",
    @Column
    val costoDeInstalacion : Int =1,
    @Column
    val CapacidadInstalacion: Int=1,
    @Column
    val LocalidadDeInstalacion : String = "",
    @Column
    val montoDeReserva :Double = costoDeInstalacion * 0.15,
    @Column
    var recaudacionDeReservas : Double = 0.0,
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "reserva_id")
    var fechasReservadas : MutableList<Reserva> = mutableListOf(),
    @Column
    val imagenPrincipal : String = ""
) {


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
        *   nueva reserva serva contenga dentro del rango un evento existe
        *
        * testear y validar si faltan casos
        * */
        for (reserva in fechasReservadas) {
        // 1  ambas fechas esten dentro de la reserva anterior
        if(nuevaReserva.fechaIni > reserva.fechaIni && nuevaReserva.fechaFin< reserva.fechaFin){
            throw RuntimeException("El lugar ya esta reservado en las fechas seleccionadas.")
        }
         // 2   caso fecha ini entre reserva
        if(nuevaReserva.fechaIni < reserva.fechaFin && nuevaReserva.fechaFin > reserva.fechaFin){
            throw RuntimeException("bbb")

        }
         //3 caso fecha fin dentro de la reserva anterior
        if(nuevaReserva.fechaIni < reserva.fechaIni && nuevaReserva.fechaFin > reserva.fechaIni){
            throw RuntimeException("ccc")
        }
        // 4
        if(nuevaReserva.fechaIni < reserva.fechaIni && nuevaReserva.fechaFin > reserva.fechaFin){
            throw RuntimeException("ddd")
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



      fun validar() {
        validarLocalidad()
        validardescripcionDeInstalacion()
        validarNombre()
        validarCapacidadInstalacion()
        validarcostoDeInstalacion()
    }


}
