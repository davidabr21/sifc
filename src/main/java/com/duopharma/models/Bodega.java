package com.duopharma.models;
// Generated 25/02/2020 04:47:30 PM by Hibernate Tools 4.3.5.Final

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
 * Bodega generated by hbm2java
 */
@Entity
@Table(name = "bodega", catalog = "sifc_dev")
public class Bodega implements java.io.Serializable {

	private Integer boId;
	private String boDireccion;
	private boolean boEstado;
	private String boNombre;
	private long boTelefono;
	private Set<Estanteria> estanterias = new HashSet<Estanteria>(0);
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Bodega() {
	}

	public Bodega(String boDireccion, boolean boEstado, String boNombre) {
		this.boDireccion = boDireccion;
		this.boEstado = boEstado;
		this.boNombre = boNombre;
	}

	public Bodega(String boDireccion, boolean boEstado, String boNombre, Integer boTelefono,
			Set<Estanteria> estanterias, Set<Usuario> usuarios) {
		this.boDireccion = boDireccion;
		this.boEstado = boEstado;
		this.boNombre = boNombre;
		this.boTelefono = boTelefono;
		this.estanterias = estanterias;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "boId", unique = true, nullable = false)
	public Integer getBoId() {
		return this.boId;
	}

	public void setBoId(Integer boId) {
		this.boId = boId;
	}

	@Column(name = "boDireccion", nullable = false, length = 90)
	public String getBoDireccion() {
		return this.boDireccion;
	}

	public void setBoDireccion(String boDireccion) {
		this.boDireccion = boDireccion;
	}

	@Column(name = "boEstado", nullable = false)
	public boolean isBoEstado() {
		return this.boEstado;
	}

	public void setBoEstado(boolean boEstado) {
		this.boEstado = boEstado;
	}

	@Column(name = "boNombre", nullable = false, length = 100)
	public String getBoNombre() {
		return this.boNombre;
	}

	public void setBoNombre(String boNombre) {
		this.boNombre = boNombre;
	}

	@Column(name = "boTelefono")
	public long getBoTelefono() {
		return this.boTelefono;
	}

	public void setBoTelefono(long boTelefono) {
		this.boTelefono = boTelefono;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bodega")
	public Set<Estanteria> getEstanterias() {
		return this.estanterias;
	}

	public void setEstanterias(Set<Estanteria> estanterias) {
		this.estanterias = estanterias;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bodega")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
