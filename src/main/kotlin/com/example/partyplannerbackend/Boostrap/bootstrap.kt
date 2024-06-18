package com.example.partyplannerbackend.Boostrap

import com.example.partyplannerbackend.Domain.*
import com.example.partyplannerbackend.Repositorio.*
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class userMagic : InitializingBean {
    @Autowired(required = true)
    lateinit var repoUser: usuarioRepository

    @Autowired(required = true)
    lateinit var repoInstalacion: InstalacionRepository

    @Autowired(required = true)
    lateinit var repoServicios: ServicioRepository

    @Autowired(required = true)
    lateinit var repoEventos: EventoRepository


    override fun afterPropertiesSet() {

        crearServicios()
        crearInstalacion()
        crearUser()
        crearEventos()
    }



    // Instancia 2: Gimnasio
    val salonMix = Instalacion(
        nombreDeInstalacion = "Salon Mix",
        descripcionDeInstalacion = "Esta es la descripcion del salon mix lalalalala lalalallaa llalalala la",
        costoDeInstalacion = 1000,
        CapacidadInstalacion = 200,
        LocalidadDeInstalacion = "Madrid",
        imagenPrincipal = "https://i.ibb.co/HGdW34k/foto-salon-mix.webp"
    )
    val InstalacionGenerica = Instalacion(
        nombreDeInstalacion = "Tu evento, tu lugar",
        descripcionDeInstalacion = "¡Celebra tu evento en cualquier lugar! ",
        costoDeInstalacion = 0,
        CapacidadInstalacion = 1,
        LocalidadDeInstalacion = "",
        montoDeReserva = 0.0,
        imagenPrincipal = "https://i.ibb.co/DzBLCwz/download.jpg"
    )



    val usuarioPrueba = Usuario(
        nombreYApellido = "Jhon Smith",
        username = "Jsmith",
        contrasenia = "1234",
        saldo = 1000.0

        )



    fun crearUser(){
        repoUser.save(usuario1)
        repoUser.save(usuarioPrueba)
        repoUser.save(admin)
        repoUser.save(test)
        repoUser.save(test2)
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


    val usuario1 = Usuario(
        nombreYApellido = "Juan perez",
        username = "Jperez",
        contrasenia = "1234",
        rol = Rol.ADMINISTRADOR,
        eventos = mutableListOf()
    )
    val admin = Usuario(
        nombreYApellido = "admin",
        username = "admin",
        contrasenia = "admin",
        rol = Rol.ADMINISTRADOR,

    )
    val test = Usuario(
        nombreYApellido = "admin",
        username = "admin",
        contrasenia = "admin",
        rol = Rol.ADMINISTRADOR,

        )

    fun crearEventos(){
        repoEventos.save(bodaMYB)
        repoEventos.save(fiestaCumpleaños)
        repoEventos.save(fiestaCumpleaños2)
    }
    fun crearInstalacion(){
        repoInstalacion.save(InstalacionGenerica)
        repoInstalacion.save(salonDiamante)
        repoInstalacion.save(salonMix)

    }

    // Instancia 1: Estadio
    val salonDiamante = Instalacion(
        nombreDeInstalacion = "Salon Diamante",
        descripcionDeInstalacion = "Esta es la descripcion de salon diamante lalalala lalal al al ala la la la",
        costoDeInstalacion = 1000,
        CapacidadInstalacion = 80000,
        LocalidadDeInstalacion = "Buenos Aires",
        imagenPrincipal = "https://i.ibb.co/DwGzkdy/foto-salon-diamante.webp",

    )
    val bodaMYB = Evento(nombreDelEvento = "Boda de Matias y Belen",lugar = salonDiamante, fechaEventoIni = LocalDateTime.now(), fechaEventoFin = LocalDateTime.now(),serviciosAdquiridos = mutableListOf(seguridad), presupuesto = 2000000)

    val fiestaCumpleaños = Evento(
        nombreDelEvento = "Fiesta de cumpleaños de Juan",
        lugar = salonDiamante,
        fechaEventoIni = LocalDateTime.now(),
        fechaEventoFin = LocalDateTime.now(),
        serviciosAdquiridos = mutableListOf(catering)
    )
    val fiestaCumpleaños2 = Evento(
        nombreDelEvento = "Fiesta de cumpleaños de Juan",
        lugar = salonDiamante,
        fechaEventoIni = LocalDateTime.now(),
        fechaEventoFin = LocalDateTime.now(),
        serviciosAdquiridos = mutableListOf()
    )
    val test2 = Usuario(
        nombreYApellido = "admin",
        username = "admin",
        contrasenia = "admin",
        rol = Rol.PROPIETARIO,
        instalaciones = mutableListOf(salonMix)
        )

}