package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Services.EventoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@CrossOrigin("*")
class eventoController(@Autowired val eventoService: EventoService) {

    @GetMapping("/eventos")
    fun getEventos() = eventoService.getEvento()

    @GetMapping("/eventosById/")
    fun getEventosById(id: Optional<Int>): Evento? = eventoService.getEventoById(id.orElse(0))

}