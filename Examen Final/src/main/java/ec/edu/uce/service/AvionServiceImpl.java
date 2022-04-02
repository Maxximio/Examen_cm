package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IAvionRepo;
import ec.edu.uce.repository.IClienteRepo;
import ec.edu.uce.repository.modelo.Avion;
import ec.edu.uce.repository.modelo.Cliente;

@Service
public class AvionServiceImpl implements IAvionService{

	@Autowired
	private IAvionRepo aviRepo;

	@Override
	public Avion buscarService(Integer id) {
		// TODO Auto-generated method stub
		return this.aviRepo.buscar(id);
	}

	@Override
	public List<Avion> buscarTodosService() {
		// TODO Auto-generated method stub
		return this.aviRepo.buscarTodos();
	}

	@Override
	public void actualizarService(Avion doc) {
		this.aviRepo.actualizar(doc);
	}

	@Override
	public void InsertarService(Avion doc) {
		this.aviRepo.Insertar(doc);
	}

	@Override
	public void BorrarService(Integer id) {
		this.aviRepo.Borrar(id);
	}
	

}
