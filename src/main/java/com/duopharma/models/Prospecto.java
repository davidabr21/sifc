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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Prospecto generated by hbm2java
 */
@Entity
@Table(name = "prospecto", catalog = "sifc_dev")
public class Prospecto implements java.io.Serializable {

	private Integer prsId;
	private String prsNombre;
	private String prsDescripcion;
	private String prsTipo;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Prospecto() {
	}

	public Prospecto(String prsNombre, String prsDescripcion) {
		this.prsNombre = prsNombre;
		this.prsDescripcion = prsDescripcion;
	}

	public Prospecto(String prsNombre, String prsDescripcion, Set<Producto> productos) {
		this.prsNombre = prsNombre;
		this.prsDescripcion = prsDescripcion;
		this.productos = productos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "prsId", unique = true, nullable = false)
	public Integer getPrsId() {
		return this.prsId;
	}

	public void setPrsId(Integer prsId) {
		this.prsId = prsId;
	}

	@Column(name = "prsNombre", nullable = false, length = 45)
	public String getPrsNombre() {
		return this.prsNombre;
	}

	public void setPrsNombre(String prsNombre) {
		this.prsNombre = prsNombre;
	}

	@Column(name = "prsDescripcion", nullable = false)
	public String getPrsDescripcion() {
		return this.prsDescripcion;
	}

	public void setPrsDescripcion(String prsDescripcion) {
		this.prsDescripcion = prsDescripcion;
	}
	
	@Column(name = "prsTipo", nullable = false, length = 45)
	public String getPrsTipo() {
		return prsTipo;
	}

	public void setPrsTipo(String prsTipo) {
		this.prsTipo = prsTipo;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "prospectosporproducto", catalog = "sifc_dev", joinColumns = {
			@JoinColumn(name = "ppProspecto_prsId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ppProducto_proId", nullable = false, updatable = false) })
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}