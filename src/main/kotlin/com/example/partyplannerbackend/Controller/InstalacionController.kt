package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.Services.InstalacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class InstalacionController(@Autowired val instalacionService: InstalacionService) {

    @GetMapping("/Instalaciones")
    fun getInstalacionesTodas() = instalacionService.getInstalacionesTodas()

    @GetMapping("/InstalacionesActivas")
    fun getInstalacionesActivas() = instalacionService.getInstalacionActivos()

    @GetMapping("/Instalaciones/{id} ")
    fun getInstalacionesActivas(id :Int) = instalacionService.getInstalacionById(id)

}