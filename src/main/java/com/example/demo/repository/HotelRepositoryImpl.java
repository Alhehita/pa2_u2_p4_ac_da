package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements HotelRepository{


	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);
		
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.entityManager.merge(hotel);
		
	}

	@Override
	public void eliminar(String nombre) {
		Hotel hotel = this.seleccionarPorNombre(nombre);
		this.entityManager.remove(hotel);		
	}

	@Override
	public Hotel seleccionarPorNombre(String nombre) {
		return this.entityManager.find(Hotel.class, nombre);
		
		
	}

}
