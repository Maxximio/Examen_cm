package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.repository.modelo.Vuelo;

public interface IVueloRepo {

	public Vuelo buscar(Integer id);
	
	public List<Vuelo> buscarTodos();
	
	public void actualizar(Vuelo cita);
	
	public void Insertar(Vuelo cita);
	
	public void Borrar(Integer id);
	
	//String numero
	public List <Vuelo> buscarOrigenDestinoF(String origen,String destino,LocalDateTime fecha);
	
	public Vuelo buscarNuemro(String numero);
	
}
