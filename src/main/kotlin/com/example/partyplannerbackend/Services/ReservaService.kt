package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Reserva
import com.example.partyplannerbackend.Repositorio.RservaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ReservaService {

    @Autowired
    lateinit var reservaRepository: RservaRepository

    fun getEvento() = reservaRepository.findAll()

    fun guardar(reserva: Reserva) =reservaRepository.save(reserva)

    fun create(fi: LocalDateTime,ff: LocalDateTime): Reserva {
        val reserva = Reserva(null, fi,ff)
        return reservaRepository.save(reserva)
    }
}