package com.duopharma.models;
// Generated 6/02/2020 04:23:00 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Composicion generated by hbm2java
 */
@Entity
@Table(name = "composicion", catalog = "sifc_dev")
public class Composicion implements java.io.Serializable {

	private ComposicionId id;
	private Formafarmaceutica formafarmaceutica;
	private Materiaprima materiaprima;
	private boolean cmpPrincipioActivo;

	public Composicion() {
	}

	public Composicion(ComposicionId id, Formafarmaceutica formafarmaceutica, Materiaprima materiaprima,
			boolean cmpPrincipioActivo) {
		this.id = id;
		this.formafarmaceutica = formafarmaceutica;
		this.materiaprima = materiaprima;
		this.cmpPrincipioActivo = cmpPrincipioActivo;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "cmpFormaFarmaceuticaProId", column = @Column(name = "cmpFormaFarmaceutica_proId", nullable = false)),
			@AttributeOverride(name = "cmpMateriaPrimaMpId", column = @Column(name = "cmpMateriaPrima_mpId", nullable = false)) })
	public ComposicionId getId() {
		return this.id;
	}

	public void setId(ComposicionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cmpFormaFarmaceutica_proId", nullable = false, insertable = false, updatable = false)
	public Formafarmaceutica getFormafarmaceutica() {
		return this.formafarmaceutica;
	}

	public void setFormafarmaceutica(Formafarmaceutica formafarmaceutica) {
		this.formafarmaceutica = formafarmaceutica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cmpMateriaPrima_mpId", nullable = false, insertable = false, updatable = false)
	public Materiaprima getMateriaprima() {
		return this.materiaprima;
	}

	public void setMateriaprima(Materiaprima materiaprima) {
		this.materiaprima = materiaprima;
	}

	@Column(name = "cmpPrincipioActivo", nullable = false)
	public boolean isCmpPrincipioActivo() {
		return this.cmpPrincipioActivo;
	}

	public void setCmpPrincipioActivo(boolean cmpPrincipioActivo) {
		this.cmpPrincipioActivo = cmpPrincipioActivo;
	}

}
