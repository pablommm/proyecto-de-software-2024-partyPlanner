package com.example.partyplannerbackend.Controller

import com.example.partyplannerbackend.DTO.*
import com.example.partyplannerbackend.Domain.Evento
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Services.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin("*")
class UsuarioController (@Autowired val userService : UsuarioService) {

    @GetMapping("/Usuarios")
    fun getUsuario() = userService.getUser()

        @GetMapping("/UsuarioBqs/{id}")
        fun getUsuarioByID(@PathVariable id: Long) = userService.getUser(id)


        @PostMapping("/CrearUsuario")
        fun create(@RequestBody usuario : UsuarioCreateDTO):Usuario {
            userService.validateUniqueUsername(usuario)
            return userService.crearUsuario(usuario.toUsuario())
        }

    @GetMapping("/misPropiedades/{id}")
    fun getMisPropiedades(@PathVariable id: Long): MutableList<Instalacion> {
        return userService.misPropiedades(id)
    }
    @GetMapping("/MisEventos/{id}")
    fun getMisEvento(@PathVariable id: Long): MutableList<Evento> {
        return userService.getEventos(id)
    }
    @PostMapping("/usuarioLogin")
    @Operation(summary = "Devuelve un usuario que coincida user y pass")
    fun postUsuarioLoggin(@RequestBody user: UsuarioLoginDTO) = userService.getUsuarioLogin(user)

    @GetMapping("/TotalDeUSuariosRegistrados")
    fun getUserTotales(): Int {
        return userService.totalDeUsuarioRegistrados()
    }

    @DeleteMapping("/deleUsuario/{id}")
    fun delete(@PathVariable id: Long): Usuario {
        return userService.desactivarUsuario(id)
    }
    @PutMapping("/activarUser/{id}")
    fun active(@PathVariable  id : Long) :Usuario{
        return userService.activarUsuario(id)
    }

    @PutMapping("/UsuarioUpdate/{id}")
    fun editar(@PathVariable id: Long , @RequestBody usuarioBody: UsuarioModificado) : Usuario {
        val usuarioExistente = userService.getUser(id).get()

        usuarioExistente.nombreYApellido = usuarioBody.nombreYApellido
        usuarioExistente.username =usuarioBody.username
        usuarioExistente.contrasenia = usuarioBody.contrasenia
        usuarioExistente.saldo =usuarioBody.saldo

        val instalacionModificado = userService.guardar(usuarioExistente)

        return instalacionModificado
    }
    @PutMapping("/cargarSaldo/{id}/{saldo}")
    fun cargarSaldo(@PathVariable  id : Long,@PathVariable  saldo : Double) :Usuario{
        //val saldoDuble =saldo.toDouble()
        return userService.cargarSaldo(id,saldo)
    }

}




