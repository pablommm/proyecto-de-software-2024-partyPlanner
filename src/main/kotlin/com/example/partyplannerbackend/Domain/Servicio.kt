package com.example.partyplannerbackend.Domain

import jakarta.persistence.*

@Entity
@Table(name = "Servicio")
class Servicio(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val nombreDeServicio: String,
    @Column
    val descripcion: String,
    @Column
    val categoria: Categoria = Categoria.GASTRONOMIA,
    @Column
    val monto : Double
){
    fun esValidoNombre() = nombreDeServicio.isEmpty()
    fun validarnombreDeServicio(){
        if(esValidoNombre()) throw RuntimeException("El nombre esta vacio")
    }

     fun validar() {
        validarnombreDeServicio()
    }


}