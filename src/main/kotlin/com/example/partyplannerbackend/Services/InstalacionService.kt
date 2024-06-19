package com.example.partyplannerbackend.Services

import com.example.partyplannerbackend.DTO.UsuarioCreateDTO
import com.example.partyplannerbackend.DTO.instalacionDTO
import com.example.partyplannerbackend.Domain.Instalacion
import com.example.partyplannerbackend.Domain.Reserva
import com.example.partyplannerbackend.Domain.Servicio
import com.example.partyplannerbackend.Repositorio.InstalacionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException


@Service
class InstalacionService {

    @Autowired
    lateinit var repoInstalacion: InstalacionRepository

    fun getInstalacionesTodas() = repoInstalacion.findAll()
    fun getInstalacionActivos() = repoInstalacion.findAll().filter { it.activo }

    fun getInstalacionById(id: Long) = repoInstalacion.findById(id)

    fun getListaFechasInstalacionById(id: Long): MutableList<Reserva> {
        val instalacion = repoInstalacion.findById(id).get()
        return instalacion.fechasReservadas
    }
    fun desactivarInstalacion(id : Long): Instalacion {
        val instalacion = getInstalacionById(id).get()
        instalacion.desactivacion()
        return repoInstalacion.save(instalacion)
    }

    fun activarInstalacion(id : Long): Instalacion {
        val instalacion = getInstalacionById(id).get()
        instalacion.activar()
        return repoInstalacion.save(instalacion)
    }
    fun isNombreUnique(instalacion: instalacionDTO): Boolean {
        return repoInstalacion.findAll().any{ it.validacionUsernameUnique(instalacion) }
    }
    fun validateUniqueNombre(instalacion: instalacionDTO){
        if(isNombreUnique(instalacion)) throw RuntimeException("El nombre de la instalacion ya esta usado")
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