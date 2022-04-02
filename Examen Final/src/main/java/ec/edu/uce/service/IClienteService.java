package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Cliente;

public interface IClienteService {

	public Cliente buscarService(Integer id);
	
	public List<Cliente> buscarTodosService();
	
	public void actualizarService(Cliente paci);
	
	public void InsertarService(Cliente paci);
	
	public void BorrarService(Integer id);
	
	public Cliente buscarCedula(String ced);
	
}
