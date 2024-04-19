package grupo_4.partyplannerbackend.domain

class Usuario (
    val nombreYApellido :String,
    val username: String,
    val contrasenia : String,
    var eventos : MutableList<Evento> = mutableListOf()
):Entidad(){

    fun esValidoNombre() = nombreYApellido.isEmpty()
    fun validarNombre() {
        if(esValidoNombre()) throw RuntimeException("El nombre esta vacio")
    }
    override fun validar() {
        validarNombre()
    }
}