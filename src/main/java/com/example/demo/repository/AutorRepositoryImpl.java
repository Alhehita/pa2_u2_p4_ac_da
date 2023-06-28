package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements AutorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor autor) {

		this.entityManager.persist(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(String id) {
		Autor autor = this.seleccionarPorId(id);
		this.entityManager.remove(autor);
	}

	@Override
	public Autor seleccionarPorId(String id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

}
