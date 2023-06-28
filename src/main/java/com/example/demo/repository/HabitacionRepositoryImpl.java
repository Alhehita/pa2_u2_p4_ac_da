package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements HabitacionRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Habitacion habitacion) {
		this.entityManager.persist(habitacion);

		
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.entityManager.merge(habitacion);
		
	}

	@Override
	public void eliminar(String numero) {
		Habitacion habitacion = this.seleccionarPorNumero(numero);
		this.entityManager.remove(numero);
			
	}

	@Override
	public Habitacion seleccionarPorNumero(String numero) {
		return this.entityManager.find(Habitacion.class, numero);
	}

}
