package com.duopharma.bean;

import com.duopharma.dao.TipoOperacionDAO;
import com.duopharma.models.Tipooperacion;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean(name="tipoOperacion")
@ViewScoped
public class TipoOperacionBean {
	private Integer toId;
	private String toNombre;
	
	private Tipooperacion objetoObtenido = new Tipooperacion();
	private TipoOperacionDAO tipooperaciondao = new TipoOperacionDAO();
	
	public Tipooperacion getObjetoObtenido() {
		return objetoObtenido;
	}
	public void setObjetoObtenido(Tipooperacion objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}
	
	public Integer getToId() {
		return toId;
	}
	public void setToId(Integer toId) {
		this.toId = toId;
	}
	public String getToNombre() {
		return toNombre;
	}
	public void setToNombre(String toNombre) {
		this.toNombre = toNombre;
	}
	
	public void registrarTipoOperacion() {
		Tipooperacion tipooperacionmodel = new Tipooperacion();
		tipooperacionmodel.setToNombre(this.toNombre);
		tipooperaciondao.registrar(tipooperacionmodel);
	}
	
	public List<Tipooperacion> obtenerLista() {
		TipoOperacionDAO tipooperaciondao = new TipoOperacionDAO();
		return tipooperaciondao.obtenerLista();
	}
	
	public void actualizarTipoOperacion() {
		TipoOperacionDAO tipooperaciondao = new TipoOperacionDAO();
		tipooperaciondao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		TipoOperacionDAO tipooperaciondao = new TipoOperacionDAO();
		tipooperaciondao.eliminar(objetoObtenido);
	}
	
	public void leer(Tipooperacion tipoop) {
		this.objetoObtenido = tipoop;
	}
	
	
	
}
