package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.repository.modelo.Vuelo;

	public interface IVueloService {

	public Vuelo buscarService(Integer id);
	
	public List<Vuelo> buscarTodosService();
	
	public void actualizarService(Vuelo cita);
	
	public void InsertarService(Vuelo cita);
	
	public void BorrarService(Integer id);
	
	public List <Vuelo> buscarOrigenDestinoFService(String origen,String destino,LocalDateTime fecha);
	
	public Vuelo buscarNuemroService(String numero);
	
}
