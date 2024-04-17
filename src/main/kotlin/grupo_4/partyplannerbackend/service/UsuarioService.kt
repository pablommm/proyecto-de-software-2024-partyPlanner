package grupo_4.partyplannerbackend.service;

import grupo_4.partyplannerbackend.Repositorio.RepoUser;
import grupo_4.partyplannerbackend.domain.Usuario

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UsuarioService {


    @Autowired
    lateinit var repoUsuario: RepoUser

        fun getUser() = repoUsuario.allInstances()
        //fun getUser(id: Int) = repoUsuario.getById(id)

        fun deleteUser(id: Int) {
            repoUsuario.delete(repoUsuario.getById(id))
        }

        fun updateUser(usuario: Usuario) = repoUsuario.update(usuario)

        fun create(nuevoUsuario: Usuario): Usuario {
            repoUsuario.create(nuevoUsuario)
            return nuevoUsuario
        }
    /*
        fun getUsuarioLogin(user:UsuarioLoginDTO): Usuario {
            if(repoUsuario.getUserPass(user).isNotEmpty()) {
                return repoUsuario.getUserPass(user).first()
            } else {
                throw genericException("Los datos ingresados son incorrectos")
            }
        }
    */

}
