package com.duopharma.bean;

import com.duopharma.dao.FormulaDAO;
import com.duopharma.dao.ProductoDAO;
import com.duopharma.dao.TipoProductoDAO;
import com.duopharma.dao.UnidadMedidaDAO;
import com.duopharma.models.Formula;
import com.duopharma.models.Producto;
import com.duopharma.models.Tipoproducto;
import com.duopharma.models.Unidadmedida;
import com.duopharma.models.Vistaproducto;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="producto")
@ViewScoped
public class ProductoBean {
	
	private int proId;
	private String proNombre;
	private int proCantidad;
	private int proContenido;

	private String proDescripcion;
	private int proPrecio;
	
	private Integer umId;
	private Integer tpId;
	private Integer forId;
	
	private Producto objetoObtenido = new Producto();
	private ProductoDAO productodao = new ProductoDAO();
	private UnidadMedidaDAO unidadmedidadao = new UnidadMedidaDAO();
	private TipoProductoDAO tipoproductodao = new TipoProductoDAO();

	
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProNombre() {
		return proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public int getProCantidad() {
		return proCantidad;
	}

	public void setProCantidad(int proCantidad) {
		this.proCantidad = proCantidad;
	}

	public int getProContenido() {
		return proContenido;
	}

	public void setProContenido(int proContenido) {
		this.proContenido = proContenido;
	}

	public Integer getUmId() {
		return umId;
	}

	public void setUmId(Integer umId) {
		this.umId = umId;
	}


	public String getProDescripcion() {
		return proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public int getProPrecio() {
		return proPrecio;
	}

	public void setProPrecio(int proPrecio) {
		this.proPrecio = proPrecio;
	}
	public Integer getTpId() {
		return tpId;
	}

	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}



	public Integer getForId() {
		return forId;
	}

	public void setForId(Integer forId) {
		this.forId = forId;
	}

	public Producto getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Producto objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	
	public void registrar() {
		Producto producto = new Producto();
		producto.setProId(this.proId);
		producto.setProNombre(this.proNombre);
		producto.setProCantidad(this.proCantidad);
		producto.setProContenido(this.proContenido);
		producto.setProDescripcion(this.proDescripcion);
		producto.setProPrecio(this.proPrecio);
				
		Unidadmedida unidadmedida = unidadmedidadao.obtener(umId); 
		producto.setUnidadmedida(unidadmedida);
		
		Tipoproducto tipoproducto = tipoproductodao.obtener(tpId); 
		producto.setTipoproducto(tipoproducto);
		/*
		producto.setUmId(this.umId);
		producto.setTpId(this.tpId);
		producto.setForId(this.forId);
		*/
		productodao.registrar(producto);
	}
	
	public List<Vistaproducto> obtenerLista() {
		return productodao.obtenerLista();
	}
	
	public List<Producto> obtenerListaProductos() {
		return productodao.obtenerListaProductos();
	}
	
	public List<Producto> obtenerListaTopProductos() {
		return productodao.obtenerListaTopProductos();
	}
	
	public Producto obtenerProducto(int idProducto) {
		return productodao.obtener(idProducto);
	}
	
	public void obtenerProdCart() {
		objetoObtenido = productodao.obtener(this.objetoObtenido.getProId());
	}
	
	public List<Producto> obtenerListaCantidad() {
		return productodao.obtenerListaCantidad();
	}
	
	public void actualizar() {
		Unidadmedida unidadmedida = unidadmedidadao.obtener(objetoObtenido.getUmId()); 
		this.objetoObtenido.setUnidadmedida(unidadmedida);
		Tipoproducto tipoproducto = tipoproductodao.obtener(objetoObtenido.getTpId());
		this.objetoObtenido.setTipoproducto(tipoproducto);

		productodao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		productodao.eliminar(objetoObtenido);
	}
	
	public void leer(Vistaproducto pro) {
		this.objetoObtenido.setProId(pro.getProId());
		this.objetoObtenido.setProNombre(pro.getProNombre());
		this.objetoObtenido.setProCantidad(pro.getProCantidad());
		this.objetoObtenido.setProContenido(pro.getProContenido());
		this.objetoObtenido.setProDescripcion(pro.getProDescripcion());
		this.objetoObtenido.setProPrecio(pro.getProPrecio());
		
		/*Unidadmedida unidadmedida = unidadmedidadao.obtener(pro.getUmId()); 
		this.objetoObtenido.setUnidadmedida(unidadmedida);
		
		Tipoproducto tipoproducto = tipoproductodao.obtener(pro.getTpId()); 
		this.objetoObtenido.setTipoproducto(tipoproducto);
		
		Formula formula = formuladao.obtener(pro.getForId()); 
		this.objetoObtenido.setFormula(formula);*/
		
		this.objetoObtenido.setTpId(pro.getTpId());
		this.objetoObtenido.setUmId(pro.getUmId());
	} 
}
