package com.duopharma.models;
// Generated 6/02/2020 04:23:00 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Fichaelaboracionproducto generated by hbm2java
 */
@Entity
@Table(name = "fichaelaboracionproducto", catalog = "sifc_dev")
public class Fichaelaboracionproducto implements java.io.Serializable {

	private Integer fepId;
	private Lote lote;
	private Usuario usuario;
	private Date fepFechaInicial;
	private Date fepFechaFabricacion;
	private Date fepFechaAprobacion;
	private String fepFirmaAutorizacion;
	private String fepObservacion;

	public Fichaelaboracionproducto() {
	}

	public Fichaelaboracionproducto(Lote lote, Date fepFechaInicial) {
		this.lote = lote;
		this.fepFechaInicial = fepFechaInicial;
	}

	public Fichaelaboracionproducto(Lote lote, Usuario usuario, Date fepFechaInicial, Date fepFechaFabricacion,
			Date fepFechaAprobacion, String fepFirmaAutorizacion, String fepObservacion) {
		this.lote = lote;
		this.usuario = usuario;
		this.fepFechaInicial = fepFechaInicial;
		this.fepFechaFabricacion = fepFechaFabricacion;
		this.fepFechaAprobacion = fepFechaAprobacion;
		this.fepFirmaAutorizacion = fepFirmaAutorizacion;
		this.fepObservacion = fepObservacion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "fepId", unique = true, nullable = false)
	public Integer getFepId() {
		return this.fepId;
	}

	public void setFepId(Integer fepId) {
		this.fepId = fepId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Lote_lotId", nullable = false)
	public Lote getLote() {
		return this.lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fepAutorizador")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fepFechaInicial", nullable = false, length = 10)
	public Date getFepFechaInicial() {
		return this.fepFechaInicial;
	}

	public void setFepFechaInicial(Date fepFechaInicial) {
		this.fepFechaInicial = fepFechaInicial;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fepFechaFabricacion", length = 10)
	public Date getFepFechaFabricacion() {
		return this.fepFechaFabricacion;
	}

	public void setFepFechaFabricacion(Date fepFechaFabricacion) {
		this.fepFechaFabricacion = fepFechaFabricacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fepFechaAprobacion", length = 10)
	public Date getFepFechaAprobacion() {
		return this.fepFechaAprobacion;
	}

	public void setFepFechaAprobacion(Date fepFechaAprobacion) {
		this.fepFechaAprobacion = fepFechaAprobacion;
	}

	@Column(name = "fepFirmaAutorizacion", length = 45)
	public String getFepFirmaAutorizacion() {
		return this.fepFirmaAutorizacion;
	}

	public void setFepFirmaAutorizacion(String fepFirmaAutorizacion) {
		this.fepFirmaAutorizacion = fepFirmaAutorizacion;
	}

	@Column(name = "fepObservacion", length = 65535)
	public String getFepObservacion() {
		return this.fepObservacion;
	}

	public void setFepObservacion(String fepObservacion) {
		this.fepObservacion = fepObservacion;
	}

}