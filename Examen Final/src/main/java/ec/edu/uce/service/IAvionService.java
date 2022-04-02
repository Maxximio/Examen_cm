package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Avion;

public interface IAvionService {

	public Avion buscarService(Integer id);
	
	public List<Avion> buscarTodosService();
	
	public void actualizarService(Avion doc);
	
	public void InsertarService(Avion doc);
	
	public void BorrarService(Integer id);
	
}
