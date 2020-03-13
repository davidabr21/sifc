package com.duopharma.models;
// Generated 25/02/2020 04:47:30 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Materialfabricacionproducto generated by hbm2java
 */
@Entity
@Table(name = "materialfabricacionproducto", catalog = "sifc_dev")
public class Materialfabricacionproducto implements java.io.Serializable {

	private MaterialfabricacionproductoId id;

	public Materialfabricacionproducto() {
	}

	public Materialfabricacionproducto(MaterialfabricacionproductoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "mpfFichaElaboracionFepId", column = @Column(name = "mpfFichaElaboracion_fepId", nullable = false)),
			@AttributeOverride(name = "mpfLoteMateriaPrimaLmpId", column = @Column(name = "mpfLoteMateriaPrima_lmpId", nullable = false)) })
	public MaterialfabricacionproductoId getId() {
		return this.id;
	}

	public void setId(MaterialfabricacionproductoId id) {
		this.id = id;
	}

}