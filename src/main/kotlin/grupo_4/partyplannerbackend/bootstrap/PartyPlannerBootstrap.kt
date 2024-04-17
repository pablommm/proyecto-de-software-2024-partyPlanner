package grupo4.partyplannerbackend.bootstrap

import grupo_4.partyplannerbackend.Repositorio.RepoUser
import grupo_4.partyplannerbackend.domain.Usuario
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PartyPlannerBootstrap : InitializingBean {
    override fun afterPropertiesSet() {
        crearUser()
    }

    @Autowired
    lateinit var repoUser: RepoUser

    val usuarioPrueba = Usuario(
        nombreYApellido = "juanperez1",
        username = "sarasa",
        contraseña = "1234"
    )
    fun crearUser(){
        repoUser.create(usuarioPrueba)
    }
}