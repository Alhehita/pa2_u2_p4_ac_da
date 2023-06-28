package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements LibroRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {

		this.entityManager.persist(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(String titulo) {
		Libro libro = this.seleccionarPorTitulo(titulo);
		this.entityManager.remove(libro);
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, titulo);
	}

}
