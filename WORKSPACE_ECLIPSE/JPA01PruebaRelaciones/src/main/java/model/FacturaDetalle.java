package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the factura_detalle database table.
 * 
 */
@Entity
@Table(name="factura_detalle")
@NamedQuery(name="FacturaDetalle.findAll", query="SELECT f FROM FacturaDetalle f")
public class FacturaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad;

	private BigDecimal total;

	//bi-directional many-to-one association to FacturaEncabezado
	@ManyToOne
	@JoinColumn(name="FACTURA_ENCABEZADO_ID")
	private FacturaEncabezado facturaEncabezado;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	private Producto producto;

	public FacturaDetalle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public FacturaEncabezado getFacturaEncabezado() {
		return this.facturaEncabezado;
	}

	public void setFacturaEncabezado(FacturaEncabezado facturaEncabezado) {
		this.facturaEncabezado = facturaEncabezado;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}