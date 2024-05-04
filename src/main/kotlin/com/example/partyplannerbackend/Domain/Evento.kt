package com.example.partyplannerbackend.Domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "eventos")
class Evento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val nombreDelEvento: String= "",
    @OneToOne
    @JoinColumn(name = "instalacion_id")
    val lugar: Instalacion = Instalacion(),
    @Column
     val fechaEventoIni: LocalDateTime = LocalDateTime.now(),
    @Column
     val fechaEventoFin: LocalDateTime =LocalDateTime.now(),
    //  val cantidadDeInvitados :Int, de momento se deja
     @OneToMany(fetch = FetchType.EAGER)
     var serviciosAdquiridos : MutableList<Servicio> = mutableListOf()){



    // el evento debe sumar la lista de costo, generar un qr o target por evento
     fun costoTotalDeServicio() = serviciosAdquiridos.sumOf { it.monto }

    fun costoDelEvento() = costoTotalDeServicio() + lugar.costoDeInstalacion

    fun aniadirServicio(servicio :Servicio) = serviciosAdquiridos.add(servicio)

    fun esValidoNombre() = nombreDelEvento.isEmpty()
    fun validarNombre() {
        if(esValidoNombre()) throw RuntimeException("El nombre debe ser vacio")
    }

     fun validar() {
        validarNombre()
    }


}