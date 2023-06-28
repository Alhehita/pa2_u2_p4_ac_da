package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	private MatriculaRepository matriculaRepository;

	@Override
	public void guardar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
	}

}
