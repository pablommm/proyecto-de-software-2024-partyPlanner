package com.example.partyplannerbackend.Boostrap

import com.example.partyplannerbackend.Domain.*
import com.example.partyplannerbackend.Repositorio.*
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
    lateinit var repoUser: usuarioRepository

    @Autowired(required = true)
    lateinit var repoInstalacion: InstalacionRepository

    @Autowired(required = true)
    lateinit var repoServicios: ServicioRepository

    @Autowired(required = true)
    lateinit var repoEventos: EventoRepository

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
    val lugarGeneric = Instalacion(
        nombreDeInstalacion = "Generic",
        descripcionDeInstalacion = "",
        costoDeInstalacion = 1,
        CapacidadInstalacion = 1,
        LocalidadDeInstalacion = "",
        montoDeReserva = 0.0,
        imagenPrincipal = "https://i.ibb.co/DwGzkdy/foto-salon-diamante.webp"
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
        repoInstalacion.save(salonDiamante)
        repoInstalacion.save(salonMix)
        //repoInstalacion.create(teatro)
    }

    // Servicios
    val catering = Servicio(nombreDeServicio = "Servicio de catering", descripcion = "esto es una descripcion lalalalalalalalalalalalalalalalala",categoria = Categoria.GASTRONOMIA, monto = 5000.0)
    val seguridad = Servicio(nombreDeServicio = "Servicio de seguridad",descripcion = "esto es una descripcion lalalalalalalalalalalalalalalalala",categoria = Categoria.ACCESORIOS, monto = 5000.0)
    val limpieza = Servicio(nombreDeServicio = "Servicio de limpieza", descripcion = "esto es una descripcion lalalalalalalalalalalalalalalalala",categoria = Categoria.ACCESORIOS, monto = 5000.0)


    fun crearServicios(){
        repoServicios.save(catering)
        repoServicios.save(seguridad)
        repoServicios.save(limpieza)
    }


    val bodaMYB = Evento(nombreDelEvento = "Boda de Matias y Belen",lugar = salonDiamante, fechaEventoIni = LocalDateTime.now(), fechaEventoFin = LocalDateTime.now(),serviciosAdquiridos = mutableListOf(catering))

    val fiestaCumpleaños = Evento(
        nombreDelEvento = "Fiesta de cumpleaños de Juan",
        lugar = salonDiamante,
        fechaEventoIni = LocalDateTime.now(),
        fechaEventoFin = LocalDateTime.now(),
        serviciosAdquiridos = mutableListOf(catering)
    )

    fun crearEventos(){
        repoEventos.save(bodaMYB)
        repoEventos.save(fiestaCumpleaños)

    }
    val usuarioPrueba = Usuario(
        nombreYApellido = "Jhon Smith",
        username = "Jsmith",
        contrasenia = "1234",

    )

    val usuario1 = Usuario(
        nombreYApellido = "Juan perez",
        username = "Jperez",
        contrasenia = "1234",
        rol = Rol.ADMINISTRADOR,
        eventos = mutableListOf(bodaMYB))

    fun crearUser(){
        repoUser.save(usuario1)
        repoUser.save(usuarioPrueba)
    }

}