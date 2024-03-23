package com.grupo.spring.producto.dtos;

import com.grupo.spring.producto.entidades.TipoUnidad;

public class ProductoDto {
	private Integer id;
	private String descripcion;
	private double precio;
	private TipoUnidad unidad;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public TipoUnidad getUnidad() {
		return unidad;
	}
	public void setUnidad(TipoUnidad unidad) {
		this.unidad = unidad;
	}
	
}
