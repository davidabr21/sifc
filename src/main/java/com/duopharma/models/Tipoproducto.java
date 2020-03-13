package com.duopharma.models;
// Generated 6/02/2020 04:23:00 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tipoproducto generated by hbm2java
 */
@Entity
@Table(name = "tipoproducto", catalog = "sifc_dev")
public class Tipoproducto implements java.io.Serializable {

	private Integer tpId;
	private String tpNombre;
	private String tpDescripcion;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Tipoproducto() {
	}

	public Tipoproducto(String tpNombre) {
		this.tpNombre = tpNombre;
	}

	public Tipoproducto(String tpNombre, String tpDescripcion, Set<Producto> productos) {
		this.tpNombre = tpNombre;
		this.tpDescripcion = tpDescripcion;
		this.productos = productos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "tpId", unique = true, nullable = false)
	public Integer getTpId() {
		return this.tpId;
	}

	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}

	@Column(name = "tpNombre", nullable = false, length = 45)
	public String getTpNombre() {
		return this.tpNombre;
	}

	public void setTpNombre(String tpNombre) {
		this.tpNombre = tpNombre;
	}

	@Column(name = "tpDescripcion", length = 65535)
	public String getTpDescripcion() {
		return this.tpDescripcion;
	}

	public void setTpDescripcion(String tpDescripcion) {
		this.tpDescripcion = tpDescripcion;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tipoproducto")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
