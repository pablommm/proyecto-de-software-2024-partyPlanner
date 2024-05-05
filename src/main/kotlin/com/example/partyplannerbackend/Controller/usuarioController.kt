package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.*
import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Services.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class UsuarioController (@Autowired val userService : UsuarioService) {

    @GetMapping("/Usuario")
    fun getUsuario() = userService.getUser()
    /*
        @GetMapping("/UsuarioBqs/{id}")
        fun getUsuarioByID(@PathVariable id: Long) = userService.getUser(id)


        @PostMapping("/CrearUsuario")
        fun create(@RequestBody usuario : UsuarioCreateDTO):Usuario {
            return userService.crearUsuario(usuario.toUsuario())
        }


         */


    }




