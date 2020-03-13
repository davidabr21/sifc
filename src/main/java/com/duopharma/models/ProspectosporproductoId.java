package com.duopharma.models;
// Generated 6/02/2020 04:23:00 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProspectosporproductoId implements java.io.Serializable {

	private int ppProductoProId;
	private int ppProspectoPrsId;

	public ProspectosporproductoId() {
	}

	@Column(name = "ppProducto_proId", nullable = false)
	public int getPpProductoProId() {
		return this.ppProductoProId;
	}

	public void setPpProductoProId(int ppProductoProId) {
		this.ppProductoProId = ppProductoProId;
	}

	@Column(name = "ppProspecto_prsId", nullable = false)
	public int getPpProspectoPrsId() {
		return this.ppProspectoPrsId;
	}

	public void setPpProspectoPrsId(int ppProspectoPrsId) {
		this.ppProspectoPrsId = ppProspectoPrsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProspectosporproductoId))
			return false;
		ProspectosporproductoId castOther = (ProspectosporproductoId) other;

		return (this.getPpProductoProId() == castOther.getPpProductoProId())
				&& (this.getPpProspectoPrsId() == castOther.getPpProspectoPrsId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPpProductoProId();
		result = 37 * result + this.getPpProspectoPrsId();
		return result;
	}

}
