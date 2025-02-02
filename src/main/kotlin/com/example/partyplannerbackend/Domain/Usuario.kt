package com.example.partyplannerbackend.Domain

import com.example.partyplannerbackend.DTO.UsuarioCreateDTO
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
    var nombreYApellido :String= "",
    @Column
    var username: String = "",
    @Column
    var contrasenia : String= "",
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioID")
    val eventos : MutableList<Evento> = mutableListOf(),
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioID")
    val instalaciones : MutableList<Instalacion> = mutableListOf(),
    @Column
    val rol : Rol = Rol.CONSUMIDOR,
    @Column
    var saldo : Double = 0.0,
    @Column
    var activo : Boolean = true
){
    fun agregarInstalacion( instalacion: Instalacion){
        instalaciones.add(instalacion)
    }
    fun activar(){
        this.activo = true
    }
    fun desactivar()
    {
        this.activo=false
    }

    fun acreditarCarga(saldo: Double){
        this.saldo+= saldo
    }


    fun aniadirEvento(evento: Evento) {
        this.eventos.add(evento)
    }

    fun totalDeEventos() = eventos.count()

    fun tengoSaldoParaSeniar(instalacion: Instalacion) = saldo >= instalacion.costoDeInstalacion

    fun pagoDeReserva(instalacion: Instalacion,dias: Int) {
        saldo -= instalacion.montoDeReserva * dias
        instalacion.aniadirDineroDeReserva(instalacion.montoDeReserva)
    }

    fun reservarLugar(instalacion: Instalacion, fecha : Reserva,dias :Int) {
        instalacion.validarReserva(fecha)
        puedoSeniar(instalacion)
        pagoDeReserva(instalacion,dias)
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
    fun validacionUsernameUnique(user: UsuarioCreateDTO) :Boolean{
        return user.usuario == username
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