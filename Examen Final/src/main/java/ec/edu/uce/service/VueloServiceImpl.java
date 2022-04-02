package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IClienteRepo;
import ec.edu.uce.repository.IVueloRepo;
import ec.edu.uce.repository.modelo.Cliente;
import ec.edu.uce.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService{

	@Autowired
	private IVueloRepo vuelRepo;

	@Override
	public Vuelo buscarService(Integer id) {
		// TODO Auto-generated method stub
		return this.vuelRepo.buscar(id);
	}

	@Override
	public List<Vuelo> buscarTodosService() {
		// TODO Auto-generated method stub
		return this.vuelRepo.buscarTodos();
	}

	@Override
	public void actualizarService(Vuelo cita) {
		this.vuelRepo.actualizar(cita);
	}

	@Override
	public void InsertarService(Vuelo cita) {
		this.vuelRepo.Insertar(cita);
	}

	@Override
	public void BorrarService(Integer id) {
		this.vuelRepo.Borrar(id);
	}

	@Override
	public List<Vuelo> buscarOrigenDestinoFService(String origen, String destino, LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.vuelRepo.buscarOrigenDestinoF(origen, destino, fecha);
	}

	@Override
	public Vuelo buscarNuemroService(String numero) {
		// TODO Auto-generated method stub
		return this.vuelRepo.buscarNuemro(numero);
	}

	
	
	
}
