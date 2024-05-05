
package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ServicioRepository : CrudRepository<Servicio, Long> {
    /*
    fun allInstances() = findAll()


    fun getById(id : Long) = findById(id)

    */
}

