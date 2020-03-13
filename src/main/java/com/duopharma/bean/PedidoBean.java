package com.duopharma.bean;

import com.duopharma.dao.MovimientoProductoDAO;
import com.duopharma.dao.PedidoDAO;
import com.duopharma.dao.ProductoDAO;
import com.duopharma.dao.ProductosPedidoDAO;
import com.duopharma.dao.TipoOperacionDAO;
import com.duopharma.dao.UsuarioDAO;
import com.duopharma.models.Movimientomateria;
import com.duopharma.models.Movimientoproducto;
import com.duopharma.models.Pedido;
import com.duopharma.models.Producto;
import com.duopharma.models.Productosporpedido;
import com.duopharma.models.ProductosporpedidoId;
import com.duopharma.models.Tipooperacion;
import com.duopharma.models.Usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="pedido")
@ViewScoped
public class PedidoBean {
	
	private Pedido pedido = new Pedido();
	
	private Pedido objetoObtenido;
	
	private Productosporpedido productoObtenido = new Productosporpedido();
	
	private PedidoDAO Pedidodao = new PedidoDAO();
	private ProductoDAO productodao = new ProductoDAO();
	private UsuarioDAO usuariodao = new UsuarioDAO();
	private ProductosPedidoDAO productospedidodao = new ProductosPedidoDAO();

	private Integer clienteId;
	private Integer peId;
	
	private String estado;
	
	private MovimientoProductoDAO movimientodao = new MovimientoProductoDAO();
	private TipoOperacionDAO tipooperaciondao = new TipoOperacionDAO(); 
	
	private int peCantidad;
	
	private List<Pedido> listaPedidos;
	
	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Pedido objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Productosporpedido getProductoObtenido() {
		return productoObtenido;
	}

	public void setProductoObtenido(Productosporpedido productoObtenido) {
		this.productoObtenido = productoObtenido;
	}

	public Integer getPeId() {
		return peId;
	}

	public void setPeId(Integer peId) {
		this.peId = peId;
	}
	
	public int getPeCantidad() {
		return peCantidad;
	}

	public void setPeCantidad(int peCantidad) {
		this.peCantidad = peCantidad;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public void registrar(Integer proId) {
		List<Pedido> pedidos = null;
		
		pedidos = Pedidodao.obtenerEnSeleccion(clienteId);
		
		if(!pedidos.isEmpty()) {
			ProductosporpedidoId id = new ProductosporpedidoId(pedidos.get(0).getPedId(), proId);
			Producto producto = productodao.obtener(proId);
			
			Productosporpedido prodpedido = new Productosporpedido(id, pedidos.get(0), producto, this.peCantidad);
			productospedidodao.registrar(prodpedido);
		} else {
			Usuario usuarioByPedClienteCliId = usuariodao.obtener(clienteId);
			pedido.setUsuarioByPedClienteCliId(usuarioByPedClienteCliId);
			
			long millis=System.currentTimeMillis();  
	        java.sql.Date date = new java.sql.Date(millis); 
	        pedido.setPedFechaInicial(date);
	        
	        pedido.setPedEstado("En Seleccion");
			
			Pedidodao.registrar(pedido);
			registrar(proId);
		}
	}
	
	public List<Pedido> obtenerLista() {
		return Pedidodao.obtenerLista();
	}
	
	public void actualizarLista() {
		this.listaPedidos = Pedidodao.obtenerLista();
	}
	
	public List<Pedido> obtenerEnSeleccion(){
		return Pedidodao.obtenerEnSeleccion(clienteId);
	}
	
	public List<Pedido> obtenerSeleccionados(){
		return Pedidodao.obtenerSeleccionados();
	}
	
	public List<Pedido> obtenerPorCliente(){
		return Pedidodao.obtenerPorCliente(clienteId);
	}
	
	public List<Pedido> obtenerPorEstado(){
		return Pedidodao.obtenerPorEstado(estado);
	}
	
	public List<Pedido> obtenerPorEstado(String est){
		return Pedidodao.obtenerPorEstado(est);
	}
	
	public void actualizarPorEstado(){
		this.listaPedidos = Pedidodao.obtenerPorEstado(estado);
	}
	
	public void actualizarPorEstado(String est){
		this.listaPedidos = Pedidodao.obtenerPorEstado(est);
	}
	
	public void actualizar() {
		Pedidodao.actualizar(objetoObtenido);
	}
	
	public void actualizarEstado() {
		List<Pedido> pedidos = Pedidodao.obtenerPorCliente(clienteId);
		Pedido ped = pedidos.get(0);
		ped.setPedEstado("Solicitado");
		Pedidodao.actualizar(ped);
	}
	
	public void actualizarPorEstados(String estado, Pedido p) {
		if (estado.equals("Cancelado")) {
			Usuario usuarioAutorizador = usuariodao.obtener(clienteId);
			p.setUsuarioByPedAutorizador(usuarioAutorizador);
			long millis=System.currentTimeMillis();  
	        java.sql.Date date = new java.sql.Date(millis); 
	        p.setPedFechaConclusion(date);
		}
		p.setPedEstado(estado);
		Pedidodao.actualizar(p);
	}
	
	public void actualizarPorEstados(Pedido p) {
		long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis); 
		if(estado.equals("Terminado")) {
			Usuario usuarioAutorizador = usuariodao.obtener(clienteId);
			p.setUsuarioByPedAutorizador(usuarioAutorizador);
	        p.setPedFechaConclusion(date);
	        
	        for(Productosporpedido pp : p.getProductosporpedidos()) {
		        Movimientoproducto mp = new Movimientoproducto();
		        mp.setMpFecha(date);
		        Producto prod = productodao.obtener(pp.getId().getPrpProductoProId());
		        mp.setProducto(prod);
		        
		        List<Tipooperacion> tpList = tipooperaciondao.obtenerPorNombre("Entrega");
		        Tipooperacion tp = tpList.get(0);
		        mp.setTipooperacion(tp);
		        
		        Usuario us = usuariodao.obtener(clienteId);
		        mp.setUsuario(us);
		        
		        mp.setMpCantidad(pp.getPrpCantidad());
		        
		        movimientodao.registrar(mp);
	        }
		} else if(estado.equals("Cancelado")) {
			Usuario usuarioAutorizador = usuariodao.obtener(clienteId);
			p.setUsuarioByPedAutorizador(usuarioAutorizador);
	        p.setPedFechaConclusion(date);
		}
		p.setPedEstado(estado);
		Pedidodao.actualizar(p);
	}
	
	public void eliminar() {
		Pedidodao.eliminar(objetoObtenido);
	}
	
	public void eliminarProducto() {
		productospedidodao.eliminar(productoObtenido);
	}
	
	public void leer(Pedido model) {
		this.objetoObtenido = model;
	} 
	
	public void leerProducto(Productosporpedido model) {
		this.productoObtenido = model;
	} 
	
	public void obtenerUsuario(int idUsuario) {
		Integer iInteger = new Integer(idUsuario);
		this.clienteId = iInteger;
	}
}
