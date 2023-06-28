package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public void agregar(Autor autor) {
		this.autorRepository.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		this.autorRepository.actualizar(autor);
	}

	@Override
	public void borrar(String id) {
		this.autorRepository.eliminar(id);
	}

	@Override
	public Autor buscarPorId(String id) {
		return this.autorRepository.seleccionarPorId(id);
	}

}
