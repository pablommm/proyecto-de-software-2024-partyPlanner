package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.Domain.Instalacion
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
}