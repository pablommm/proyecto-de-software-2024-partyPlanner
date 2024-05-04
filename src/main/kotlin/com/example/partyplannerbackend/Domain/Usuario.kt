package com.example.partyplannerbackend.Domain

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import jakarta.persistence.*
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
@Table(name = "usuarios")
class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val nombreYApellido :String= "",
    @Column
    val username: String = "",
    @Column
    val contrasenia : String= "",
    @OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "evento_id")
    val eventos : MutableList<Evento> = mutableListOf(),
    @Column
    val rol : Rol = Rol.CONSUMIDOR,
    @Column
    var saldo : Double = 0.0
){




    fun aniadirEvento(evento: Evento) = eventos.add(evento)

    fun tengoSaldoParaSeniar(instalacion: Instalacion) = saldo >= instalacion.costoDeInstalacion

    fun pagoDeReserva(instalacion: Instalacion) {
        saldo -= instalacion.montoDeReserva
        instalacion.aniadirDineroDeReserva(instalacion.montoDeReserva)
    }

    fun reservarLugar(instalacion: Instalacion, fecha : Reserva) {
        instalacion.validarReserva(fecha)
        puedoSeniar(instalacion)
        pagoDeReserva(instalacion)
    }

     fun puedoSeniar(instalacion: Instalacion) {
        if (!tengoSaldoParaSeniar(instalacion)) {
            throw RuntimeException("No hay suficiente salgo para reservar")
        }
    }


    fun eventosActivos() = eventos.filter { it.fechaEventoIni > LocalDateTime.now() }


    // Validaciones
    fun esValidoNombre() = nombreYApellido.isEmpty()
    fun validarNombre() {
        if(esValidoNombre()) throw RuntimeException("El nombre esta vacio")
    }

    fun esValidoUsername() = username.isEmpty()
    fun validarUsername() {
        if(esValidoUsername()) throw RuntimeException("El username esta vacio")
    }

    fun esValidoContrasenia() = contrasenia.isEmpty()
    fun validarContrasenia() {
        if(esValidoContrasenia()) throw RuntimeException("El contraseña esta vacio")
    }

     fun validar() {
        validarNombre()
        validarContrasenia()
        validarUsername()
    }

    fun accesoUsuario(user: UsuarioLoginDTO): Boolean {
        return user.usuario == username && user.contrasenia == contrasenia
    }

}