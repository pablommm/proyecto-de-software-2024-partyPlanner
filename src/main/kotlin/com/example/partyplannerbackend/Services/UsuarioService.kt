package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.DTO.UsuarioCreateDTO
import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.lang.RuntimeException
import java.util.function.LongUnaryOperator

@Service
class UsuarioService {

    @Autowired
    lateinit var repoUsuario : usuarioRepository

    fun getUser() = repoUsuario.findAll()

    fun getUser(id: Long) = repoUsuario.findById(id)

    fun getEventos(id :Long) = repoUsuario.findById(id).get().eventos

    fun isUsernameUnique(username: UsuarioCreateDTO): Boolean {
        return repoUsuario.findAll().any{ it.validacionUsernameUnique(username) }
    }
    fun validateUniqueUsername(username: UsuarioCreateDTO){
        if(isUsernameUnique(username)) throw RuntimeException("El username ya esta usado")
    }

    fun misPropiedades(id :Long) = repoUsuario.findById(id).get().instalaciones
    fun misPropiedadesByIDinstalacion(idOwner: Long, idInstalacion :Long): List<Instalacion> {
        return  misPropiedades(idOwner).filter {it.id == idInstalacion}

    }
     fun searchMisPropiedades( id: Long, nombre: String): List<Instalacion> {
       return misPropiedades(id).filter { it.nombreDeInstalacion.lowercase() == nombre.lowercase() || it.LocalidadDeInstalacion.lowercase() == nombre.lowercase()}
    }

    fun crearUsuario(nuevoUsuario: Usuario): Usuario {
        //validarUsername(nuevoUsuario.username)
        repoUsuario.save(nuevoUsuario)
        return nuevoUsuario
    }
    // aun no es claro si agregaremos la funcion para  editar al usuario, pero almenos ya la tenemos agregada
    //fun updateUser(usuario: Usuario) = repoUsuario.update(usuario)

    fun getUsuarioLogin(user: UsuarioLoginDTO): Usuario {
        val usuario = repoUsuario.findAll().filter { it.accesoUsuario(user) }
        if(usuario.isNotEmpty()) {
            return usuario.first()
        } else {

            throw RuntimeException("Los datos ingresados son incorrectos")
        }
    }

     fun totalDeUsuarioRegistrados() = repoUsuario.findAll().count()

    // fun getTotalEventosPorUser() = repoUsuario.totalEventosPorUsuario()

    fun desactivarUsuario(id : Long): Usuario {
        val usuario = getUser(id).get()
        usuario.desactivar()
        return repoUsuario.save(usuario)
    }
    fun guardarr(usuario: Usuario) = repoUsuario.save(usuario)


    fun activarUsuario(id : Long) : Usuario{
        val usuario = getUser(id).get()
        usuario.activar()
        return repoUsuario.save(usuario)
    }
     fun cargarSaldo(id : Long, saldo : Double) : Usuario{
        val usuario = getUser(id).get()
        usuario.acreditarCarga(saldo)
        return repoUsuario.save(usuario)
    }
    fun guardar(usuarioModificado:Usuario)= repoUsuario.save(usuarioModificado)

}
