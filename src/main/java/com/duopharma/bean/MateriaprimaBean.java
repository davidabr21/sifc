package com.duopharma.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.duopharma.dao.MateriaprimaDAO;
import com.duopharma.dao.TipomateriaprimaDAO;
import com.duopharma.dao.UnidadMedidaDAO;
import com.duopharma.models.Materiaprima;
import com.duopharma.models.Formula;
import com.duopharma.models.Tipomateriaprima;
import com.duopharma.models.Unidadmedida;

@ManagedBean(name="materiaprima")
@ViewScoped
public class MateriaprimaBean {
	private int umId;
	private int tmpId;
	
	private Materiaprima Materia = new Materiaprima();
	
	private Materiaprima objetoObtenido = new Materiaprima();
	private MateriaprimaDAO materiaprimadao = new MateriaprimaDAO();
	private UnidadMedidaDAO unidadmedidadao = new UnidadMedidaDAO();
	private TipomateriaprimaDAO tipomateriaprimadao = new TipomateriaprimaDAO();
	
	public Materiaprima getMateria() {
		return Materia;
	}

	public void setMateria(Materiaprima materia) {
		Materia = materia;
	}

	public int getUmId() {
		return umId;
	}

	public void setUmId(int umId) {
		this.umId = umId;
	}

	public int getTmpId() {
		return tmpId;
	}

	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
	}

	public Materiaprima getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Materiaprima objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public MateriaprimaDAO getMateriaprimadao() {
		return materiaprimadao;
	}

	public void setMateriaprimadao(MateriaprimaDAO materiaprimadao) {
		this.materiaprimadao = materiaprimadao;
	}

	public void registrar() {
		Unidadmedida unidadmedida = unidadmedidadao.obtener(umId);
		Materia.setUnidadmedida(unidadmedida);
		
		Tipomateriaprima tipomateriaprima = tipomateriaprimadao.obtener(tmpId);
		Materia.setTipomateriaprima(tipomateriaprima);
		
		long millis = System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis); 
        Materia.setMpUltimaModificacion(date);
		
		materiaprimadao.registrar(Materia);
	}
	
	public List<Materiaprima> obtenerLista() {
		return materiaprimadao.obtenerLista();
	}

	public void actualizar() {
		System.out.println("DASDAD: ");
		System.out.println(objetoObtenido.getUnidadmedida().getUmId());
		System.out.println(objetoObtenido.getTipomateriaprima().getTmpId());
		System.out.println("DASDAD");
		
		Unidadmedida unidadmedida = unidadmedidadao.obtener(objetoObtenido.getUnidadmedida().getUmId());
		objetoObtenido.setUnidadmedida(unidadmedida);
		
		Tipomateriaprima tipomateriaprima = tipomateriaprimadao.obtener(objetoObtenido.getTipomateriaprima().getTmpId());
		objetoObtenido.setTipomateriaprima(tipomateriaprima);
		
		
		
		long millis = System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis); 
        objetoObtenido.setMpUltimaModificacion(date);
		
		materiaprimadao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		materiaprimadao.eliminar(objetoObtenido);
	}
	
	public void leer(Materiaprima mp) {
		this.objetoObtenido = mp;
	}
	
}
