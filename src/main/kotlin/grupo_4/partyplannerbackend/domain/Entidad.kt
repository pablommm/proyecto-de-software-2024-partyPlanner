package grupo_4.partyplannerbackend.domain

abstract class Entidad {
    var id: Int = 0

    fun esNuevo() = id == 0
    abstract  fun validar()

}