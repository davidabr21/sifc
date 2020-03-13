package com.duopharma.bean;

import com.duopharma.dao.RolDAO;
import com.duopharma.models.Rol;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="rolb")
@ViewScoped
public class RolBean {
	
	private Integer rolId;
	private String rolNombre;
	private String rolDescripcion;
	
	private Rol objetoObtenido = new Rol();
	private RolDAO roldao = new RolDAO();
	
	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public String getRolDescripcion() {
		return rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public Rol getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Rol objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar() {
		Rol rol = new Rol();
		rol.setRolNombre(rolNombre);
		rol.setRolDescripcion(rolDescripcion);
		roldao.registrar(rol);
	}
	
	public List<Rol> obtenerLista() {
		return roldao.obtenerLista();
	}
	
	public void actualizar() {
		roldao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		roldao.eliminar(objetoObtenido);
	}
	
	public void leer(Rol prv) {
		this.objetoObtenido = prv;
	} 
	
	
}
