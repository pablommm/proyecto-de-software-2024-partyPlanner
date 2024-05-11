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
    fun getEventosById(@PathVariable id: Long): Optional<Evento> = eventoService.getEventoById(id)

    /* falta asignarle la reserva a la instalacion */
    @PostMapping("/CrearEventos")
    fun create(@RequestBody eventobody: eventoDTO): Evento {
        val instalacionid = instalacionService.getInstalacionById(eventobody.Lugar).get()
        val usuarioID = eventobody.owner
        instalacionid.validarReserva(Reserva(null, eventobody.fechaEventoIni, eventobody.fechaEventoFin))
        return eventoService.crearEvento(eventobody.toEvento(instalacionid), usuarioID)
    }


}