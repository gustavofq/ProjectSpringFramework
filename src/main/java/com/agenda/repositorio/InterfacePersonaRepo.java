package com.agenda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.logica.Persona;

public interface InterfacePersonaRepo extends JpaRepository<Persona, Integer>{
	
}
