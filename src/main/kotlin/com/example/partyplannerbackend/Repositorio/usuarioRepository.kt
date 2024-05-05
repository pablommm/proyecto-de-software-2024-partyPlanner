package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import com.example.partyplannerbackend.Domain.*
import org.springframework.data.repository.CrudRepository

interface usuarioRepository : CrudRepository<Usuario, Long> {

    fun listaDeEventos(id: Long) = findById(id).get().eventos

    fun getUserPass(userIdentificador: UsuarioLoginDTO) = findAll().filter { user -> user.accesoUsuario(userIdentificador) }

    fun allInstances() = findAll()


    fun getById(id : Long) = findById(id)

    fun delete(id: Long) = deleteById(id)
}

