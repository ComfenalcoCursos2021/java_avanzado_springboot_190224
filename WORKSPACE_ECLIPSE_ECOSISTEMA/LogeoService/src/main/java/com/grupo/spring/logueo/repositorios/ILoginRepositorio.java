package com.grupo.spring.logueo.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo.spring.logueo.entidades.LoginEntidad;

public interface ILoginRepositorio extends JpaRepository<LoginEntidad,Integer> {

	Optional<LoginEntidad> findByNick(String nick);
}
