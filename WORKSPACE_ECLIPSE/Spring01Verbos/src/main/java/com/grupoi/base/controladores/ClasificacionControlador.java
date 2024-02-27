package com.grupoi.base.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		/*var lista = new ArrayList<ClasificacionDto>();
		
		var cla1 = ClasificacionDto.builder().id(1).nombre("Electrodomesticos").build();
		var cla2 = ClasificacionDto.builder().id(2).nombre("Jugueteria").build();
		var cla3 = ClasificacionDto.builder().id(3).nombre("Licores").build();
		
		lista.add(cla1);
		lista.add(cla2);
		lista.add(cla3);
		
		var listaNueva = Arrays.asList(cla1,cla2,cla3);
		//return lista;
		return listaNueva;*/
		return ClasificacionControlador.LISTA;
	}
	
}
