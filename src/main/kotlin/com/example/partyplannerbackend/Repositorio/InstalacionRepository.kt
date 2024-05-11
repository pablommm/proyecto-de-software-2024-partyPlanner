package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


interface InstalacionRepository : CrudRepository<Instalacion, Long> {
/*
    fun allInstances() = findAll()

    fun allInstancesActivos() = findAll().filter { it.activo }

    fun getById(id : Long) = findById(id)
    */
}
