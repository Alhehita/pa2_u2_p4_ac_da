package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements EmpleadoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		Empleado empleado = this.seleccionarPorId(id);
		this.entityManager.remove(empleado);
	}

	@Override
	public Empleado seleccionarPorId(String id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}
}
