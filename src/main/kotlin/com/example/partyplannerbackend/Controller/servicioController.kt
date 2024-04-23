package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Services.ServicioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class servicioController(@Autowired val serviciosService: ServicioService) {

    @GetMapping("/servicios")
    fun getServicios() = serviciosService.getServicio()

    @GetMapping("/servicios/{id}")
    fun getServicios(id : Int) = serviciosService.getServiciorById(id)

}