package com.grupo.spring.producto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.spring.producto.entidades.ProductoEntidad;
@Repository
public interface IProductoRepositorio extends JpaRepository<ProductoEntidad, Integer> {

}
