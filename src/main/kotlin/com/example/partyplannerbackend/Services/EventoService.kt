package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.RepoServicios
import com.example.partyplannerbackend.Repositorio.RepoUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventoService {

    @Autowired
    lateinit var repoServicio: RepoServicios

    fun getservicio() = repoServicio.allInstances()
    //fun getUser(id: Int) = repoUsuario.getById(id)

    fun getServicioById(id: Int) = repoServicio.getById(id)

    fun borrarServicio(id: Int) {
        repoServicio.delete(repoServicio.getById(id))
    }

    fun crearServicio(nuevoServicio: Servicio): Servicio {
        repoServicio.create(nuevoServicio)
        return nuevoServicio
    }
    // aun no es claro si agregaremos la funcion para  editar al usuario, pero almenos ya la tenemos agregada
    //fun updateUser(usuario: Usuario) = repoUsuario.update(usuario)


}