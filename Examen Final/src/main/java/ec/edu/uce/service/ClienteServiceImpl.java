package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IClienteRepo;
import ec.edu.uce.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo paciRepo;
	
	@Override
	public Cliente buscarService(Integer id) {
		// TODO Auto-generated method stub
		return this.paciRepo.buscar(id);
	}

	@Override
	public List<Cliente> buscarTodosService() {
		// TODO Auto-generated method stub
		return this.paciRepo.buscarTodos();
	}

	@Override
	public void actualizarService(Cliente paci) {
		this.paciRepo.actualizar(paci);
	}

	@Override
	public void InsertarService(Cliente paci) {
		this.paciRepo.Insertar(paci);
	}

	@Override
	public void BorrarService(Integer id) {
		this.paciRepo.Borrar(id);
	}

	@Override
	public Cliente buscarCedula(String ced) {
		// TODO Auto-generated method stub
		return this.paciRepo.buscarCedula(ced);
	}

}
