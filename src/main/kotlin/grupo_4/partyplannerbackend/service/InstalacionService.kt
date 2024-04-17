package grupo_4.partyplannerbackend.service

import grupo_4.partyplannerbackend.Repositorio.RepoInstalacion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class InstalacionService {

    @Autowired
    lateinit var repoInstalacion: RepoInstalacion

    fun getInstalacion() = repoInstalacion.allInstances()


}