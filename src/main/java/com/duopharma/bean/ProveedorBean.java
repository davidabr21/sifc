package com.duopharma.bean;

import com.duopharma.dao.ProveedorDAO;
import com.duopharma.models.Materiaprima;
import com.duopharma.models.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transaction;

import  java.io.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Hibernate;
import  org.apache.poi.hssf.usermodel.HSSFRow;

@ManagedBean(name="proveedor")
@ViewScoped
public class ProveedorBean {
	
	private Integer prvId;
	private String prvNombre;
	private String prvDireccion;
	private long prvNumeroContacto;
	private String prvCorreo;
	private String prvDescripcion;
	private boolean prvEstado;
	
	private Proveedor objetoObtenido = new Proveedor();
	private ProveedorDAO proveedordao = new ProveedorDAO();
	
	public Integer getPrvId() {
		return prvId;
	}

	public void setPrvId(Integer prvId) {
		this.prvId = prvId;
	}

	public String getPrvNombre() {
		return prvNombre;
	}

	public void setPrvNombre(String prvNombre) {
		this.prvNombre = prvNombre;
	}

	public String getPrvDireccion() {
		return prvDireccion;
	}

	public void setPrvDireccion(String prvDireccion) {
		this.prvDireccion = prvDireccion;
	}

	public long getPrvNumeroContacto() {
		return prvNumeroContacto;
	}

	public void setPrvNumeroContacto(long prvNumeroContacto) {
		this.prvNumeroContacto = prvNumeroContacto;
	}

	public String getPrvCorreo() {
		return prvCorreo;
	}

	public void setPrvCorreo(String prvCorreo) {
		this.prvCorreo = prvCorreo;
	}

	public String getPrvDescripcion() {
		return prvDescripcion;
	}

	public void setPrvDescripcion(String prvDescripcion) {
		this.prvDescripcion = prvDescripcion;
	}

	public boolean isPrvEstado() {
		return prvEstado;
	}

	public void setPrvEstado(boolean prvEstado) {
		this.prvEstado = prvEstado;
	}

	public Proveedor getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Proveedor objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar() {
		Proveedor proveedor = new Proveedor();
		proveedor.setPrvNombre(prvNombre);
		proveedor.setPrvDireccion(prvDireccion);
		proveedor.setPrvNumeroContacto(prvNumeroContacto);
		proveedor.setPrvCorreo(prvCorreo);
		proveedor.setPrvDescripcion(prvDescripcion);
		proveedor.setPrvEstado(prvEstado);
		proveedordao.registrar(proveedor);
	}
	
	public List<Proveedor> obtenerLista() {
		return proveedordao.obtenerLista();
	}
	
	/*public List<Materiaprima> obtenerListaMateria() {
		Set<Materiaprima> s = this.getObjetoObtenido().getMateriaprimas(); 
		Hibernate.initialize(s);
		List<Materiaprima> materia = s.stream().collect(Collectors.toList()); 
		for(Materiaprima mat: materia){
			System.out.println(mat.getMpNombre());
		}
		return materia;
	}*/
	
	public List<String> obtenerListaMateria() {
		List<String> material = new ArrayList<String>();
		for(Materiaprima materia: this.objetoObtenido.getMateriaprimas()) {
			material.add(materia.getMpNombre());
		}
		return material;
	}
	
	
	public void actualizar() {
		proveedordao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		proveedordao.eliminar(objetoObtenido);
	}
	
	public void leer(Proveedor prv) {
		this.objetoObtenido = prv;
	} 
	public List<String> getCorreos() {
		return proveedordao.obtenerListaCorreos();
	}
	
	public void exportToExcel(List<Proveedor> proveedorList) {
        try {
        	String nombreArchivo = "C:\\Users\\User\\Desktop\\arhivito.xls";

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");  

            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("prvId");
            rowhead.createCell(1).setCellValue("prvNombre");
            rowhead.createCell(2).setCellValue("prvDireccion");
            rowhead.createCell(3).setCellValue("prvNumeroContacto");
            rowhead.createCell(4).setCellValue("prvCorreo");
            rowhead.createCell(5).setCellValue("prvDescripcion");
            rowhead.createCell(6).setCellValue("prvEstado");
            HSSFRow row;
            int contador = 1;
            for(Proveedor proveedor : proveedorList)
            {
                row = sheet.createRow((short)contador);
                row.createCell(0).setCellValue(proveedor.getPrvId());
                row.createCell(1).setCellValue(proveedor.getPrvNombre());
                row.createCell(2).setCellValue(proveedor.getPrvDireccion());
                row.createCell(3).setCellValue(proveedor.getPrvNumeroContacto());
                row.createCell(4).setCellValue(proveedor.getPrvCorreo());
                row.createCell(5).setCellValue(proveedor.getPrvDescripcion());
                row.createCell(6).setCellValue(proveedor.isPrvEstado());
                contador++;
            }

            FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
	}
	
}
