package com.example.partyplannerbackend.Domain

abstract class Entidad {
    var id1: Int = 0
    var activo : Boolean = true

    abstract  fun validar()

}
