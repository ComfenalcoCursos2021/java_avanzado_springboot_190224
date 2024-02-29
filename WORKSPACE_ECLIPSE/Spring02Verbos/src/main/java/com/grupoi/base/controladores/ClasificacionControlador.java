package com.grupoi.base.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupoi.base.dto.ClasificacionDto;

@RestController
@RequestMapping("api")
public class ClasificacionControlador {

	public List<ClasificacionDto> LISTA;

	public ClasificacionControlador() {
		LISTA = new ArrayList<ClasificacionDto>();
		LISTA.add(ClasificacionDto.builder().id(1).nombre("Electrodomesticos").build());
		LISTA.add(ClasificacionDto.builder().id(2).nombre("Jugueteria").build());
		LISTA.add(ClasificacionDto.builder().id(3).nombre("Licores").build());
	}

	@GetMapping("clasificacion")
	public List<ClasificacionDto> getClasificacion(@RequestBody ClasificacionDto alguno) {
		System.err.println("Ahora con cuerpo ->>>>" + alguno.getNombre() + "<<<<");
		return this.LISTA;
	}

	@GetMapping("clasificacion/{identificador}")
	public ClasificacionDto getClasificacionDtoPorRuta(@PathVariable() String identificador) throws Exception {

		try {

			final int idInt = Integer.parseInt(identificador);

			var c1 = this.LISTA.stream().filter(c -> c.getId() == idInt).findFirst().orElse(null);

			return c1;

		} catch (Exception e) {
			throw new Exception("Ingrese un numero por favor");
		}

	}

	@GetMapping("clasificacion/buscador/{loQueBusca}")
	public List<ClasificacionDto> getClasificacionDtoPorRutaBuscador(@PathVariable() String loQueBusca) {

		var loFiltrado = this.LISTA.stream().filter(c -> c.getNombre().toUpperCase().contains(loQueBusca.toUpperCase()))
				.collect(Collectors.toList());

		return loFiltrado;
	}

	@GetMapping("clasificacion/conid")
	public ClasificacionDto getClasificacionDto(@RequestParam(name = "id", required = true) String id

	) throws Exception {

		try {
			final int idInt = Integer.parseInt(id);

			var c1 = this.LISTA.stream().filter(c -> c.getId() == idInt).findFirst().orElse(null);

			return c1;
		} catch (Exception e) {
			throw new Exception("Ingrese un numero por favor");
		}

	}

	@PostMapping("clasificacion/{cantVeces}")
	public ClasificacionDto crearMultiple(@PathVariable int cantVeces, @RequestBody ClasificacionDto elNuevo) {
		int nuevoId = 0;
		if (!LISTA.isEmpty()) {
			nuevoId = LISTA.stream().mapToInt(ClasificacionDto::getId).max().getAsInt();
		}

		var clasificacion = ClasificacionDto.builder().nombre(elNuevo.getNombre()).id(nuevoId + 1).build();
		for (int i = 0; i < cantVeces; i++) {
			LISTA.add(clasificacion);
		}

		return clasificacion;
	}

	@PostMapping("clasificacion")
	public ClasificacionDto crear(@RequestBody ClasificacionDto elNuevo) {
		int nuevoId = 0;
		if (!LISTA.isEmpty()) {
			nuevoId = LISTA.stream().mapToInt(ClasificacionDto::getId).max().getAsInt();
		}

		var clasificacion = ClasificacionDto.builder().nombre(elNuevo.getNombre()).id(nuevoId + 1).build();
		LISTA.add(clasificacion);
		return clasificacion;
	}

	@PutMapping("clasificacion/{idParaActualizar}")
	public ClasificacionDto actualizar(@PathVariable int idParaActualizar,
			@RequestBody ClasificacionDto paraActualizar) {

		var elObjetoParaActualizar = LISTA.stream().filter(c -> c.getId() == idParaActualizar).findFirst().orElse(null);
		if (elObjetoParaActualizar != null) {
			elObjetoParaActualizar.setNombre(paraActualizar.getNombre());
		}

		return elObjetoParaActualizar;
	}

	@DeleteMapping("clasificacion/{idParaBorrar}")
	public ClasificacionDto borrar(@PathVariable String idParaBorrar) {

		try {
			int idParaBorrarInt = Integer.parseInt(idParaBorrar);
			var elObjetoParaBorrar = LISTA.stream().filter(c -> c.getId() == idParaBorrarInt).findFirst().orElse(null);

			if (elObjetoParaBorrar != null) {
				LISTA.remove(elObjetoParaBorrar);
				return elObjetoParaBorrar;
			}
		} catch (Exception e) {
			throw new NumberFormatException("DEBE SER UN NUMERO");
		}

		return null;
	}

}
