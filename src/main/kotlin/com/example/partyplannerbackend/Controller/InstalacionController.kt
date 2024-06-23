package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.*
import com.example.partyplannerbackend.Domain.*
import com.example.partyplannerbackend.Services.InstalacionService
import com.example.partyplannerbackend.Services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import java.util.*

@RestController
@CrossOrigin("*")
class InstalacionController(@Autowired val instalacionService: InstalacionService,@Autowired val usuarioService: UsuarioService ) {

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

        val instalacionModificado = instalacionService.guardar(instalacionExistente)

        return instalacionModificado
    }

    @GetMapping("/buscar/{nombre}")
    fun buscarPorNombre(@PathVariable nombre: String): List<Instalacion> {
        val nombreLower= nombre.lowercase()
        val porcentaje = "%$nombreLower%"
        return instalacionService.buscarPorNombreOubicacion(porcentaje)
    }

    @PostMapping("/CrearMantenimiento")
    fun create(@RequestBody mantenimientoDTO: MantenimientoDTO): Mantenimiento {
        val instalacionid = instalacionService.getInstalacionById(mantenimientoDTO.Lugar).get()
        val propietario = usuarioService.getUser(mantenimientoDTO.owner).get()

        if(usuarioService.misPropiedadesByIDinstalacion(mantenimientoDTO.owner,mantenimientoDTO.Lugar).isEmpty()){
            throw RuntimeException("No es propietario")

        }


        return mantenimientoDTO.toMantenimiento()
    }


}