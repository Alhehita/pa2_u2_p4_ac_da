package com.example.demo.repository;

import java.util.List;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder.Builder;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante); // permite insertar una entidad en la base de datos
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante); // permite actualizar una entidad en la base de datos
	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estu = this.seleccionar(cedula);
		this.entityManager.remove(estu);
	}

	@Override
	public Estudiante seleccionar(String cedula) {

		// this.entityManager.find(Estudiante.class, cedula);
		return this.entityManager.find(Estudiante.class, cedula); // indica que se va a trabajar con una clase
																	// Estuidiante
	}

	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		// SQL
		// Select* From estudiante where e.estu_apellido =
		// JPQL
		// SELECT e FROM Estudiante e WHERE e.apellido =
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();

	}

	@Override
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre) {
		Query myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre =: datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamed(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellido",
				Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {
		Query query = this.entityManager
				.createNativeQuery("SELECT * FROM estudiante WHERE estu_apellido = :datoApellido", Estudiante.class);
		query.setParameter("datoApellido", apellido);

		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido) {
		Query query = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoNative", Estudiante.class);
		query.setParameter("datoApellido", apellido);

		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreNativeQuery(String nombre) {
		Query query = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative", Estudiante.class);
		query.setParameter("datoNombre", nombre);

		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreNamedQuery(String nombre) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorapellidoCriterialAPIQuery(String apellido) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		// 1. Especificar el tipo de retorno que tiene mi Query

		CriteriaQuery<Estudiante> criteriaQuery = builder.createQuery(Estudiante.class);

		// 2. Empezamos a crear el SQL
		// 2.1 definimos el FROM (Root)

		Root<Estudiante> miTablaFrom = criteriaQuery.from(Estudiante.class); // FROM estudiante

		// 3. Construir las condiciones del SQL, las condiciones se las conoce como
		// predicados
		// cada condicion es un predicado
		// e.apellido = :datoApellido
		Predicate condicionApellido = builder.equal(miTablaFrom.get("apellido"), apellido);

		// 4.Armamos mi SQL final
		criteriaQuery.select(miTablaFrom).where(condicionApellido);

		// 5. ejecucion del query lo realizamos con TypedQuery
		TypedQuery<Estudiante> queryFinal = this.entityManager.createQuery(criteriaQuery);

		return queryFinal.getSingleResult();
	}

	@Override
	public Estudiante seleccionarEstudianteDinamico(String nombre, String apellido, Double peso) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		// 1. Especificar el tipo de retorno que tiene mi Query

		CriteriaQuery<Estudiante> criteriaQuery = builder.createQuery(Estudiante.class);

		// 2. Empezamos a crear el SQL
		// 2.1 definimos el FROM (Root)

		Root<Estudiante> miTablaFrom = criteriaQuery.from(Estudiante.class); // FROM estudiante

		// 3. Construir las condiciones del SQL, las condiciones se las conoce como
		// predicados

		// > 100 e.nombre = ? AND e.apellido= ?
		// <= 100 e.nombre = ? OR e.apellido = ?

		// e.nombre = ?
		Predicate pNombre = builder.equal(miTablaFrom.get("nombre"), nombre);
		// e.apellido= ?
		Predicate pApellido = builder.equal(miTablaFrom.get("apellido"), apellido);

		Predicate predicadoFinal = null;
		if (peso.compareTo(Double.valueOf(100)) <= 0) {
			predicadoFinal = builder.or(pNombre, pApellido);
		} else {
			predicadoFinal = builder.and(pNombre, pApellido);
		}

		// 4.Armamos mi SQL final
		criteriaQuery.select(miTablaFrom).where(predicadoFinal);

		// 5. ejecucion del query lo realizamos con TypedQuery
		TypedQuery<Estudiante> queryFinal = this.entityManager.createQuery(criteriaQuery);

		return queryFinal.getSingleResult();
	}

	@Override
	public int eliminarPorNombre(String nombre) {
		//DELETE FROM estudiante WHERE estu_nombre = ?
		//DELETE FROM estuadiante e WHERE e.nombre = :datoNombre
		
		Query query = this.entityManager.createQuery("DELETE FROM Estudiante e WHERE e.nombre = :datoNombre");
		query.setParameter("datoNombre", nombre);
		return query.executeUpdate();
	}

	@Override
	public int actualizarPorApellido(String nombre,String apellido) {
		//UPDATE estudiante SET estu_nombre = ? WHERE estu_apellido
		
		//UPDATE Estudiante e SET e.nombre= :datoNombre WHERE e.apellido= :datoApellido
		
		Query query = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre= :datoNombre WHERE e.apellido= :datoApellido");
		query.setParameter("datoApellido", apellido);
		query.setParameter("datoNombre", nombre);
		return query.executeUpdate();		
	}

}
