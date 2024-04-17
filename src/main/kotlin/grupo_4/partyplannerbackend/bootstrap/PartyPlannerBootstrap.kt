package grupo4.partyplannerbackend.bootstrap

import grupo_4.partyplannerbackend.Repositorio.RepoInstalacion
import grupo_4.partyplannerbackend.Repositorio.RepoUser
import grupo_4.partyplannerbackend.domain.Instalacion
import grupo_4.partyplannerbackend.domain.Usuario
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PartyPlannerBootstrap : InitializingBean {

    override fun afterPropertiesSet() {
        crearUser()
        createInstalacion()
    }


    @Autowired(required = true)
    lateinit var repoUser: RepoUser

    val usuarioPrueba = Usuario(
        nombreYApellido = "juanperez1",
        username = "sarasa",
        contrasenia = "1234"
    )

    val usuario1 = Usuario(
        nombreYApellido = "Verito 666",
        username = "veritorezando",
        contrasenia = "1234"
    )

    fun crearUser(){
        repoUser.create(usuario1)
        repoUser.create(usuarioPrueba)


    }

    @Autowired(required = true)
    lateinit var repoInstalacion: RepoInstalacion

    val instalacion1 = Instalacion(
        nombreDeInstalacion = "Salon de fiestas",
        descripcionDeInstalacion = "asd",
        costoDeInstalacion = 100,
        CapacidadInstalacion = 100,
        LocalidadDeInstalacion = "aca a la vuelta")

    fun createInstalacion(){
        repoInstalacion.create(instalacion1)
    }
}