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
    var nombreDelEvento: String= "",
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lugar_id")
    val lugar: Instalacion = Instalacion(),
    @Column
     val fechaEventoIni: LocalDateTime = LocalDateTime.now(),
    @Column
     val fechaEventoFin: LocalDateTime =LocalDateTime.now(),
    @Column
    val presupuesto : Int = 1,
    @Column
    var estadoPresupuesto : Int = 1,
     @OneToMany(fetch = FetchType.EAGER)
     @JoinColumn(name = "id_evento")
     var serviciosAdquiridos : MutableList<Servicio> = mutableListOf(),
     @Column
     var activo : Boolean = true
){

    fun desactivar()
    {
        this.activo=false
    }

    fun eventoPasado(){
        if(fechaEventoFin.isAfter(LocalDateTime.now())){
            desactivar()
        }
    }

    // el evento debe sumar la lista de costo, generar un qr o target por evento
    fun costoTotalDeServicio() = serviciosAdquiridos.sumOf { it.monto }

    fun costoDelEvento() = costoTotalDeServicio() + lugar.costoDelaInstalacionDescontandoReserva()

    fun aniadirServicio(servicio :Servicio) = serviciosAdquiridos.add(servicio)

    fun esValidoNombre() = nombreDelEvento.isEmpty()
    fun validarNombre() {
        if(esValidoNombre()) throw RuntimeException("El nombre debe ser vacio")
    }

    fun esValidoEstadoPresupuesto() :Boolean = estadoPresupuesto in 1..3
    fun validarnroDeCamiseta(){ if(!esValidoEstadoPresupuesto()) throw RuntimeException("El numero no es valido ") }


    fun porcentajeGastado()= (costoDelEvento() * 100) / presupuesto


    fun actualizarEstadoDePresupuesto() {
        estadoPresupuesto= when (porcentajeGastado()) {
            in 0.0..80.0 -> 1
            in 81.0..95.0 -> 2
            else -> 3
        }
    }

     fun validar() {
        validarNombre()
         validarnroDeCamiseta()
    }


}