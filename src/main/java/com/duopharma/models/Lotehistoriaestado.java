package com.duopharma.models;
// Generated 6/02/2020 04:23:00 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Lotehistoriaestado generated by hbm2java
 */
@Entity
@Table(name = "lotehistoriaestado", catalog = "sifc_dev")
public class Lotehistoriaestado implements java.io.Serializable {

	private LotehistoriaestadoId id;
	private Lote lote;
	private Date lheFecha;
	private String lheEstado;

	public Lotehistoriaestado() {
	}

	public Lotehistoriaestado(LotehistoriaestadoId id, Lote lote, Date lheFecha, String lheEstado) {
		this.id = id;
		this.lote = lote;
		this.lheFecha = lheFecha;
		this.lheEstado = lheEstado;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "lheId", column = @Column(name = "lheId", nullable = false)),
			@AttributeOverride(name = "lheLoteLotId", column = @Column(name = "lheLote_lotId", nullable = false)) })
	public LotehistoriaestadoId getId() {
		return this.id;
	}

	public void setId(LotehistoriaestadoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lheLote_lotId", nullable = false, insertable = false, updatable = false)
	public Lote getLote() {
		return this.lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lheFecha", nullable = false, length = 10)
	public Date getLheFecha() {
		return this.lheFecha;
	}

	public void setLheFecha(Date lheFecha) {
		this.lheFecha = lheFecha;
	}

	@Column(name = "lheEstado", nullable = false, length = 45)
	public String getLheEstado() {
		return this.lheEstado;
	}

	public void setLheEstado(String lheEstado) {
		this.lheEstado = lheEstado;
	}

}
