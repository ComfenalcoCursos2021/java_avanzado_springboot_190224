package com.grupo.spring.usuario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.spring.usuario.entidades.UsuarioEntidad;
@Repository
public interface IUsuarioRepositorio extends JpaRepository<UsuarioEntidad, Integer> {

}
