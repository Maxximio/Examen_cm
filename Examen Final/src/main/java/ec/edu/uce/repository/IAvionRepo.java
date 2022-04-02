package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.repository.modelo.Avion;

public interface IAvionRepo {

	public Avion buscar(Integer id);
	
	public List<Avion> buscarTodos();
	
	public void actualizar(Avion doc);
	
	public void Insertar(Avion doc);
	
	public void Borrar(Integer id);
	
}
