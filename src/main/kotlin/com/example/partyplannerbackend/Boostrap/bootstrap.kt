package com.example.partyplannerbackend.Boostrap


import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.RepoUser
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class userMagic : InitializingBean {
    override fun afterPropertiesSet() {
        crearUser()
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
}