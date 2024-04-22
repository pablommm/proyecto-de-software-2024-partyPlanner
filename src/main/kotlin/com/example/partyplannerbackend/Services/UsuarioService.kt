package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.RepoUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UsuarioService {

    @Autowired
    lateinit var repoUsuario: RepoUser

    fun getUser() = repoUsuario.allInstances()
    //fun getUser(id: Int) = repoUsuario.getById(id)

    fun getUserById(id: Int) = repoUsuario.getById(id)

    fun borrarUsuario(id: Int) {
        repoUsuario.delete(repoUsuario.getById(id))
    }

    fun crearUsuario(nuevoUsuario: Usuario): Usuario {
        repoUsuario.create(nuevoUsuario)
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
