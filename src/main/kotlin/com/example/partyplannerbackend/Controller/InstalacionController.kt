package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.*
import com.example.partyplannerbackend.Domain.*
import com.example.partyplannerbackend.Services.InstalacionService
import com.example.partyplannerbackend.Services.MantenimientoService
import com.example.partyplannerbackend.Services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import java.util.*

@RestController
@CrossOrigin("*")
class InstalacionController(@Autowired val mantenimientoService : MantenimientoService, @Autowired val instalacionService: InstalacionService, @Autowired val usuarioService: UsuarioService ) {

    @GetMapping("/Instalaciones")
    fun getInstalacionesTodas() = instalacionService.getInstalacionesTodas()

    @GetMapping("/InstalacionesActivas")
    fun getInstalacionesActivas() = instalacionService.getInstalacionActivos()

    @GetMapping("/Instalaciones/")
    fun getInstalacionesActivas(@PathVariable id : Long): Optional<Instalacion> {
        return instalacionService.getInstalacionById(id)
    }

    @GetMapping("/fechasBloqueadas/{id}")
    fun getFechasBloqueadas(@PathVariable id : Long): MutableList<Reserva> {
        return instalacionService.getListaFechasInstalacionById(id)
    }
    @DeleteMapping("/deleteInstalacion/{id}")
    fun delete(@PathVariable id: Long): Instalacion {
        return instalacionService.desactivarInstalacion(id)
    }
    @PutMapping("/activarInstalacion/{id}")
    fun active(@PathVariable  id : Long) : Instalacion {
        return instalacionService.activarInstalacion(id)
    }
    @PostMapping("/CrearInstalacion")
    fun create(@RequestBody instalacionBody: instalacionDTO): Instalacion {
       instalacionService.validateUniqueNombre(instalacionBody)
        val usuario = usuarioService.getUser(instalacionBody.owner).get()
        val nueaInstalacion = instalacionService.crearInstalacion(instalacionBody.toInstalacion())
        usuario.agregarInstalacion(nueaInstalacion)
        usuarioService.guardarr(usuario)
        return nueaInstalacion
    }

    @PutMapping("/EditarInstalacion/{id}")
    fun editar(@PathVariable id: Long , @RequestBody instalacionBody: instalacionDTO) : Instalacion {
        val instalacionExistente = instalacionService.getInstalacionById(id).get()

        instalacionExistente.nombreDeInstalacion = instalacionBody.nombreDeInstalacion
        instalacionExistente.descripcionDeInstalacion =instalacionBody.descripcionDeInstalacion
        instalacionExistente.costoDeInstalacion = instalacionBody.costoDeInstalacion
        instalacionExistente.CapacidadInstalacion =instalacionBody.capacidadInstalacion
        instalacionExistente.LocalidadDeInstalacion =instalacionBody.localidadDeInstalacion
        instalacionExistente.montoDeReserva = instalacionBody.montoDeReserva
        instalacionExistente.calle=instalacionBody.calle
        instalacionExistente.altura=instalacionBody.altura
        instalacionExistente.provincia=instalacionBody.provincia
        instalacionExistente.numeroDeTelefono=instalacionBody.numeroDeTelefono
        instalacionExistente.mail=instalacionBody.mail
        instalacionExistente.baños=instalacionBody.baños
        instalacionExistente.terraza=instalacionBody.terraza
        instalacionExistente.jardin=instalacionBody.jardin
        instalacionExistente.estacionamiento=instalacionBody.estacionamiento
        instalacionExistente.alojamiento=instalacionBody.alojamiento
        instalacionExistente.cocina=instalacionBody.cocina

        val instalacionModificado = instalacionService.guardar(instalacionExistente)

        return instalacionModificado
    }

    @GetMapping("/buscar/{nombre}")
    fun buscarPorNombre(@PathVariable nombre: String): List<Instalacion> {
        val nombreLower= nombre.lowercase()
        val porcentaje = "%$nombreLower%"
        return instalacionService.buscarPorNombreOubicacion(porcentaje)
    }
// FALTA AGREGAR PARAMETROS Y LA FUNCION DE CREAR EN service y guardar el mantenimiento para que setee el id
    @PostMapping("/CrearMantenimiento")
    fun create(@RequestBody mantenimientoDTO: MantenimientoDTO): Mantenimiento {
        val instalacionid = instalacionService.getInstalacionById(mantenimientoDTO.Lugar).get()
        val propietario = usuarioService.getUser(mantenimientoDTO.owner).get()
        val mantenimiento= mantenimientoService.crearMantenimiento(mantenimientoDTO.toMantenimiento())

        if(usuarioService.misPropiedadesByIDinstalacion(mantenimientoDTO.owner,mantenimientoDTO.Lugar).isEmpty()){
            throw RuntimeException("No es propietario")

        }

        instalacionid.agregarMantenimiento(mantenimiento)
        instalacionService.guardar(instalacionid)
        mantenimientoService.guardar(mantenimiento)
        return mantenimiento
    }
    @GetMapping("/fechasBloqueadasMantenimiento/{id}")
    fun getFechasBloqueadasMantenimiento(@PathVariable id : Long): MutableList<Mantenimiento> {
        return instalacionService.getListaFechasMantenimientoInstalacionById(id)
    }

}