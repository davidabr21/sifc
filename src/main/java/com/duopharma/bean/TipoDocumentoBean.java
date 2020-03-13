package com.duopharma.bean;

import com.duopharma.dao.TipoDocumentoDAO;
import com.duopharma.models.Tipodocumento;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="tipodoc")
@ViewScoped
public class TipoDocumentoBean {
	
	private Tipodocumento tipodocumento;
	
	private Tipodocumento tipodocObtenido;
	
	private TipoDocumentoDAO tipodocumentodao = new TipoDocumentoDAO();
	
	public Tipodocumento getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	
	public Tipodocumento getTipodocObtenido() {
		return tipodocObtenido;
	}

	public void setTipodocObtenido(Tipodocumento tipodocObtenido) {
		this.tipodocObtenido = tipodocObtenido;
	}

	public void registrar() {
		tipodocumentodao.registrar(tipodocumento);
	}
	
	public List<Tipodocumento> obtenerLista() {
		return tipodocumentodao.obtenerLista();
	}
	
	public void actualizar() {
		tipodocumentodao.actualizar(tipodocObtenido);
	}
	
	public void eliminar() {
		tipodocumentodao.eliminar(tipodocObtenido);
	}
	
	public void leer(Tipodocumento model) {
		this.tipodocObtenido = model;
	} 
	
	
}
