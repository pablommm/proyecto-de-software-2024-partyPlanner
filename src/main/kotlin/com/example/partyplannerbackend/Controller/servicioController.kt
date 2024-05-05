package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.eventoDTO
import com.example.partyplannerbackend.DTO.servicioDTO
import com.example.partyplannerbackend.DTO.toEvento
import com.example.partyplannerbackend.DTO.toServicio
import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Services.ServicioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class servicioController(@Autowired val serviciosService: ServicioService) {

    @GetMapping("/servicios")
    fun getServicios() = serviciosService.getServicio()

    @GetMapping("/servicios/{{id}}")
    fun getServicios(@PathVariable id : Long) = serviciosService.getServiciorById(id)

    @PostMapping("/CrearServicio")
    fun create(@RequestBody servicioBody : servicioDTO): Servicio {
        return serviciosService.crearServicio(servicioBody.toServicio())
    }

}