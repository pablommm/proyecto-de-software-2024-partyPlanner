package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.*
import org.springframework.data.repository.CrudRepository

interface InstalacionRepository : CrudRepository<Instalacion, Long> {

    fun allInstances() = findAll()

    fun allInstancesActivos() = findAll().filter { it.activo }

    fun getById(id : Long) = findById(id)

    fun delete(id: Long) = deleteById(id)
}
