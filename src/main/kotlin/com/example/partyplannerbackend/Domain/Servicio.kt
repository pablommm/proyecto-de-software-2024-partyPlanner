package com.example.partyplannerbackend.Domain

class Servicio(
    val nombreDeServicio: String,
    val descripcion: String,
    val categoria: Categoria = Categoria.GASTRONOMIA,
    val monto : Double
) :Entidad(){


    override fun validar() {
        TODO("Not yet implemented")
    }


}