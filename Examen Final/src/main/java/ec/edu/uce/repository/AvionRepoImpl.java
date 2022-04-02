package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Avion;

@Transactional
@Repository
public class AvionRepoImpl implements IAvionRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Avion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Avion.class, id);
	}

	@Override
	public List<Avion> buscarTodos() {
		TypedQuery<Avion> myQuery=(TypedQuery<Avion>)
				this.entityManager.createQuery("SELECT e FROM Avion e   ",
						Avion.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Avion doc) {
		this.entityManager.merge(doc);
		
	}

	@Override
	public void Insertar(Avion doc) {
		this.entityManager.persist(doc);
	}

	@Override
	public void Borrar(Integer id) {
		Avion doc=this.buscar(id);
		this.entityManager.remove(doc);
	}

}
