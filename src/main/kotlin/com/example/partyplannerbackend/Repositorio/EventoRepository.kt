package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.*
import org.springframework.data.repository.CrudRepository

interface EventoRepository : CrudRepository<Evento, Long> {


}

