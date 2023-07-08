package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	private MatriculaRepository matriculaRepository;

	@Override
	public void guardar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	public List<MatriculaDTO> buscarTodosDTO() {
		return this.matriculaRepository.seleccionarTodosDTO();
	}

}
