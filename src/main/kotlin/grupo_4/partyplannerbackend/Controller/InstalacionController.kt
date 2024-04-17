package grupo_4.partyplannerbackend.Controller

import grupo_4.partyplannerbackend.service.InstalacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class InstalacionController ( @Autowired val instalacionService : InstalacionService) {

    @GetMapping("/Instalacion")
    fun getInsta() = instalacionService.getInstalacion()

}