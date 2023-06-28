package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements CiudadanoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Ciudadano ciudadano = this.seleccionarPorCedula(cedula);
		this.entityManager.remove(ciudadano);
	}

	@Override
	public Ciudadano seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, cedula);
	}
}
