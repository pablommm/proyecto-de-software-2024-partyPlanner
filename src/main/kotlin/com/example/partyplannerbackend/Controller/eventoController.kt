package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Services.EventoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class eventoController(@Autowired val eventoService: EventoService) {

    @GetMapping("/eventos")
    fun getEventos() = eventoService.getEvento()

    @GetMapping("/eventos/{id}")
    fun getEventosById(id: Int) = eventoService.getEventoById(id)

}