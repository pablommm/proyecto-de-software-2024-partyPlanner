package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.*
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface EventoRepository : CrudRepository<Evento, Long> {

    @Query("SELECT COUNT(e) FROM Evento e WHERE e.activo = true")
    fun countActiveEvents(): Int

}

