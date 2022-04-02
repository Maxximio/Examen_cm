package ec.edu.uce.repository.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@Column(name="clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_clie")
	@SequenceGenerator(name="seq_clie",sequenceName = "seq_clie",allocationSize = 1)
	private Integer id;
		
	@Column(name="clie_nombre")
	private String nombre;
	
	@Column(name="clie_apellido")
	private String apellido;
	
	@Column(name="clie_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	private List<CompraPasaje> compra_pasaje;

	//constructores
	public Cliente() {
		
	}

	public Cliente(Integer id, String nombre, String apellido, String cedula, List<CompraPasaje> compra_pasaje) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.compra_pasaje = compra_pasaje;
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<CompraPasaje> getCompra_pasaje() {
		return compra_pasaje;
	}

	public void setCompra_pasaje(List<CompraPasaje> compra_pasaje) {
		this.compra_pasaje = compra_pasaje;
	}
		
	
	
	
}
