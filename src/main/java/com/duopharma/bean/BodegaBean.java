package com.duopharma.bean;

import com.duopharma.dao.BodegaDAO;
import com.duopharma.models.Bodega;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="bodega")
@ViewScoped
public class BodegaBean {
	
	private Bodega bodega = new Bodega();
	
	private Bodega objetoObtenido = new Bodega();
	private BodegaDAO bodegadao = new BodegaDAO();
	
	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Bodega getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Bodega objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar() {
		System.out.println(bodega.isBoEstado());
		System.out.println(bodega.isBoEstado());
		System.out.println(bodega.isBoEstado());
		System.out.println(bodega.isBoEstado());
		System.out.println(bodega.isBoEstado());
		bodegadao.registrar(bodega);
	}
	
	public List<Bodega> obtenerLista() {
		return bodegadao.obtenerLista();
	}
	
	public void actualizar() {
		bodegadao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		bodegadao.eliminar(objetoObtenido);
	}
	
	public void leer(Bodega prv) {
		this.objetoObtenido = prv;
	} 
}
