package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.eventoDTO
import com.example.partyplannerbackend.DTO.servicioDTO
import com.example.partyplannerbackend.DTO.toEvento
import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Reserva
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Repositorio.RservaRepository
import com.example.partyplannerbackend.Services.EventoService
import com.example.partyplannerbackend.Services.InstalacionService
import com.example.partyplannerbackend.Services.ReservaService
import com.example.partyplannerbackend.Services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class eventoController(@Autowired val eventoService: EventoService,@Autowired val instalacionService: InstalacionService,
@Autowired val usuarioService: UsuarioService, @Autowired val reservaService: ReservaService
) {

    @GetMapping("/eventos")
    fun getEventos() = eventoService.getEvento()

    @GetMapping("/eventosById/{id}")
    fun getEventosById(@PathVariable id: Long): Optional<Evento> = eventoService.getEventoById(id)

    /* falta asignarle la reserva a la instalacion */
    @PostMapping("/CrearEventos")
    fun create(@RequestBody eventobody: eventoDTO): Evento {
        val instalacionid = instalacionService.getInstalacionById(eventobody.Lugar).get()
        val usuarioID = eventobody.owner
        val usuario = usuarioService.getUser(usuarioID).get()
        val reserva = reservaService.create(eventobody.fechaEventoIni, eventobody.fechaEventoFin)

        if((instalacionid.id != 1.toLong())){
            instalacionid.validarReserva(Reserva(null, eventobody.fechaEventoIni, eventobody.fechaEventoFin))
            if((usuario.rol.toString() != "ADMINISTRADOR")) {
                usuario.reservarLugar(
                    instalacionid,
                    reserva,
                    eventobody.dias
                )// pasarle la cantidad de dias para multiplicar

                usuarioService.guardarr(usuario)

            }
           // val reserva = reservaService.create(eventobody.fechaEventoIni, eventobody.fechaEventoFin)
            instalacionid.aniadirReserva(reserva)
            instalacionService.guardar(instalacionid)
            usuarioService.guardarr(usuario)
        }


        return eventoService.crearEvento(eventobody.toEvento(instalacionid), usuarioID)
    }

    @PutMapping("/EditarEvento/{id}")
    fun editar(@PathVariable id: Long , @RequestBody eventobody: eventoDTO) :Evento {
        val eventoExistente = eventoService.getEventoById(id).get()

        eventoExistente.nombreDelEvento = eventobody.nombreDelEvento


        val eventoModificado = eventoService.guardar(eventoExistente)


        return eventoModificado


    }
    @GetMapping("/totalEvents")
    fun getNumberEvents(): Int {
        return eventoService.totalEventos()
    }

    @GetMapping("/activeEvents")
    fun getActiveEventsWithNombreActivo(): Int {
        return eventoService.totalEventosActivos()
    }

    @GetMapping("/estadoPresupuesto")
    fun getestadoPresupuesto(): Int {
        return eventoService.totalEventosActivos()
    }

    @GetMapping("/serviciosAdquiridos/{id}")
    fun serviciosAdquiridos(@PathVariable id: Long): List<Servicio> {
        return eventoService.listadoDeServicios(id).filter { it.activo }
    }

    @DeleteMapping("/DeletarEvento/{id}")
    fun deleteServicie(@PathVariable id: Long) = eventoService.delete(id)


}