package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.*
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface EventoRepository : CrudRepository<Evento, Long> {

    fun allInstances() = findAll()

    fun allInstancesActivos() = findAll().filter { it.activo }

    fun getById(id : Long) = findById(id)

    fun delete(id: Long) = deleteById(id)


}

