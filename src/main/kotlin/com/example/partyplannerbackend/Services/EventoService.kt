package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.RepoEventos
import com.example.partyplannerbackend.Repositorio.RepoServicios
import com.example.partyplannerbackend.Repositorio.RepoUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventoService {

    @Autowired
    lateinit var repoEvento: RepoEventos

    fun getEvento() = repoEvento.allInstances()

    fun getEventosActivos() = repoEvento.allInstancesActivos()

    fun getEventoById(id: Int) = repoEvento.getById(id)

    fun borrarEvento(id: Int) {
        repoEvento.delete(repoEvento.getById(id))
    }

    fun crearEvento(nuevoEvento: Evento): Evento {
        repoEvento.create(nuevoEvento)
        return nuevoEvento
    }
    // aun no es claro si agregaremos la funcion para  editar al usuario, pero almenos ya la tenemos agregada
    //fun updateUser(usuario: Usuario) = repoUsuario.update(usuario)


}