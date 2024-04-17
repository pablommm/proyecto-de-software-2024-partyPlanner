package grupo_4.partyplannerbackend.Controller

import grupo_4.partyplannerbackend.service.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")

class UsuarioController (@Autowired val userService : UsuarioService) {

    @GetMapping("/Usuario")
    fun getUsuario() = userService.getUser()

    @GetMapping("/Usuario/{id}")
    @Operation(summary = "Devuelve un usuario por id")
    fun getUsuario(@PathVariable id: Int) = userService.getUser()

}