package com.agenda.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agenda.logica.Persona;
import com.agenda.repositorio.InterfacePersonaRepo;


@SpringBootApplication
@Controller
@EntityScan(basePackages = {"com.agenda.logica"})
@EnableJpaRepositories(basePackages = {"com.agenda.repositorio"})
@ComponentScan(basePackageClasses = AgendaApplication.class)
public class AgendaApplication {
	
	@Autowired
	private InterfacePersonaRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		Persona unaPersona = new Persona();
		unaPersona.setApellido("quintana");
		unaPersona.setNombre("Gustavo");
		unaPersona.setId(1);
		unaPersona.setTelefono("376412354");
		unaPersona.setTelefono2("375535887");
		unaPersona.setCorreo("quintana.gustavo.f@gmai.com");
		repo.save(unaPersona);
		return "greeting";
	}

}
