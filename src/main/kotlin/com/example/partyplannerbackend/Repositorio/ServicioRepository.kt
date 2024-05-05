
package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.*
import org.springframework.data.repository.CrudRepository

interface ServicioRepository : CrudRepository<Servicio, Long> {
    fun allInstances() = findAll()


    fun getById(id : Long) = findById(id)

    fun delete(id: Long) = deleteById(id)

}

