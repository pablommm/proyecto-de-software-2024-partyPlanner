package com.example.partyplannerbackend.Domain

import jakarta.persistence.*

@Entity
@Table(name = "usuarios_eventos")
class Usuarios_Eventos(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    val usuario: Usuario? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eventos_id")
    val evento: Evento? = null
) {

}