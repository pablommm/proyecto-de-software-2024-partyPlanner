package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.EventoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventoService {

    @Autowired
    lateinit var repoEvento: EventoRepository

    fun getEvento() = repoEvento.findAll()

    fun getEventosActivos() = repoEvento.findAll().filter { it.activo }

    fun getEventoById(id: Long) = repoEvento.findById(id)

    fun crearEvento(nuevoEvento: Evento): Evento {
        repoEvento.save(nuevoEvento)
        return nuevoEvento
    }
    // aun no es claro si agregaremos la funcion para  editar al usuario,
// pero almenos ya la tenemos agregada
    //



}