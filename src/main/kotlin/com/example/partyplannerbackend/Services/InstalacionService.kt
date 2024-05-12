package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Repositorio.InstalacionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class InstalacionService {

    @Autowired
    lateinit var repoInstalacion: InstalacionRepository

    fun getInstalacionesTodas() = repoInstalacion.findAll()
    fun getInstalacionActivos() = repoInstalacion.findAll().filter { it.activo }

    fun getInstalacionById(id: Long) = repoInstalacion.findById(id)

    fun desactivarInstalacion(id : Long): Instalacion {
        val instalacion = getInstalacionById(id).get()
        instalacion.desactivacion()
        return repoInstalacion.save(instalacion)
    }
    fun guardar(instalacion: Instalacion) = repoInstalacion.save(instalacion)

    fun crearInstalacion(nuevaInstalacion: Instalacion): Instalacion {
        repoInstalacion.save(nuevaInstalacion)
        return nuevaInstalacion
    }

    fun buscarPorNombreOubicacion(nombreUbicacion : String) = repoInstalacion.buscarPorNombreOubicacion(nombreUbicacion)
    // aun no es claro si agregaremos la funcion para  editar a la instalacion, pero almenos ya la tenemos agregada
    //fun updateUser(usuario: Usuario) = repoInstalacion.update(usuario)



}