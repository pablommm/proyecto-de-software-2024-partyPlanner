package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
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

    fun getUser() = repoUsuario.allInstances()
    fun getUser(id: Long) = repoUsuario.getById(id)


    fun borrarUsuario(id: Long) {
        repoUsuario.delete(id)
    }

    fun getEventos(id :Long) = repoUsuario.listaDeEventos(id)

    fun crearUsuario(nuevoUsuario: Usuario): Usuario {
        repoUsuario.save(nuevoUsuario)
        return nuevoUsuario
    }
    // aun no es claro si agregaremos la funcion para  editar al usuario, pero almenos ya la tenemos agregada
    //fun updateUser(usuario: Usuario) = repoUsuario.update(usuario)


    fun getUsuarioLogin(user: UsuarioLoginDTO): Usuario {
        if(repoUsuario.getUserPass(user).isNotEmpty()) {
            return repoUsuario.getUserPass(user).first()
        } else {

            throw RuntimeException("Los datos ingresados son incorrectos")
        }
    }


}
