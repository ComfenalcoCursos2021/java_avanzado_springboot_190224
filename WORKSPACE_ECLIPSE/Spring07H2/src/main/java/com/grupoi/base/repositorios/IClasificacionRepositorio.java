package com.grupoi.base.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupoi.base.entidades.ClasificacionEntidad;

@Repository
public interface IClasificacionRepositorio extends JpaRepository<ClasificacionEntidad, Integer>{

}
