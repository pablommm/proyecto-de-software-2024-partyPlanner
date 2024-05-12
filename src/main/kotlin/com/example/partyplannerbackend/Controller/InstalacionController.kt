package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.*
import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Reserva
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Services.InstalacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class InstalacionController(@Autowired val instalacionService: InstalacionService) {

    @GetMapping("/Instalaciones")
    fun getInstalacionesTodas() = instalacionService.getInstalacionesTodas()

    @GetMapping("/InstalacionesActivas")
    fun getInstalacionesActivas() = instalacionService.getInstalacionActivos()

    @GetMapping("/Instalaciones/")
    fun getInstalacionesActivas(@PathVariable id : Long): Optional<Instalacion> {
        return instalacionService.getInstalacionById(id)
    }
    @DeleteMapping("/deleteEspectaculo/{id}")
    fun delete(@PathVariable id: Long): Instalacion {
        return instalacionService.desactivarInstalacion(id)
    }
    @PostMapping("/CrearInstalacion")
    fun create(@RequestBody instalacionBody: instalacionDTO): Instalacion {
        return instalacionService.crearInstalacion(instalacionBody.toInstalacion())
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
}