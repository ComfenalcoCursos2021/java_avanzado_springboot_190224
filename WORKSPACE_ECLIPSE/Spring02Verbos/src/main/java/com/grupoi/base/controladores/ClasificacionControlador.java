package com.grupoi.base.controladores;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupoi.base.dto.ClasificacionDto;

@RestController
@RequestMapping("api")
public class ClasificacionControlador {

	
	public static List<ClasificacionDto> LISTA =
			Arrays.asList(ClasificacionDto.builder().id(1).nombre("Electrodomesticos").build(),
					ClasificacionDto.builder().id(2).nombre("Jugueteria").build(),
					ClasificacionDto.builder().id(3).nombre("Licores").build());
	
	@GetMapping("clasificacion")
	public List<ClasificacionDto> getClasificacion(){		
		return ClasificacionControlador.LISTA;
	}
	@GetMapping("clasificacion/{identificador}")
	public ClasificacionDto getClasificacionDtoPorRuta(
			@PathVariable() String identificador) throws Exception {
		 
		try {
			
			final int idInt  = Integer.parseInt(identificador);
			
			var c1 = ClasificacionControlador.LISTA.stream()
					.filter( c -> c.getId() == idInt)
					.findFirst()
					.orElse(null);
			
			return c1;
			
		} catch (Exception e) {
			throw new Exception("Ingrese un numero por favor");
		}
		
		
	}
	
	@GetMapping("clasificacion/buscador/{loQueBusca}")
	public List<ClasificacionDto> getClasificacionDtoPorRutaBuscador(
			@PathVariable() String loQueBusca)  {
		
		var loFiltrado = ClasificacionControlador.LISTA.stream()
				.filter(c -> 
				c.getNombre().toUpperCase().contains(loQueBusca.toUpperCase())
				)
				.collect(Collectors.toList());
		
		return loFiltrado;
	}
	
	@GetMapping("clasificacion/conid")
	public ClasificacionDto getClasificacionDto(
			@RequestParam(
					name="id",
					required=true
					) String id
			
			) throws Exception{		
		
		try {
			final int idInt  = Integer.parseInt(id);
			
			var c1 = ClasificacionControlador.LISTA.stream()
					.filter( c -> c.getId() == idInt)
					.findFirst()
					.orElse(null);
			
			return c1;
		} catch (Exception e) {
			throw new Exception("Ingrese un numero por favor");
		}
		
	}
	
}
