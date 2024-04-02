package com.grupo.spring.producto.clientesremotos;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.grupo.spring.producto.dtos.ResultadoDto;
import com.grupo.spring.producto.dtos.UsuarioDto;

@Service
@FeignClient("UsuarioService")
public interface IUsuarioClienteRemoto {

	@GetMapping("/api/usuario")
	public ResultadoDto<List<UsuarioDto>> obtenerTodosLosUsuarios();
}
