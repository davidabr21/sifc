package com.duopharma.models;
// Generated 25/02/2020 04:47:30 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MaterialfabricacionproductoId generated by hbm2java
 */
@Embeddable
public class MaterialfabricacionproductoId implements java.io.Serializable {

	private int mpfFichaElaboracionFepId;
	private int mpfLoteMateriaPrimaLmpId;

	public MaterialfabricacionproductoId() {
	}

	public MaterialfabricacionproductoId(int mpfFichaElaboracionFepId, int mpfLoteMateriaPrimaLmpId) {
		this.mpfFichaElaboracionFepId = mpfFichaElaboracionFepId;
		this.mpfLoteMateriaPrimaLmpId = mpfLoteMateriaPrimaLmpId;
	}

	@Column(name = "mpfFichaElaboracion_fepId", nullable = false)
	public int getMpfFichaElaboracionFepId() {
		return this.mpfFichaElaboracionFepId;
	}

	public void setMpfFichaElaboracionFepId(int mpfFichaElaboracionFepId) {
		this.mpfFichaElaboracionFepId = mpfFichaElaboracionFepId;
	}

	@Column(name = "mpfLoteMateriaPrima_lmpId", nullable = false)
	public int getMpfLoteMateriaPrimaLmpId() {
		return this.mpfLoteMateriaPrimaLmpId;
	}

	public void setMpfLoteMateriaPrimaLmpId(int mpfLoteMateriaPrimaLmpId) {
		this.mpfLoteMateriaPrimaLmpId = mpfLoteMateriaPrimaLmpId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MaterialfabricacionproductoId))
			return false;
		MaterialfabricacionproductoId castOther = (MaterialfabricacionproductoId) other;

		return (this.getMpfFichaElaboracionFepId() == castOther.getMpfFichaElaboracionFepId())
				&& (this.getMpfLoteMateriaPrimaLmpId() == castOther.getMpfLoteMateriaPrimaLmpId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMpfFichaElaboracionFepId();
		result = 37 * result + this.getMpfLoteMateriaPrimaLmpId();
		return result;
	}

}
