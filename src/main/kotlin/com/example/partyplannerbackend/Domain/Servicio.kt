package com.example.partyplannerbackend.Domain

class Servicio(
    val nombreDeServicio: String,
    val descripcion: String,
    val categoria: Categoria = Categoria.GASTRONOMIA,
    val monto : Double
) :Entidad(){
    fun esValidoNombre() = nombreDeServicio.isEmpty()
    fun validarnombreDeServicio(){
        if(esValidoNombre()) throw RuntimeException("El nombre esta vacio")
    }

    override fun validar() {
        validarnombreDeServicio()
    }


}