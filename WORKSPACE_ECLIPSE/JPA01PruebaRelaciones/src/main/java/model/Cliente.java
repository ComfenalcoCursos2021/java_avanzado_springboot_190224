package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String documento;

	private String nombre;

	//bi-directional many-to-one association to FacturaEncabezado
	@OneToMany(mappedBy="cliente")
	private List<FacturaEncabezado> facturaEncabezados;

	//bi-directional many-to-one association to Loggeo
	@OneToMany(mappedBy="cliente")
	private List<Loggeo> loggeos;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<FacturaEncabezado> getFacturaEncabezados() {
		return this.facturaEncabezados;
	}

	public void setFacturaEncabezados(List<FacturaEncabezado> facturaEncabezados) {
		this.facturaEncabezados = facturaEncabezados;
	}

	public FacturaEncabezado addFacturaEncabezado(FacturaEncabezado facturaEncabezado) {
		getFacturaEncabezados().add(facturaEncabezado);
		facturaEncabezado.setCliente(this);

		return facturaEncabezado;
	}

	public FacturaEncabezado removeFacturaEncabezado(FacturaEncabezado facturaEncabezado) {
		getFacturaEncabezados().remove(facturaEncabezado);
		facturaEncabezado.setCliente(null);

		return facturaEncabezado;
	}

	public List<Loggeo> getLoggeos() {
		return this.loggeos;
	}

	public void setLoggeos(List<Loggeo> loggeos) {
		this.loggeos = loggeos;
	}

	public Loggeo addLoggeo(Loggeo loggeo) {
		getLoggeos().add(loggeo);
		loggeo.setCliente(this);

		return loggeo;
	}

	public Loggeo removeLoggeo(Loggeo loggeo) {
		getLoggeos().remove(loggeo);
		loggeo.setCliente(null);

		return loggeo;
	}

}