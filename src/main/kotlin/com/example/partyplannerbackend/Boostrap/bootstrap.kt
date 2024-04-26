package com.example.partyplannerbackend.Boostrap

import com.example.partyplannerbackend.Domain.*
import com.example.partyplannerbackend.Repositorio.RepoEventos
import com.example.partyplannerbackend.Repositorio.RepoInstalacion
import com.example.partyplannerbackend.Repositorio.RepoServicios
import com.example.partyplannerbackend.Repositorio.RepoUser
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class userMagic : InitializingBean {
    override fun afterPropertiesSet() {
        crearUser()
        crearInstalacion()
        crearServicios()
        crearEventos()
    }

    @Autowired(required = true)
    lateinit var repoUser: RepoUser

    val usuarioPrueba = Usuario(
        nombreYApellido = "Jhon Smith",
        username = "Jsmith",
        contrasenia = "1234"

    )

    val usuario1 = Usuario(
        nombreYApellido = "Juan perez",
        username = "Jperez",
        contrasenia = "1234",
        rol = Rol.ADMINISTRADOR
    )

    fun crearUser(){
        repoUser.create(usuario1)
        repoUser.create(usuarioPrueba)
    }

    @Autowired(required = true)
    lateinit var repoInstalacion: RepoInstalacion

    // Instancia 1: Estadio
    val salonDiamante = Instalacion(
        nombreDeInstalacion = "Salon Diamante",
        descripcionDeInstalacion = "Esta es la descripcion de salon diamante lalalala lalal al al ala la la la",
        costoDeInstalacion = 1000000,
        CapacidadInstalacion = 80000,
        LocalidadDeInstalacion = "Buenos Aires",
        imagenPrincipal = "https://i.ibb.co/DwGzkdy/foto-salon-diamante.webp"
    )

    // Instancia 2: Gimnasio
    val salonMix = Instalacion(
        nombreDeInstalacion = "Salon Mix",
        descripcionDeInstalacion = "Esta es la descripcion del salon mix lalalalala lalalallaa llalalala la",
        costoDeInstalacion = 500000,
        CapacidadInstalacion = 200,
        LocalidadDeInstalacion = "Madrid",
        imagenPrincipal = "https://i.ibb.co/HGdW34k/foto-salon-mix.webp"
    )

    // Instancia 3: Teatro
   /* val teatro = Instalacion(
        nombreDeInstalacion = "Teatro Nacional",
        descripcionDeInstalacion = "Teatro histórico",
        costoDeInstalacion = 800000,
        CapacidadInstalacion = 500,
        LocalidadDeInstalacion = "Ciudad de México"
    )*/

    fun crearInstalacion(){
        repoInstalacion.create(salonDiamante)
        repoInstalacion.create(salonMix)
        //repoInstalacion.create(teatro)
    }


    @Autowired(required = true)
    lateinit var repoServicios: RepoServicios

    // Servicios
    val catering = Servicio(nombreDeServicio = "Servicio de catering", descripcion = "esto es una descripcion lalalalalalalalalalalalalalalalala",categoria = Categoria.GASTRONOMIA, monto = 5000.0)
    val seguridad = Servicio(nombreDeServicio = "Servicio de seguridad",descripcion = "esto es una descripcion lalalalalalalalalalalalalalalalala",categoria = Categoria.ACCESORIOS, monto = 5000.0)
    val limpieza = Servicio(nombreDeServicio = "Servicio de limpieza", descripcion = "esto es una descripcion lalalalalalalalalalalalalalalalala",categoria = Categoria.ACCESORIOS, monto = 5000.0)


    fun crearServicios(){
        repoServicios.create(catering)
        repoServicios.create(seguridad)
        repoServicios.create(limpieza)
    }

    @Autowired(required = true)
    lateinit var repoEventos: RepoEventos

    val bodaMYB = Evento(nombreDelEvento = "Boda de Matias y Belen",lugar = salonDiamante, fechaEvento = LocalDateTime.now(),serviciosAdquiridos = mutableListOf(catering))

    val fiestaCumpleaños = Evento(
        nombreDelEvento = "Fiesta de cumpleaños de Juan",
        lugar = salonDiamante,
        fechaEvento = LocalDateTime.now(),
        serviciosAdquiridos = mutableListOf(catering)
    )

    fun crearEventos(){
        repoEventos.create(bodaMYB)
        repoEventos.create(fiestaCumpleaños)

    }

}