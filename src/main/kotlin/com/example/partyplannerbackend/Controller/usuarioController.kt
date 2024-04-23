package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import com.example.partyplannerbackend.Services.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
class UsuarioController (@Autowired val userService : UsuarioService) {

    @GetMapping("/Usuario")
    fun getUsuario() = userService.getUser()

    @GetMapping("/Usuario/{id}")
    fun getUsuarioByID(id: Int) = userService.getUserById(id)

    @PostMapping("/usuarioLogin")
    @Operation(summary = "Devuelve un usuario que coincida user y pass")
    fun postUsuarioLoggin(@RequestBody user: UsuarioLoginDTO) = userService.getUsuarioLogin(user)

}
