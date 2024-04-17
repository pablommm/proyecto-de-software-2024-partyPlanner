package grupo_4.partyplannerbackend.domain

import java.time.LocalDateTime

class Evento
    (val nombreDelEvento: String,
     val lugar: Instalacion,
     val fechaEvento: LocalDateTime,
     val cantidadDeInvitados :Int,
     var serviciosAdquiridos : MutableList<Servicio> = mutableListOf()) {




    }