package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import com.example.partyplannerbackend.Services.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UsuarioController (@Autowired val userService : UsuarioService) {

    @GetMapping("/Usuario")
    fun getUsuario() = userService.getUser()


    @PostMapping("/usuarioLogin")
    @Operation(summary = "Devuelve un usuario que coincida user y pass")
    fun postUsuarioLoggin(@RequestBody user: UsuarioLoginDTO) = userService.getUsuarioLogin(user)

}
