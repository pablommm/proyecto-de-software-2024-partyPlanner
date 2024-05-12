package com.example.partyplannerbackend.Repositorio

import com.example.partyplannerbackend.DTO.UsuarioLoginDTO
import com.example.partyplannerbackend.Domain.*
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface usuarioRepository : CrudRepository<Usuario, Long> {

   /* fun listaDeEventos(id: Long) = findById(id).get().eventos

 //    fun getUserPass(userIdentificador: UsuarioLoginDTO) = findAll().filter { user -> user.accesoUsuario(userIdentificador) }

    fun allInstances() = findAll()


    fun getById(id : Long) = findById(id)



   @Query("SELECT  u.nombreYApellido ,COUNT(*) AS eventos_por_usuario\n" +
           "FROM Usuarios_Eventos ue\n" +
           "INNER JOIN Usuario u ON ue.usuario.id = u.id\n" +
           "GROUP BY u.id \n")
   fun totalEventosPorUsuario() : Map<String, Int>


    */


}

