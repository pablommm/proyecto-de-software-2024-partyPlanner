package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Repositorio.ServicioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServicioService {

    @Autowired
    lateinit var repoService: ServicioRepository

    fun getServicio() = repoService.findAll()
    fun getServicioActivos() = repoService.findAll().filter { it.activo }
    fun getServiciorById(id: Long) = repoService.findById(id)

    fun crearServicio(nuevoServicio: Servicio): Servicio {
        repoService.save(nuevoServicio)
        return nuevoServicio
    }

   // fun delete(id : Long) = repoService.deleteById(id)
   fun delete(id : Long): Servicio {
       val servicio = getServiciorById(id).get()
       servicio.desactivar()
       return repoService.save(servicio)
   }

    fun guardar(servicio: Servicio) = repoService.save(servicio)




}