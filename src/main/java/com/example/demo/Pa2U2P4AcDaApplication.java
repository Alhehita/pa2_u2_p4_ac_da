package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U2P4AcDaApplication implements CommandLineRunner {

	@Autowired
	EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Estudiante estudiante = new Estudiante();
		estudiante.setApellido("Guamaninga");
		estudiante.setCedula("0123456789");
		estudiante.setNombre("Alfredo");

		//this.estudianteService.guardar(estudiante);

		this.estudianteService.buscarPorApellidoNamed("Naranjito");

		this.estudianteService.buscarPorApellidoNamedQuery("Naranjito");

		this.estudianteService.buscarPorApellidoNativeQuery("Naranjito");
		
		this.estudianteService.buscarPorApellidoNativeQueryNamed("Guamaninga");
		System.out.println("----");
		this.estudianteService.buscarPorNombreNativeQuery("Alfredo");
		
		this.estudianteService.buscarPorNombreNamedQuery("Alfredo");

	}

}
