package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Reserva
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface RservaRepository : CrudRepository<Reserva, Long> {


}
