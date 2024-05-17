package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.eventoDTO
import com.example.partyplannerbackend.DTO.servicioDTO
import com.example.partyplannerbackend.DTO.toEvento
import com.example.partyplannerbackend.DTO.toServicio
import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Services.EventoService
import com.example.partyplannerbackend.Services.ServicioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class servicioController(@Autowired val serviciosService: ServicioService,
@Autowired val eventoServicio: EventoService
) {

    @GetMapping("/servicios")
    fun getServicios() = serviciosService.getServicio()

    @GetMapping("/servicios/{id}")
    fun getServicios(@PathVariable id : Long) = serviciosService.getServiciorById(id)

    @PostMapping("/CrearServicio")
    fun create(@RequestBody servicioBody : servicioDTO): Servicio {
        val evento = eventoServicio.getEventoById(servicioBody.eventoID).get()
        val servicio = serviciosService.crearServicio(servicioBody.toServicio())
        evento.aniadirServicio(servicio)
        eventoServicio.guardar(evento)
        return servicio
    }

    @PutMapping("/EditarServicio/{id}")
    fun editar(@PathVariable id: Long , @RequestBody servicioBody: servicioDTO) : Servicio{
        val servicioExistente = serviciosService.getServiciorById(id).get()

        servicioExistente.nombreDeServicio = servicioBody.nombreDeServicio
        servicioExistente.monto = servicioBody.monto
        servicioExistente.descripcion = servicioBody.descripcion
        servicioExistente.categoria = servicioBody.categoria


        val servicioModificado = serviciosService.guardar(servicioExistente)

        return servicioModificado
    }
    @DeleteMapping("/DeletarServicio/{id}")
    fun deleteServicie(@PathVariable id: Long) = serviciosService.delete(id)
}