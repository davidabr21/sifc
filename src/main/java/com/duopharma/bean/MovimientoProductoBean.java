package com.duopharma.bean;

import com.duopharma.dao.MovimientoProductoDAO;
import com.duopharma.dao.ProductoDAO;
import com.duopharma.dao.TipoOperacionDAO;
import com.duopharma.dao.TipoProductoDAO;
import com.duopharma.dao.UnidadMedidaDAO;
import com.duopharma.dao.UsuarioDAO;
import com.duopharma.models.Movimientomateria;
import com.duopharma.models.Movimientoproducto;
import com.duopharma.models.Producto;
import com.duopharma.models.Tipooperacion;
import com.duopharma.models.Usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="movimientop")
@ViewScoped
public class MovimientoProductoBean {
	
	private Movimientoproducto movimientoproducto;
	
	private Movimientoproducto movimientoObtenido;
	
	private MovimientoProductoDAO movimientoproductodao = new MovimientoProductoDAO();
	
	private Integer usId;
	private Integer toId;
	private Integer proId;
	
	private UsuarioDAO usuariodao = new UsuarioDAO();
	private TipoOperacionDAO tipoperaciondao = new TipoOperacionDAO();
	private ProductoDAO productodao = new ProductoDAO();

	public Integer getUsId() {
		return usId;
	}

	public void setUsId(Integer usId) {
		this.usId = usId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Movimientoproducto getMovimientoproducto() {
		return movimientoproducto;
	}

	public void setMovimientoproducto(Movimientoproducto movimientoproducto) {
		this.movimientoproducto = movimientoproducto;
	}
	
	public Movimientoproducto getMovimientoObtenido() {
		return movimientoObtenido;
	}

	public void setMovimientoObtenido(Movimientoproducto movimientoObtenido) {
		this.movimientoObtenido = movimientoObtenido;
	}

	public void registrar() {
		Usuario usuario = usuariodao.obtener(usId);
		movimientoproducto.setUsuario(usuario);
		
		Tipooperacion to = tipoperaciondao.obtener(toId);
		movimientoproducto.setTipooperacion(to);
		
		Producto producto = productodao.obtener(proId);
		movimientoproducto.setProducto(producto);
		
		movimientoproductodao.registrar(movimientoproducto);
	}
	
	public List<Movimientoproducto> obtenerLista() {
		return movimientoproductodao.obtenerLista();
	}
	
	public void actualizar() {
		Usuario usuario = usuariodao.obtener(movimientoObtenido.getUsuario().getUsId());
		movimientoObtenido.setUsuario(usuario);
		
		Tipooperacion to = tipoperaciondao.obtener(movimientoObtenido.getTipooperacion().getToId());
		movimientoObtenido.setTipooperacion(to);
		
		Producto producto = productodao.obtener(movimientoObtenido.getProducto().getProId());
		movimientoObtenido.setProducto(producto);
		
		movimientoproductodao.actualizar(movimientoObtenido);
	}
	
	public void eliminar() {
		movimientoproductodao.eliminar(movimientoObtenido);
	}
	
	public void leer(Movimientoproducto model) {
		this.movimientoObtenido = model;
	} 
	
	
}
