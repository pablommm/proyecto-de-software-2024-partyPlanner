package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.*
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


interface InstalacionRepository : CrudRepository<Instalacion, Long> {

    @Query("SELECT i FROM Instalacion i WHERE LOWER(i.nombreDeInstalacion) LIKE :nombreUbicacion")
    fun buscarPorNombreOubicacion(nombreUbicacion: String): List<Instalacion>

}
