package com.duopharma.bean;

import com.duopharma.dao.TipoProductoDAO;
import com.duopharma.models.Tipoproducto;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean(name="tipoProducto")
@ViewScoped
public class TipoProductoBean {
	private Integer tpId;
	private String tpNombre;
	private String tpDescripcion;
	
	private Tipoproducto objetoObtenido = new Tipoproducto();
	private TipoProductoDAO tipoproductodao = new TipoProductoDAO();
	
	public Integer getTpId() {
		return tpId;
	}

	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}

	public String getTpNombre() {
		return tpNombre;
	}

	public void setTpNombre(String tpNombre) {
		this.tpNombre = tpNombre;
	}

	public String getTpDescripcion() {
		return tpDescripcion;
	}

	public void setTpDescripcion(String tpDescripcion) {
		this.tpDescripcion = tpDescripcion;
	}

	public Tipoproducto getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Tipoproducto objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar() {
		Tipoproducto tipoproductomodel = new Tipoproducto();
		tipoproductomodel.setTpNombre(this.tpNombre);
		tipoproductomodel.setTpDescripcion(tpDescripcion);
		tipoproductodao.registrar(tipoproductomodel);
	}
	
	public List<Tipoproducto> obtenerLista() {
		return tipoproductodao.obtenerLista();
	}
	
	public void actualizar() {
		tipoproductodao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		tipoproductodao.eliminar(objetoObtenido);
	}
	
	public void leer(Tipoproducto tipoop) {
		this.objetoObtenido = tipoop;
	}
	
	
	
}
