package com.example.partyplannerbackend.Domain

import jakarta.persistence.*

@Entity
@Table(name = "Servicio")
class Servicio(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    var nombreDeServicio: String= "",
    @Column
    var descripcion: String= "",
    @Column
    var categoria: Categoria = Categoria.GASTRONOMIA,
    @Column
    var monto : Double = 0.0,
    @Column
    var activo :Boolean = true
){

    fun desactivar()
    {
        this.activo=false
    }

    fun esValidoNombre() = nombreDeServicio.isEmpty()
    fun validarnombreDeServicio(){
        if(esValidoNombre()) throw RuntimeException("El nombre esta vacio")
    }

     fun validar() {
        validarnombreDeServicio()
    }


}