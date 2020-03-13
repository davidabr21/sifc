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

@Entity
@Table(name = "prospectosporproducto", catalog = "sifc_dev")
public class Prospectosporproducto implements java.io.Serializable {

	private ProspectosporproductoId id;
	private Prospecto prospecto;
	private Producto producto;

	public Prospectosporproducto() {
	}

	public Prospectosporproducto(ProspectosporproductoId id, Prospecto prospecto, Producto producto) {
		this.id = id;
		this.prospecto = prospecto;
		this.producto = producto;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "ppProductoProId", column = @Column(name = "ppProducto_proId", nullable = false)),
			@AttributeOverride(name = "ppProspectoPrsId", column = @Column(name = "ppProspecto_prsId", nullable = false)) })
	public ProspectosporproductoId getId() {
		return this.id;
	}

	public void setId(ProspectosporproductoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ppProspecto_prsId", nullable = false, insertable = false, updatable = false)
	public Prospecto getProspecto() {
		return this.prospecto;
	}

	public void setProspecto(Prospecto prospecto) {
		this.prospecto = prospecto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ppProducto_proId", nullable = false, insertable = false, updatable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
