package ec.edu.uce.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.repository.modelo.CompraPasaje;
import ec.edu.uce.repository.modelo.Vuelo;
import ec.edu.uce.service.IVueloService;
import ec.edu.uce.service.IAvionService;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.ICompraPasajeService;

@Controller
@RequestMapping("/sistema")
public class ServiciosController {

	@Autowired
	private IClienteService clienService;
	
	@Autowired
	private IAvionService avioService;
	
	@Autowired
	private IVueloService vueloService;
	
	@Autowired
	private ICompraPasajeService compraService;
	
	/////////BuscarVuelosDisponibles
	
	@GetMapping("/buscarVuelos")
	public String obtenerPaginaBusquedaParametros(Vuelo vuelo) {
		return "busquedaVuelos";
		
	}
	
	@GetMapping("/resultados")
	public String BuscarVuelo(Vuelo vuelo,BindingResult result,Model modelo) {
		
		List<Vuelo> listaVuelos=this.vueloService.buscarOrigenDestinoFService(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFecha());
	
		modelo.addAttribute("vuelos", listaVuelos);
		
	return "listaVA";
		
	}
	
	/////////////Reservar Pasajes
	
	@GetMapping("/buscarDisponibles")
	public String obtenerPaginaBusquedaNumero(Vuelo vuelo) {
		return "busquedaVuelos2";
		
	}
	
	@GetMapping("/resultadonum")
	public String BuscarVueloNum(Vuelo vuelo,CompraPasaje compa,BindingResult result,Model modelo) {
		
		Vuelo vuela =this.vueloService.buscarNuemroService(vuelo.getNumero());
		
		modelo.addAttribute("vuelo", vuela);
		
	return "listaD";
		
	}

	//reserva
	
	@Transactional
	@GetMapping("/reserva")
	public String GenerandoReserva(Vuelo vuelo, CompraPasaje compa,BindingResult result,Model modelo) {
		
		vuelo.setAsientos(vuelo.getAsientos()-compa.getAsientosComprados());
		
		if(vuelo.getAsientos()<=-1) {
			return "falla";
		}else {
			if(vuelo.getAsientos()==0) {
				vuelo.setEstado("NO_DISPONIBLE");
				vueloService.actualizarService(vuelo);
			}
			compraService.Insertar(compa);
			vueloService.actualizarService(vuelo);
			
		return "exito";
		}
	}
	
	///////////Check-in
	
	@GetMapping("/check")
	public String obtenerPaginaCheck(CompraPasaje compa,Model modelo) {
		CompraPasaje compas=this.compraService.buscarNumero(compa.getNumero());
		
		modelo.addAttribute("compas",compa); 
		return "check-in";
	}
	
	@PutMapping("/chekCompleto")
	public String CheckCompletado(CompraPasaje compa,BindingResult result,Model modelo) {
		
		compa.setEstado("CHECK-IN");
		compraService.actualizar(compa);
		
	return "index";
		
	}
		
}
