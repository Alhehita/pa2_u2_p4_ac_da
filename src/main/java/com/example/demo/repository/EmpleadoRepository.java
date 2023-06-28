package com.example.demo.repository;

import com.example.demo.repository.modelo.Empleado;

public interface EmpleadoRepository {
	
	public void insertar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(String id);

	public Empleado seleccionarPorId(String id);

}
