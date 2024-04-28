package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.eventoDTO
import com.example.partyplannerbackend.DTO.toEvento
import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Services.EventoService
import com.example.partyplannerbackend.Services.InstalacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class eventoController(@Autowired val eventoService: EventoService,@Autowired val instalacionService: InstalacionService) {

    @GetMapping("/eventos")
    fun getEventos() = eventoService.getEvento()

    @GetMapping("/eventosById/")
    fun getEventosById(id: Optional<Int>): Evento? = eventoService.getEventoById(id.orElse(0))

    @PostMapping("/CrearEventos")
    fun create(@RequestBody eventobody : eventoDTO): Evento {
        val instalacionid = instalacionService.getInstalacionById(eventobody.Lugar)
        instalacionid.validarReserva(eventobody.fechaEvento)
        return eventoService.crearEvento(eventobody.toEvento(instalacionid))
    }

}