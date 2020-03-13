package com.duopharma.bean;

import com.duopharma.dao.UnidadMedidaDAO;
import com.duopharma.models.Unidadmedida;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="unidadMedida")
@ViewScoped
public class UnidadMedidaBean {
	private Integer umId;
	private String umNombre;
	private String umAbreviacion;
	
	private Unidadmedida objetoObtenido = new Unidadmedida();
	private UnidadMedidaDAO tipooperaciondao = new UnidadMedidaDAO();
	
	public Integer getUmId() {
		return umId;
	}

	public void setUmId(Integer umId) {
		this.umId = umId;
	}

	public String getUmNombre() {
		return umNombre;
	}

	public void setUmNombre(String umNombre) {
		this.umNombre = umNombre;
	}

	public String getUmAbreviacion() {
		return umAbreviacion;
	}

	public void setUmAbreviacion(String umAbreviacion) {
		this.umAbreviacion = umAbreviacion;
	}

	public Unidadmedida getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Unidadmedida objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar() {
		Unidadmedida unidadmedidamodel = new Unidadmedida();
		unidadmedidamodel.setUmAbreviacion(umAbreviacion);
		unidadmedidamodel.setUmNombre(umNombre);
		tipooperaciondao.registrar(unidadmedidamodel);
	}
	
	public List<Unidadmedida> obtenerLista() {
		return tipooperaciondao.obtenerLista();
	}
	
	public void actualizar() {
		tipooperaciondao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		tipooperaciondao.eliminar(objetoObtenido);
	}
	
	public void leer(Unidadmedida unim) {
		this.objetoObtenido = unim;
	}
	
	
	
}
