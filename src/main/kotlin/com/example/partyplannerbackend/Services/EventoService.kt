package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.EventoRepository
import com.example.partyplannerbackend.Repositorio.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventoService {

    @Autowired
    lateinit var repoEvento: EventoRepository
    @Autowired
    lateinit var repoUsuario : usuarioRepository
    fun getEvento() = repoEvento.findAll()

    fun guardar(evento: Evento) =repoEvento.save(evento)

    fun getEventosActivos() = repoEvento.findAll().filter { it.activo }

    fun getEventoById(id: Long) = repoEvento.findById(id)

    fun crearEvento(nuevoEvento: Evento, id : Long): Evento {
        val evento = repoEvento.save(nuevoEvento)
        val usuario = repoUsuario.findById(id).get()
        usuario.aniadirEvento(evento)
        repoUsuario.save(usuario)

        return evento
    }

    fun totalEventos() = repoEvento.findAll().count()

    fun totalEventosActivos(): Int {
       return repoEvento.countActiveEvents()

    }

    fun listadoDeServicios(id:Long): List<Servicio> {
        val evento = getEventoById(id).get()
        evento.actualizarEstadoDePresupuesto()
        return evento.serviciosAdquiridos.filter { it.activo }

    }

    //fun delete(id : Long) = repoEvento.deleteById(id)

    fun delete(id : Long): Evento {
        val evento = getEventoById(id).get()
        evento.desactivar()
        return repoEvento.save(evento)
    }

    // aun no es claro si agregaremos la funcion para  editar al usuario,
// pero almenos ya la tenemos agregada
    //




}