package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public void agregar(Hotel hotel) {
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);
	}

	@Override
	public void borrar(String nombre) {
		this.hotelRepository.eliminar(nombre);
	}

	@Override
	public Hotel buscarPorNombre(String nombre) {
		return this.hotelRepository.seleccionarPorNombre(nombre);
	}

}
