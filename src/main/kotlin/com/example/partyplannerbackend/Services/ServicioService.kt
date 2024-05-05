package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Repositorio.ServicioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServicioService {

    @Autowired
    lateinit var repoService: ServicioRepository

    fun getServicio() = repoService.allInstances()
    //fun getUser(id: Int) = repoUsuario.getById(id)

    fun getServiciorById(id: Long) = repoService.getById(id)

    fun borrarServicio(id: Long) {
        repoService.delete(id)
    }

    fun crearServicio(nuevoServicio: Servicio): Servicio {
        repoService.save(nuevoServicio)
        return nuevoServicio
    }




}