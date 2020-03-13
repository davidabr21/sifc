package com.duopharma.models;
// Generated 8/10/2019 09:13:20 AM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VistaproductoId generated by hbm2java
 */
@Entity
public class Vistaproducto implements java.io.Serializable {

	private int proId;
	private String proNombre;
	private int proCantidad;
	private int proContenido;
	private Integer umId;
	private String umNombre;
	private String proDescripcion;
	private int proPrecio;
	private Integer tpId;
	private String tpNombre;

	public Vistaproducto() {
	}

	public Vistaproducto(int proId, String proNombre, int proCantidad, int proContenido, int proPrecio) {
		this.proId = proId;
		this.proNombre = proNombre;
		this.proCantidad = proCantidad;
		this.proContenido = proContenido;
		this.proPrecio = proPrecio;
	}

	public Vistaproducto(int proId, String proNombre, int proCantidad, int proContenido, Integer umId,
			String umNombre, String proDescripcion, int proPrecio, Integer tpId, String tpNombre, Integer forId,
			String forNombre) {
		this.proId = proId;
		this.proNombre = proNombre;
		this.proCantidad = proCantidad;
		this.proContenido = proContenido;
		this.umId = umId;
		this.umNombre = umNombre;
		this.proDescripcion = proDescripcion;
		this.proPrecio = proPrecio;
		this.tpId = tpId;
		this.tpNombre = tpNombre;
	}
	
	@Id
	@Column(name = "proId", nullable = false)
	public int getProId() {
		return this.proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	@Column(name = "proNombre", nullable = false, length = 45)
	public String getProNombre() {
		return this.proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	@Column(name = "proCantidad", nullable = false)
	public int getProCantidad() {
		return this.proCantidad;
	}

	public void setProCantidad(int proCantidad) {
		this.proCantidad = proCantidad;
	}

	@Column(name = "proContenido", nullable = false)
	public int getProContenido() {
		return this.proContenido;
	}

	public void setProContenido(int proContenido) {
		this.proContenido = proContenido;
	}

	@Column(name = "umId")
	public Integer getUmId() {
		return this.umId;
	}

	public void setUmId(Integer umId) {
		this.umId = umId;
	}

	@Column(name = "umNombre", length = 50)
	public String getUmNombre() {
		return this.umNombre;
	}

	public void setUmNombre(String umNombre) {
		this.umNombre = umNombre;
	}

	@Column(name = "proDescripcion", length = 65535)
	public String getProDescripcion() {
		return this.proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	@Column(name = "proPrecio", nullable = false)
	public int getProPrecio() {
		return this.proPrecio;
	}

	public void setProPrecio(int proPrecio) {
		this.proPrecio = proPrecio;
	}

	@Column(name = "tpId")
	public Integer getTpId() {
		return this.tpId;
	}

	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}

	@Column(name = "tpNombre", length = 45)
	public String getTpNombre() {
		return this.tpNombre;
	}

	public void setTpNombre(String tpNombre) {
		this.tpNombre = tpNombre;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Vistaproducto))
			return false;
		Vistaproducto castOther = (Vistaproducto) other;

		return (this.getProId() == castOther.getProId())
				&& ((this.getProNombre() == castOther.getProNombre()) || (this.getProNombre() != null
						&& castOther.getProNombre() != null && this.getProNombre().equals(castOther.getProNombre())))
				&& (this.getProCantidad() == castOther.getProCantidad())
				&& (this.getProContenido() == castOther.getProContenido())
				&& ((this.getUmId() == castOther.getUmId()) || (this.getUmId() != null && castOther.getUmId() != null
						&& this.getUmId().equals(castOther.getUmId())))
				&& ((this.getUmNombre() == castOther.getUmNombre()) || (this.getUmNombre() != null
						&& castOther.getUmNombre() != null && this.getUmNombre().equals(castOther.getUmNombre())))
				&& ((this.getProDescripcion() == castOther.getProDescripcion())
						|| (this.getProDescripcion() != null && castOther.getProDescripcion() != null
								&& this.getProDescripcion().equals(castOther.getProDescripcion())))
				&& (this.getProPrecio() == castOther.getProPrecio())
				&& ((this.getTpId() == castOther.getTpId()) || (this.getTpId() != null && castOther.getTpId() != null
						&& this.getTpId().equals(castOther.getTpId())))
				&& ((this.getTpNombre() == castOther.getTpNombre()) || (this.getTpNombre() != null
						&& castOther.getTpNombre() != null && this.getTpNombre().equals(castOther.getTpNombre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProId();
		result = 37 * result + (getProNombre() == null ? 0 : this.getProNombre().hashCode());
		result = 37 * result + this.getProCantidad();
		result = 37 * result + this.getProContenido();
		result = 37 * result + (getUmId() == null ? 0 : this.getUmId().hashCode());
		result = 37 * result + (getUmNombre() == null ? 0 : this.getUmNombre().hashCode());
		result = 37 * result + (getProDescripcion() == null ? 0 : this.getProDescripcion().hashCode());
		result = 37 * result + this.getProPrecio();
		result = 37 * result + (getTpId() == null ? 0 : this.getTpId().hashCode());
		result = 37 * result + (getTpNombre() == null ? 0 : this.getTpNombre().hashCode());
		return result;
	}

}
