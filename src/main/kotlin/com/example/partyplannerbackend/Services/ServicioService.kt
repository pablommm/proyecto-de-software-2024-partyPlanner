package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.RepoServicios
import com.example.partyplannerbackend.Repositorio.RepoUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServicioService {

    @Autowired
    lateinit var repoService: RepoServicios

    fun getServicio() = repoService.allInstances()
    //fun getUser(id: Int) = repoUsuario.getById(id)

    fun getServiciorById(id: Int) = repoService.getById(id)

    fun borrarServicio(id: Int) {
        repoService.delete(repoService.getById(id))
    }

    fun crearServicio(nuevoServicio: Servicio): Servicio {
        repoService.create(nuevoServicio)
        return nuevoServicio
    }




}