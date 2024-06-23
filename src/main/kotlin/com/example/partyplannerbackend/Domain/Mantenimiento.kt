package com.example.partyplannerbackend.Domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Mantenimiento")
class Mantenimiento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val fechaIni:LocalDateTime = LocalDateTime.now(),
    @Column
    val fechaFin:LocalDateTime = LocalDateTime.now(),
    @Column
    var descripcion: String= ""
){

}
