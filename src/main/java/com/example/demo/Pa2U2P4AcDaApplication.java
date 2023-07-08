package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4AcDaApplication implements CommandLineRunner {

	@Autowired
	EstudianteService estudianteService;

	@Autowired
	MatriculaService matriculaService;

	@Autowired
	HotelService hotelService;
	
	@Autowired
	HabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Hotel hotel = new Hotel();
		hotel.setDireccion("La planada");
		hotel.setNombre("Hotel hotel");

		Habitacion habitacion = new Habitacion();

		habitacion.setHotel(hotel);
		habitacion.setNumero("12");
		habitacion.setValor(new BigDecimal(25));

		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(habitacion);

		hotel.setHabitaciones(habitaciones);
		
		this.hotelService.agregar(hotel);
		
		

		// System.out.println( this.estudianteService.buscarTodosDTO());

		// System.out.println(this.matriculaService.buscarTodosDTO());

		//System.out.println(this.hotelService.buscarPorNombre("Hotel hotel"));
		System.out.println("impresion ");
		System.out.println(this.habitacionService.buscarPorId(habitacion.getId()));

	}

}
