package com.duopharma.models;
// Generated 6/02/2020 04:23:00 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Loteenvase generated by hbm2java
 */
@Entity
@Table(name = "loteenvase", catalog = "sifc_dev")
public class Loteenvase implements java.io.Serializable {

	private Integer lenId;
	private Envase envase;
	private String lenNoLote;
	private Date lenFechaRecepcion;
	private Date lenFechaCaducidad;
	private int lenCantidad;
	private Set<Fichaanaliticamateria> fichaanaliticamaterias = new HashSet<Fichaanaliticamateria>(0);

	public Loteenvase() {
	}

	public Loteenvase(Envase envase, String lenNoLote, Date lenFechaRecepcion, Date lenFechaCaducidad,
			int lenCantidad) {
		this.envase = envase;
		this.lenNoLote = lenNoLote;
		this.lenFechaRecepcion = lenFechaRecepcion;
		this.lenFechaCaducidad = lenFechaCaducidad;
		this.lenCantidad = lenCantidad;
	}

	public Loteenvase(Envase envase, String lenNoLote, Date lenFechaRecepcion, Date lenFechaCaducidad, int lenCantidad,
			Set<Fichaanaliticamateria> fichaanaliticamaterias) {
		this.envase = envase;
		this.lenNoLote = lenNoLote;
		this.lenFechaRecepcion = lenFechaRecepcion;
		this.lenFechaCaducidad = lenFechaCaducidad;
		this.lenCantidad = lenCantidad;
		this.fichaanaliticamaterias = fichaanaliticamaterias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "lenId", unique = true, nullable = false)
	public Integer getLenId() {
		return this.lenId;
	}

	public void setLenId(Integer lenId) {
		this.lenId = lenId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lenEnvase_envId", nullable = false)
	public Envase getEnvase() {
		return this.envase;
	}

	public void setEnvase(Envase envase) {
		this.envase = envase;
	}

	@Column(name = "lenNoLote", nullable = false, length = 45)
	public String getLenNoLote() {
		return this.lenNoLote;
	}

	public void setLenNoLote(String lenNoLote) {
		this.lenNoLote = lenNoLote;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lenFechaRecepcion", nullable = false, length = 10)
	public Date getLenFechaRecepcion() {
		return this.lenFechaRecepcion;
	}

	public void setLenFechaRecepcion(Date lenFechaRecepcion) {
		this.lenFechaRecepcion = lenFechaRecepcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lenFechaCaducidad", nullable = false, length = 10)
	public Date getLenFechaCaducidad() {
		return this.lenFechaCaducidad;
	}

	public void setLenFechaCaducidad(Date lenFechaCaducidad) {
		this.lenFechaCaducidad = lenFechaCaducidad;
	}

	@Column(name = "lenCantidad", nullable = false)
	public int getLenCantidad() {
		return this.lenCantidad;
	}

	public void setLenCantidad(int lenCantidad) {
		this.lenCantidad = lenCantidad;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loteenvase")
	public Set<Fichaanaliticamateria> getFichaanaliticamaterias() {
		return this.fichaanaliticamaterias;
	}

	public void setFichaanaliticamaterias(Set<Fichaanaliticamateria> fichaanaliticamaterias) {
		this.fichaanaliticamaterias = fichaanaliticamaterias;
	}

}
