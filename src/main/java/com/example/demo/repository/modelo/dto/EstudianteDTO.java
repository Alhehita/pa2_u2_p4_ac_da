package com.example.demo.repository.modelo.dto;

import jakarta.persistence.Column;

public class EstudianteDTO {

	private String nombre;

	private String apellido;
	
	public EstudianteDTO() {
		
	}

	public EstudianteDTO(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	//Get y Set
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "\nEstudiante [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	


}
