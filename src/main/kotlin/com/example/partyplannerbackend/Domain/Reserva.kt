package com.example.partyplannerbackend.Domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Reserva")
class Reserva(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val fechaIni:LocalDateTime = LocalDateTime.now(),
    @Column
    val fechaFin:LocalDateTime = LocalDateTime.now() ){

}