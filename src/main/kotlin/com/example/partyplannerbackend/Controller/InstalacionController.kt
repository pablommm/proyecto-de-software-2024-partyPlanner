package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Services.InstalacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
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
}