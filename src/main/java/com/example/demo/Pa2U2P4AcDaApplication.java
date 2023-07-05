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
		estudiante.setApellido("Naranjo");
		estudiante.setCedula("5674912");
		estudiante.setNombre("Anthony");
		estudiante.setPeso(70.2);

		Estudiante estudiante1 = new Estudiante();
		estudiante1.setApellido("Arteaga");
		estudiante1.setCedula("5674456");
		estudiante1.setNombre("Jhon");
		estudiante1.setPeso(102.6);

		// this.estudianteService.guardar(estudiante);

		// this.estudianteService.guardar(estudiante1);

		Estudiante estudiante2 = this.estudianteService.buscarEstudianteDinamico("Anthony", "Naranjo",
				50.2);
		
		System.out.println(estudiante2);

		
		Estudiante estudiante3 = this.estudianteService.buscarEstudianteDinamico("Jhon", "Arteaga",150.2);
		
		System.out.println(estudiante3);
		
		
		int borrar = this.estudianteService.borrarPorNombre("Cristiana");
		
		int actualizar = this.estudianteService.actualizarPorApellido("Jairo", "Arteaga");
		
		System.out.println(borrar);
		
		System.out.println(actualizar);
		
		
	}

}
