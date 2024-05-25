package com.example.partyplannerbackend.Domain

import jakarta.persistence.*

@Entity
@Table(name = "Imagenes")
class Imagen(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val url :String = "") {
}