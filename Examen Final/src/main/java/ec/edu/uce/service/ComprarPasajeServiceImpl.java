package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IClienteRepo;
import ec.edu.uce.repository.ICompraPasajeRepo;
import ec.edu.uce.repository.modelo.Cliente;
import ec.edu.uce.repository.modelo.CompraPasaje;

@Service
public class ComprarPasajeServiceImpl implements ICompraPasajeService{

	@Autowired
	private ICompraPasajeRepo compaService;

	@Override
	public CompraPasaje buscar(Integer id) {
		return this.compaService.buscar(id);
	}

	@Override
	public List<CompraPasaje> buscarTodos() {
		return this.compaService.buscarTodos();
	}

	@Override
	public void actualizar(CompraPasaje compra) {
		this.compaService.actualizar(compra);
	}

	@Override
	public void Insertar(CompraPasaje compra) {
		this.compaService.Insertar(compra);
	}

	@Override
	public void Borrar(Integer id) {
		this.compaService.Borrar(id);
	}

	@Override
	public CompraPasaje buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.compaService.buscarNumero(numero);
	}
	
	

}
