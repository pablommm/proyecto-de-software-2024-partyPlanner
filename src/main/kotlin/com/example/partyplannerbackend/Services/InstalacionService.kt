package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Usuario
import com.example.partyplannerbackend.Repositorio.RepoInstalacion
import com.example.partyplannerbackend.Repositorio.RepoUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class InstalacionService {

    @Autowired
    lateinit var repoInstalacion: RepoInstalacion

    fun getInstalacionActivs() = repoInstalacion.allInstancesActivos()

    //fun getInstalacion(id: Int) = repoUsuario.getById(id)

    fun getInstalacionById(id: Int) = repoInstalacion.getById(id)

    fun borrarInstalacion(id: Int) {
        repoInstalacion.delete(repoInstalacion.getById(id))
    }

    fun crearUsuario(nuevaInstalacion: Instalacion): Instalacion {
        repoInstalacion.create(nuevaInstalacion)
        return nuevaInstalacion
    }

    // aun no es claro si agregaremos la funcion para  editar a la instalacion, pero almenos ya la tenemos agregada
    //fun updateUser(usuario: Usuario) = repoInstalacion.update(usuario)



}