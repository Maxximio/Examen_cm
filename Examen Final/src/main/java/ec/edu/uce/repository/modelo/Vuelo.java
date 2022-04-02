package ec.edu.uce.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vuelo")
public class Vuelo {

	@Id
	@Column(name="vuel_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vuel")
	@SequenceGenerator(name="seq_vuel",sequenceName = "seq_vuel",allocationSize = 1)
	private Integer id;
	
	@Column(name="vuel_numero")
	private String numero;
	
	@Column(name="vuel_nombre")
	private String nombreAvion;
	
	@Column(name="vuel_origen")
	private String origen;
	
	@Column(name="vuel_destino")
	private String destino;
	
	@Column(name="vuel_fecha")
	private LocalDateTime fecha;
	
	@Column(name="vuel_valor")
	private BigDecimal valor;
	
	@Column(name="vuel_estado")
	private String estado;
	
	@Column(name="vuel_categoria")
	private String categoria;
	
	@Column(name="vuel_asientos")
	private Integer asientos;
	
	@OneToMany(mappedBy = "vuelo",cascade=CascadeType.ALL)
	private List<CompraPasaje> compra_pasaje;
	
	@ManyToOne
	@JoinColumn(name="avio_id")
	private Avion avion;
	
	//constructores
	public Vuelo() {
		
	}
	
	public Vuelo(Integer id, String numero, String nombreAvion, String origen, String destino, LocalDateTime fecha,
			BigDecimal valor, String estado, String categoria, Integer asientos, List<CompraPasaje> compra_pasaje,
			Avion avion) {
		super();
		this.id = id;
		this.numero = numero;
		this.nombreAvion = nombreAvion;
		this.origen = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.valor = valor;
		this.estado = estado;
		this.categoria = categoria;
		this.asientos = asientos;
		this.compra_pasaje = compra_pasaje;
		this.avion = avion;
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

	public String getNombreAvion() {
		return nombreAvion;
	}

	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getAsientos() {
		return asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}

	public List<CompraPasaje> getCompra_pasaje() {
		return compra_pasaje;
	}

	public void setCompra_pasaje(List<CompraPasaje> compra_pasaje) {
		this.compra_pasaje = compra_pasaje;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	
	
	
	
}
