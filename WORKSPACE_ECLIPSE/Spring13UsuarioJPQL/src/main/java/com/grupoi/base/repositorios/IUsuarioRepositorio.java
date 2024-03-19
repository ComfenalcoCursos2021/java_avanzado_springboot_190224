package com.grupoi.base.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupoi.base.entidades.UsuarioEntidad;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<UsuarioEntidad, Integer>{

	List<UsuarioEntidad> findByApellidoLike(String texto);
	
	
	///BUSCAR POR APELLIDO SIEMPRE Y CUANDO EL TELEFONO SEA 1
	
	//OPCION 1  QUEMANDO EL TELEFONO
	List<UsuarioEntidad> findByApellidoLikeAndTelefono(String apellido,String telefono);
	
	//OPCION 2
	@Query("select u from UsuarioEntidad u where u.apellido like ?1 and u.telefono = '1'" )
	List<UsuarioEntidad> findByApellidoConTelefono1(String apellido);
	
	
	//OPCION 3
	@Query(value="SELECT * FROM USUARIOS WHERE APELLIDO LIKE ?1 AND TELEFONO = '1'" ,nativeQuery = true)
	List<UsuarioEntidad> findByApellidoConTelefono1Query(String apellido);
	
}
