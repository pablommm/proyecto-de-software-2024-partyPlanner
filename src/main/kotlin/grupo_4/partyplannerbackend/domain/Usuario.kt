package grupo_4.partyplannerbackend.domain

class Usuario (
    val nombre: String,
    val apellido: String,
    val username: String,
    val contraseña : String,
    var eventos : MutableList<Evento> = mutableListOf()
):Entidad(){

    fun hola() = 0
    override fun validar() {
        hola()
    }
}