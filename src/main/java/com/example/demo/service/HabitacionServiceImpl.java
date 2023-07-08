package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HabitacionRepository;
import com.example.demo.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements HabitacionService {

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Override
	public void agregar(Habitacion habitacion) {
		this.habitacionRepository.insertar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
this.habitacionRepository.actualizar(habitacion);
	}

	@Override
	public void borrar(String numero) {
this.habitacionRepository.eliminar(numero);
	}

	@Override
	public Habitacion buscarPorNumero(String numero) {
		return this.buscarPorNumero(numero);
	}

	@Override
	public Habitacion buscarPorId(Integer id) {
		return this.habitacionRepository.seleccionarPorId(id);
	}

}
