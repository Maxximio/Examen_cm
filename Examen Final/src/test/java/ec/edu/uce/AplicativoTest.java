package ec.edu.uce;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.repository.modelo.Avion;
import ec.edu.uce.repository.modelo.Cliente;
import ec.edu.uce.repository.modelo.Vuelo;
import ec.edu.uce.service.IAvionService;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.IVueloService;

@SpringBootTest
@Rollback(true)
@Transactional
class AplicativoTest {

	@Autowired
	private IAvionService avioServ;
	
	@Autowired
	private IVueloService vuelServ;
	
	@Autowired
	private IClienteService clieServ;
	
	@Test
	void testAvion() {
		assertEquals("20", this.avioServ.buscarService(1).getCapacidad());
	}
	
	@Test
	void testVuelo() {
		assertEquals("Guayaquil", this.vuelServ.buscarNuemroService("123").getDestino());
	}
	
	@Test
	void testCliente() {
		assertEquals("Montalvo", this.clieServ.buscarCedula("1243535").getApellido());
	}
	
	@BeforeEach
	void datos() {

		Avion avi=new Avion();
		avi.setCapacidad("20");
		
		avioServ.InsertarService(avi);
		
		Vuelo vuel=new Vuelo();
		vuel.setAvion(avi);
		vuel.setNumero("123");
		vuel.setNombreAvion("747-QWR");
		vuel.setOrigen("Quito");
		vuel.setDestino("Guayaquil");
		vuel.setFecha(LocalDateTime.now());
		vuel.setValor(new BigDecimal(100.00));
		vuel.setEstado("NO_DISPONIBLE");
		vuel.setCategoria("Turista");
		vuel.setAsientos(0);
		
		vuelServ.InsertarService(vuel);
		
		Cliente cli =new Cliente();
		cli.setNombre("Carlos");
		cli.setApellido("Montalvo");
		cli.setCedula("1243535");
		
		clieServ.InsertarService(cli);
	}

}
