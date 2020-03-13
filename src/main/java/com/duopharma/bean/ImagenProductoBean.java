package com.duopharma.bean;

import com.duopharma.dao.ImagenProductoDAO;
import com.duopharma.dao.ProductoDAO;
import com.duopharma.models.Imagenporproducto;
import com.duopharma.models.Producto;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import org.omnifaces.util.Utils;


@ManagedBean(name="imagenproducto")
@ViewScoped
public class ImagenProductoBean {
	private int proId;
	private Imagenporproducto imagen = new Imagenporproducto();
	private Imagenporproducto objetoObtenido = new Imagenporproducto();
	private ImagenProductoDAO dao = new ImagenProductoDAO();
	private ProductoDAO prodao = new ProductoDAO();

    private Part archivoImg;

    public void mostrarImg() throws IOException {
    	this.imagen.setIpImagen(Utils.toByteArray(this.archivoImg.getInputStream()));
    }
    
    public Part getArchivoImg() {
        return archivoImg;
    }

    public void setArchivoImg(Part archivoimg) {
        this.archivoImg = archivoimg;
    }
    
    public Imagenporproducto getImagen() {
		return imagen;
	}

	public void setImagen(Imagenporproducto imagen) {
		this.imagen = imagen;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public Imagenporproducto getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Imagenporproducto objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}

	public void registrar(int idProducto) {
		Producto pro = prodao.obtener(idProducto); 
		imagen.setProducto(pro);
		dao.registrar(imagen);
	}
	
	public void actualizar() {
		dao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		dao.eliminar(objetoObtenido);
	}
	
	public void eliminar(Imagenporproducto ipp) {
		dao.eliminar(ipp);
	}
	
	public void leer(Imagenporproducto obj) {
		this.objetoObtenido = obj;
	} 
	
	
}
