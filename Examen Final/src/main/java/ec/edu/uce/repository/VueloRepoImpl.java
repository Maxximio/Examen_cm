package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Vuelo;
import ec.edu.uce.repository.modelo.Avion;

@Transactional
@Repository
public class VueloRepoImpl implements IVueloRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Vuelo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vuelo.class, id);
	}

	@Override
	public List<Vuelo> buscarTodos() {
		TypedQuery<Vuelo> myQuery=(TypedQuery<Vuelo>)
				this.entityManager.createQuery("SELECT p FROM Vuelo p   ",
						Vuelo.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Vuelo cita) {
		this.entityManager.merge(cita);
	}

	@Override
	public void Insertar(Vuelo cita) {
		this.entityManager.persist(cita);
	}

	@Override
	public void Borrar(Integer id) {
		Vuelo cita=this.buscar(id);
		this.entityManager.remove(cita);
	}

	@Override
	public List <Vuelo> buscarOrigenDestinoF(String origen,String destino,LocalDateTime fecha) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Vuelo> myQuery=myCriteria.createQuery(Vuelo.class);
		
		//Aqui empiezo a construir mi SQL
		Root<Vuelo>myTabla=myQuery.from(Vuelo.class);
		
		//where
		Predicate p1=myCriteria.equal(myTabla.get("origen"),origen);
		Predicate p2=myCriteria.equal(myTabla.get("destino"),destino);
		Predicate p3=myCriteria.equal(myTabla.get("fecha"),fecha);
		Predicate and=myCriteria.and(p1,p2,p3);
		
		myQuery.select(myTabla).where(and);
		
		
		TypedQuery<Vuelo> typedQuery=this.entityManager.createQuery(myQuery);
		
		return typedQuery.getResultList();
	}

	@Override
	public Vuelo buscarNuemro(String numero) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Vuelo> myQuery=myCriteria.createQuery(Vuelo.class);
		
		//Aqui empiezo a construir mi SQL
		Root<Vuelo>myTabla=myQuery.from(Vuelo.class);
		
		//where
		Predicate p1=myCriteria.equal(myTabla.get("numero"),numero);
		Predicate and=myCriteria.and(p1);
		
		myQuery.select(myTabla).where(and);
		
		
		TypedQuery<Vuelo> typedQuery=this.entityManager.createQuery(myQuery);
		
		return typedQuery.getSingleResult();
	}

}
