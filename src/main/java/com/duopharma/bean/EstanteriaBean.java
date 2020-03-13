package com.duopharma.bean;

import com.duopharma.dao.BodegaDAO;
import com.duopharma.dao.EstanteriaDAO;
import com.duopharma.dao.MateriaprimaDAO;
import com.duopharma.dao.ProductoDAO;
import com.duopharma.graphObjects.PieObjeto;
import com.duopharma.models.Bodega;
import com.duopharma.models.Estanteria;
import com.duopharma.models.Materiaprima;
import com.duopharma.models.Producto;
import com.duopharma.models.Vistaestanteria;
import com.duopharma.models.Vistaestanteriacapacidad;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="estanteria")
@ViewScoped
public class EstanteriaBean {
	
	private Integer boId;
	private Integer proId;
	private Integer mpId;
	
	private Estanteria estanteria = new Estanteria();
	
	private Estanteria objetoObtenido = new Estanteria();
	private EstanteriaDAO estanteriadao = new EstanteriaDAO();
	private ProductoDAO productodao = new ProductoDAO();
	private BodegaDAO bodegadao = new BodegaDAO();
	private MateriaprimaDAO materiadao = new MateriaprimaDAO();
	
	private List<PieObjeto> listadoPie = new ArrayList<PieObjeto>();

	public Integer getBoId() {
		return boId;
	}
	
	public void setBoId(Integer boId) {
		this.boId = boId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}
	
	public Integer getMpId() {
		return mpId;
	}

	public void setMpId(Integer mpId) {
		this.mpId = mpId;
	}

	public Estanteria getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Estanteria objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}
	
	public Estanteria getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(Estanteria estanteria) {
		this.estanteria = estanteria;
	}

	public void registrar() {
		Bodega bodega = bodegadao.obtener(boId);
		estanteria.setBodega(bodega);
		
		if(proId != 0) {
			Producto producto = productodao.obtener(proId);
			estanteria.setProducto(producto);	
		} else if (mpId != 0) {
			Materiaprima materiaprima = materiadao.obtener(mpId);
			estanteria.setMateriaprima(materiaprima);
		}
		
		
		estanteriadao.registrar(estanteria);
	}
	
	public List<Estanteria> obtenerLista() {
		return estanteriadao.obtenerLista();
	}
	
	public List<Vistaestanteriacapacidad> obtenerListaCapacidad() {
		return estanteriadao.obtenerCapacidadLista();
	}
	
	public void actualizar() {
		Bodega bodega = bodegadao.obtener(objetoObtenido.getBodega().getBoId()); 
		this.objetoObtenido.setBodega(bodega);

		
		if(objetoObtenido.getProducto() != null) {
			Producto producto = productodao.obtener(objetoObtenido.getProducto().getProId());
			this.objetoObtenido.setProducto(producto);
		} 
		
		if (objetoObtenido.getMateriaprima() != null) {
			Materiaprima materiaprima = materiadao.obtener(objetoObtenido.getMateriaprima().getMpId());
			this.objetoObtenido.setMateriaprima(materiaprima);
		}
		estanteriadao.actualizar(objetoObtenido);
	}
	
	public List<Estanteria> obtenerListaProductos(){
		return estanteriadao.obtenerListaProductos();
	}
	
	public List<Estanteria> obtenerListaMateriales(){
		return estanteriadao.obtenerListaMateriales();
	}
	
	public void eliminar() {
		estanteriadao.eliminar(objetoObtenido);
	}
	
	public void leer(Estanteria est) {
		this.objetoObtenido = est;
		cargarDataPie();
	}
	
	public List<PieObjeto> getListadoPie() {
		return listadoPie;
	}

	public void setListadoPie(List<PieObjeto> listadoPie) {
		this.listadoPie = listadoPie;
	}

	public void cargarDataPie() {
		listadoPie.add(new PieObjeto("Capacidad Disponible", this.objetoObtenido.getEstCapacidad() - this.objetoObtenido.getEstCapacidadOcupada()));
		listadoPie.add(new PieObjeto("Capacidad Ocupada", this.objetoObtenido.getEstCapacidadOcupada()));
	}
}
