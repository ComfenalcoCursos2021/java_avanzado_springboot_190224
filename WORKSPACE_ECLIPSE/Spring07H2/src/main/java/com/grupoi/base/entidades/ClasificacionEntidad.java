package com.grupoi.base.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity 
@Table(name="CLASIFICACIONES")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ClasificacionEntidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	
	private Date ultimaActualizacion;
	private int idUsuarioModificador;
	private String UsuarioModificador;
}
