package com.example.demo.repository.modelo.dto;

public class MatriculaDTO {

	private String nombreM;
	private String nombreA;

	public MatriculaDTO() {
	}

	public MatriculaDTO(String nombreM, String nombreA) {
		super();
		this.nombreM = nombreM;
		this.nombreA = nombreA;
	}

	public String getNombreM() {
		return nombreM;
	}

	public void setNombreM(String nombreM) {
		this.nombreM = nombreM;
	}

	public String getNombreA() {
		return nombreA;
	}

	public void setNombreA(String nombreA) {
		this.nombreA = nombreA;
	}

	@Override
	public String toString() {
		return "\nMatriculaDTO [nombreM=" + nombreM + ", nombreA=" + nombreA + "]";
	}
	
	

}
