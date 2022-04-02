package ec.edu.uce.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="compra_pasaje")
public class CompraPasaje {

	@Id
	@Column(name="copa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_copa")
	@SequenceGenerator(name="seq_copa",sequenceName = "seq_copa",allocationSize = 1)
	private Integer id;
	
	@Column(name="copa_numero")
	private String numero;
	
	@Column(name="copa_fecha")
	private LocalDateTime fecha;
	
	@Column(name="copa_numero_tarjeta")
	private String numeroTarjeta;
	
	@Column(name="copa_estado")
	private String estado;
	
	@Column(name="copa_asientos_comprados")
	private Integer asientosComprados;
	
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="vuel_id")
	private Vuelo vuelo;

	//constructor
	public CompraPasaje() {
		
	}
	
	public CompraPasaje(Integer id, String numero, LocalDateTime fecha, String numeroTarjeta, String estado,
			Integer asientosComprados, Cliente cliente, Vuelo vuelo) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha = fecha;
		this.numeroTarjeta = numeroTarjeta;
		this.estado = estado;
		this.asientosComprados = asientosComprados;
		this.cliente = cliente;
		this.vuelo = vuelo;
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getAsientosComprados() {
		return asientosComprados;
	}

	public void setAsientosComprados(Integer asientosComprados) {
		this.asientosComprados = asientosComprados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
	
}
