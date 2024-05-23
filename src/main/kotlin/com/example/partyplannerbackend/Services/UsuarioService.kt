package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.function.LongUnaryOperator

@Service
class UsuarioService {

    @Autowired
    lateinit var repoUsuario : usuarioRepository

    fun getUser() = repoUsuario.findAll()

    fun getUser(id: Long) = repoUsuario.findById(id)

    fun getEventos(id :Long) = repoUsuario.findById(id).get().eventos

    fun crearUsuario(nuevoUsuario: Usuario): Usuario {
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

    fun activarUsuario(id : Long) : Usuario{
        val usuario = getUser(id).get()
        usuario.activar()
        return repoUsuario.save(usuario)
    }

    fun guardar(usuarioModificado:Usuario)= repoUsuario.save(usuarioModificado)

}
