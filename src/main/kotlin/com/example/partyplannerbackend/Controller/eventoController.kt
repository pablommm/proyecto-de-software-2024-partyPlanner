package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.eventoDTO
import com.example.partyplannerbackend.DTO.toEvento
import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Reserva
import com.example.partyplannerbackend.Services.EventoService
import com.example.partyplannerbackend.Services.InstalacionService
import com.example.partyplannerbackend.Services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class eventoController(@Autowired val eventoService: EventoService,@Autowired val instalacionService: InstalacionService,
@Autowired val usuarioService: UsuarioService ) {

    @GetMapping("/eventos")
    fun getEventos() = eventoService.getEvento()

    @GetMapping("/eventosById/")
    fun getEventosById(@PathVariable id: Optional<Int>): Evento? = eventoService.getEventoById(id.orElse(0))

     /* falta asignarle el evento al usuario */
    @PostMapping("/CrearEventos")
    fun create(@RequestBody eventobody : eventoDTO): Evento {
        val instalacionid = instalacionService.getInstalacionById(eventobody.Lugar)
        val usuario = usuarioService.getUser(eventobody.owner)
        instalacionid.validarReserva(Reserva(eventobody.fechaEventoIni,eventobody.fechaEventoFin))
         val evento = eventoService.crearEvento(eventobody.toEvento(instalacionid))
         usuario.aniadirEvento(evento)
         return evento

    }


}