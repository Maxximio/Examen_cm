package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Vuelo;
import ec.edu.uce.repository.modelo.Avion;
import ec.edu.uce.repository.modelo.CompraPasaje;

@Transactional
@Repository
public class CompraPasajeRepoImpl implements ICompraPasajeRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CompraPasaje buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CompraPasaje.class, id);
	}

	@Override
	public List<CompraPasaje> buscarTodos() {
		TypedQuery<CompraPasaje> myQuery=(TypedQuery<CompraPasaje>)
				this.entityManager.createQuery("SELECT p FROM CompraPasaje p   ",
						CompraPasaje.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(CompraPasaje cita) {
		this.entityManager.merge(cita);
	}

	@Override
	public void Insertar(CompraPasaje cita) {
		this.entityManager.persist(cita);
	}

	@Override
	public void Borrar(Integer id) {
		CompraPasaje cita=this.buscar(id);
		this.entityManager.remove(cita);
	}

	@Override
	public CompraPasaje buscarNumero(String numero) {
		Query miQuery= this.entityManager.createNativeQuery
				("select * from compra_pasaje c where c.copa_numero=:valor",CompraPasaje.class);
		miQuery.setParameter("valor", numero);
		return (CompraPasaje) miQuery.getSingleResult();
	}

}
