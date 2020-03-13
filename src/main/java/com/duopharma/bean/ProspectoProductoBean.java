package com.duopharma.bean;

import com.duopharma.dao.ProductoDAO;
import com.duopharma.dao.ProspectoDAO;
import com.duopharma.dao.ProspectoProductoDAO;
import com.duopharma.models.Producto;
import com.duopharma.models.Prospecto;
import com.duopharma.models.Prospectosporproducto;
import com.duopharma.models.ProspectosporproductoId;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="prospectoproducto")
@ViewScoped
public class ProspectoProductoBean {
	private int proId;
	private int prsId;
	private Prospectosporproducto prospectoproducto = new Prospectosporproducto();
	private Prospectosporproducto objetoObtenido = new Prospectosporproducto();
	private ProspectoProductoDAO dao = new ProspectoProductoDAO();
	private ProductoDAO prodao = new ProductoDAO();
	private ProspectoDAO prsdao = new ProspectoDAO();	
	
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}
	
	public int getPrsId() {
		return prsId;
	}

	public void setPrsId(int prsId) {
		this.prsId = prsId;
	}
	
	public Prospectosporproducto getProspectoproducto() {
		return prospectoproducto;
	}

	public void setProspectoproducto(Prospectosporproducto prospectoproducto) {
		this.prospectoproducto = prospectoproducto;
	}

	public Prospectosporproducto getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Prospectosporproducto objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar(int idProducto, int idProspecto) {
		Producto pro = prodao.obtener(idProducto); 
		prospectoproducto.setProducto(pro);
		Prospecto prs = prsdao.obtener(idProspecto);
		prospectoproducto.setProspecto(prs);
		dao.registrar(prospectoproducto);
	}
	
	public void registrar(int idProducto) {
		Producto pro = prodao.obtener(idProducto); 
		prospectoproducto.setProducto(pro);
		Prospecto prs = prsdao.obtener(prsId);
		prospectoproducto.setProspecto(prs);
		ProspectosporproductoId id = new ProspectosporproductoId();
		id.setPpProductoProId(idProducto);
		id.setPpProspectoPrsId(prsId);
		prospectoproducto.setId(id);
		dao.registrar(prospectoproducto);
	}
	

	public void eliminar() {
		dao.eliminar(objetoObtenido);
	}
	
	public void eliminar(Prospectosporproducto obj) {
		dao.eliminar(obj);
	}
	
	public void eliminar(int prospectoId, int productoId) {
		Prospectosporproducto model = dao.obtener(prospectoId, productoId);
		dao.eliminar(model);
	}
	
	public void leer(Prospectosporproducto obj) {
		this.objetoObtenido = obj;
	} 
	
	
}
