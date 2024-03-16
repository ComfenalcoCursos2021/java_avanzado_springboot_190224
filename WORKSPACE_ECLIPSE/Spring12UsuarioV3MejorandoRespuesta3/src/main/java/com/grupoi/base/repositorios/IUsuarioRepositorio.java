package com.grupoi.base.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupoi.base.entidades.UsuarioEntidad;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<UsuarioEntidad, Integer>{

}
