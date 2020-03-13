package com.duopharma.bean;

import com.duopharma.dao.FormulaDAO;
import com.duopharma.models.Formula;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="formula")
@ViewScoped
public class FormulaBean {
	private Integer forId;
	private String forNombre;
	private String forDescripcion;
	
	private Formula objetoObtenido = new Formula();
	private FormulaDAO formuladao = new FormulaDAO();
	
	public Integer getForId() {
		return forId;
	}

	public void setForId(Integer forId) {
		this.forId = forId;
	}

	public String getForNombre() {
		return forNombre;
	}

	public void setForNombre(String forNombre) {
		this.forNombre = forNombre;
	}

	public String getForDescripcion() {
		return forDescripcion;
	}

	public void setForDescripcion(String forDescripcion) {
		this.forDescripcion = forDescripcion;
	}

	public Formula getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Formula objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar() {
		Formula formulamodel = new Formula();
		formulamodel.setForNombre(forNombre);
		formulamodel.setForDescripcion(forDescripcion);
		formuladao.registrar(formulamodel);
	}
	
	public List<Formula> obtenerLista() {
		return formuladao.obtenerLista();
	}
	
	public void actualizar() {
		formuladao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		formuladao.eliminar(objetoObtenido);
	}
	
	public void leer(Formula form) {
		this.objetoObtenido = form;
	}
	
	
	
}
