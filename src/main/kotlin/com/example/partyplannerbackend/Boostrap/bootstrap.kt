package com.example.partyplannerbackend.Boostrap


import com.example.partyplannerbackend.Domain.*
import com.example.partyplannerbackend.Repositorio.RepoInstalacion
import com.example.partyplannerbackend.Repositorio.RepoServicios
import com.example.partyplannerbackend.Repositorio.RepoUser
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class userMagic : InitializingBean {
    override fun afterPropertiesSet() {
        crearUser()
    }

    @Autowired(required = true)
    lateinit var repoUser: RepoUser

    val usuarioPrueba = Usuario(
        nombreYApellido = "juanperez1",
        username = "sarasa",
        contrasenia = "1234"
    )

    val usuario1 = Usuario(
        nombreYApellido = "Verito 666",
        username = "veritorezando",
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
    val estadio = Instalacion(
        nombreDeInstalacion = "Estadio Monumental",
        descripcionDeInstalacion = "Estadio de fútbol",
        costoDeInstalacion = 1000000,
        CapacidadInstalacion = 80000,
        LocalidadDeInstalacion = "Buenos Aires"
    )

    // Instancia 2: Gimnasio
    val gimnasio = Instalacion(
        nombreDeInstalacion = "Gimnasio Fitness Plus",
        descripcionDeInstalacion = "Gimnasio con equipos de última generación",
        costoDeInstalacion = 500000,
        CapacidadInstalacion = 200,
        LocalidadDeInstalacion = "Madrid"
    )

    // Instancia 3: Teatro
    val teatro = Instalacion(
        nombreDeInstalacion = "Teatro Nacional",
        descripcionDeInstalacion = "Teatro histórico",
        costoDeInstalacion = 800000,
        CapacidadInstalacion = 500,
        LocalidadDeInstalacion = "Ciudad de México"
    )

    fun crearInstalacion(){
        repoInstalacion.create(estadio)
        repoInstalacion.create(gimnasio)
        repoInstalacion.create(teatro)
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


}