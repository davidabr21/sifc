package com.duopharma.bean;

import com.duopharma.dao.LoteDAO;
import com.duopharma.models.Lote;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="lote")
@ViewScoped
public class LoteBean {
	
	private Lote lote;
	
	private Lote objetoObtenido;
	
	private LoteDAO lotedao = new LoteDAO();
	
	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Lote getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Lote objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar() {
		lotedao.registrar(lote);
	}
	
	public List<Lote> obtenerLista() {
		return lotedao.obtenerLista();
	}
	
	public void actualizar() {
		lotedao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		lotedao.eliminar(objetoObtenido);
	}
	
	public void leer(Lote model) {
		this.objetoObtenido = model;
	} 
	
	
}
