package com.duopharma.bean;


import com.duopharma.dao.ProspectoDAO;
import com.duopharma.models.Prospecto;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="prospecto")
@ViewScoped
public class ProspectoBean {
	
	private Integer prsId;
	private String prsNombre;
	private String prsDescripcion;
	private String prsTipo;
	
	private Prospecto objetoObtenido = new Prospecto();
	private ProspectoDAO prospectodao = new ProspectoDAO();
	
	public Integer getPrsId() {
		return prsId;
	}
	public void setPrsId(Integer prsId) {
		this.prsId = prsId;
	}
	public String getPrsNombre() {
		return prsNombre;
	}
	public void setPrsNombre(String prsNombre) {
		this.prsNombre = prsNombre;
	}
	public String getPrsDescripcion() {
		return prsDescripcion;
	}
	public void setPrsDescripcion(String prsDescripcion) {
		this.prsDescripcion = prsDescripcion;
	}
	public String getPrsTipo() {
		return prsTipo;
	}
	public void setPrsTipo(String prsTipo) {
		this.prsTipo = prsTipo;
	}
	public Prospecto getObjetoObtenido() {
		return objetoObtenido;
	}
	public void setObjetoObtenido(Prospecto objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	
	public void registrar() {
		Prospecto prospecto = new Prospecto();
		prospecto.setPrsNombre(prsNombre);
		prospecto.setPrsDescripcion(prsDescripcion);
		prospecto.setPrsTipo(prsTipo);
		prospectodao.registrar(prospecto);
	}
	
	public List<Prospecto> obtenerLista(){
		return prospectodao.obtenerLista();
	}
	
	public void actualizar() {
		prospectodao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		prospectodao.eliminar(objetoObtenido);
	}
	
	public void leer(Prospecto prs) {
		this.objetoObtenido = prs;
	}
	
}
