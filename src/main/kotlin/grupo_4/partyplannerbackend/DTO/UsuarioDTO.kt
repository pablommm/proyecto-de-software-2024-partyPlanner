package grupo_4.partyplannerbackend.DTO

import grupo_4.partyplannerbackend.Repositorio.RepoUser
import grupo_4.partyplannerbackend.domain.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioDTO {

    @Autowired
    lateinit var repoUser: RepoUser

    fun getUsuarios() = repoUser.allInstances()

    fun getUsuario(id: Int) = repoUser.getById(id )



}