package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.CompraPasaje;

	public interface ICompraPasajeService {

	public CompraPasaje buscar(Integer id);
	
	public List<CompraPasaje> buscarTodos();
	
	public void actualizar(CompraPasaje compra);
	
	public void Insertar(CompraPasaje compra);
	
	public void Borrar(Integer id);
	
	public CompraPasaje buscarNumero(String numero);
	
}
