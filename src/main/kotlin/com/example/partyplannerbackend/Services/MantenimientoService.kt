package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Mantenimiento
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Repositorio.MantenimientoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MantenimientoService {
    @Autowired lateinit var repositoryMantenimiento: MantenimientoRepository

    fun crearMantenimiento(nuevoMantenimiento: Mantenimiento): Mantenimiento {
        repositoryMantenimiento.save(nuevoMantenimiento)
        return nuevoMantenimiento
    }
}