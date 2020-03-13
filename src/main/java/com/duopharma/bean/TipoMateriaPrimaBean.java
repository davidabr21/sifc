package com.duopharma.bean;

import com.duopharma.dao.TipoDocumentoDAO;
import com.duopharma.dao.TipomateriaprimaDAO;
import com.duopharma.models.Tipodocumento;
import com.duopharma.models.Tipomateriaprima;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="tipomateria")
@ViewScoped
public class TipoMateriaPrimaBean {
	
	private Tipomateriaprima tipomateria;
	private Tipomateriaprima tipomateriaObtenida;
	private TipomateriaprimaDAO tipomateriadao = new TipomateriaprimaDAO();

	public Tipomateriaprima getTipomateria() {
		return tipomateria;
	}

	public void setTipomateria(Tipomateriaprima tipomateria) {
		this.tipomateria = tipomateria;
	}

	public Tipomateriaprima getTipomateriaObtenida() {
		return tipomateriaObtenida;
	}

	public void setTipomateriaObtenida(Tipomateriaprima tipomateriaObtenida) {
		this.tipomateriaObtenida = tipomateriaObtenida;
	}

	public void registrar() {
		tipomateriadao.registrar(tipomateria);
	}
	
	public List<Tipomateriaprima> obtenerLista() {
		return tipomateriadao.obtenerLista();
	}
	
	public void actualizar() {
		tipomateriadao.actualizar(tipomateriaObtenida);
	}
	
	public void eliminar() {
		tipomateriadao.eliminar(tipomateriaObtenida);
	}
	
	public void leer(Tipomateriaprima model) {
		this.tipomateriaObtenida = model;
	} 
}
