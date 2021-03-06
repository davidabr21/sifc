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
 * Tipooperacion generated by hbm2java
 */
@Entity
@Table(name = "tipooperacion", catalog = "sifc_dev")
public class Tipooperacion implements java.io.Serializable {

	private Integer toId;
	private String toNombre;
	private Set<Movimientoproducto> movimientoproductos = new HashSet<Movimientoproducto>(0);
	private Set<Movimientomateria> movimientomaterias = new HashSet<Movimientomateria>(0);

	public Tipooperacion() {
	}

	public Tipooperacion(String toNombre) {
		this.toNombre = toNombre;
	}

	public Tipooperacion(String toNombre, Set<Movimientoproducto> movimientoproductos,
			Set<Movimientomateria> movimientomaterias) {
		this.toNombre = toNombre;
		this.movimientoproductos = movimientoproductos;
		this.movimientomaterias = movimientomaterias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "toId", unique = true, nullable = false)
	public Integer getToId() {
		return this.toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	@Column(name = "toNombre", nullable = false, length = 50)
	public String getToNombre() {
		return this.toNombre;
	}

	public void setToNombre(String toNombre) {
		this.toNombre = toNombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipooperacion")
	public Set<Movimientoproducto> getMovimientoproductos() {
		return this.movimientoproductos;
	}

	public void setMovimientoproductos(Set<Movimientoproducto> movimientoproductos) {
		this.movimientoproductos = movimientoproductos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipooperacion")
	public Set<Movimientomateria> getMovimientomaterias() {
		return this.movimientomaterias;
	}

	public void setMovimientomaterias(Set<Movimientomateria> movimientomaterias) {
		this.movimientomaterias = movimientomaterias;
	}

}
