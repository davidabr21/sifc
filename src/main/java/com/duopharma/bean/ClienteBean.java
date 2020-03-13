package com.duopharma.bean;

import com.duopharma.dao.BodegaDAO;
import com.duopharma.dao.RolDAO;
import com.duopharma.dao.TipoDocumentoDAO;
import com.duopharma.dao.UsuarioDAO;
import com.duopharma.models.Bodega;
import com.duopharma.models.Rol;
import com.duopharma.models.Tipodocumento;
import com.duopharma.models.Usuario;
import com.duopharma.models.Vistausuario;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.omnifaces.util.Utils;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@ManagedBean(name="cliente")
@ViewScoped
public class ClienteBean {
	
	private int usId;
	private String usNombreDeUsuario;
	private String usClave;
	private String usCorreo;
	private String usNombres;
	private String usApellidos;
	private String usModificador;
	private Date usFechaCreacion;
	private Date usUltimaActualizacion;
	private String usActualizador;
	private byte[] usImagen;
	private String usEstado;
	private String usDireccion;
	private String rolNombre;
	private String boDireccion;
	private String tdNombre;
	private int usTelefono;
	private String usDocumento;
	
	private Integer rolId;
	private Integer tdId;
	private Integer usuarioCreadorId;
	
	private Usuario objetoObtenido = new Usuario();
	private UsuarioDAO usuariodao = new UsuarioDAO();
	private RolDAO roldao = new RolDAO();
	private TipoDocumentoDAO tipodocumentodao = new TipoDocumentoDAO();
	
	private Usuario usuarioLogeado;
	
    private Part archivoImg;

    public void mostrarImg() throws IOException {
    	usImagen = Utils.toByteArray(this.archivoImg.getInputStream());
    }
    
    public void mostrarImgE() throws IOException {
    	this.objetoObtenido.setUsImagen(Utils.toByteArray(this.archivoImg.getInputStream()));
    }
    
    public Part getArchivoImg() {
        return archivoImg;
    }

    public void setArchivoImg(Part archivoimg) {
        this.archivoImg = archivoimg;
    }	
	
	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	public int getUsId() {
		return usId;
	}

	public void setUsId(int usId) {
		this.usId = usId;
	}

	public String getUsNombreDeUsuario() {
		return usNombreDeUsuario;
	}

	public void setUsNombreDeUsuario(String usNombreDeUsuario) {
		this.usNombreDeUsuario = usNombreDeUsuario;
	}

	public String getUsClave() {
		return usClave;
	}

	public void setUsClave(String usClave) {
		this.usClave = usClave;
	}

	public String getUsCorreo() {
		return usCorreo;
	}

	public void setUsCorreo(String usCorreo) {
		this.usCorreo = usCorreo;
	}

	public String getUsNombres() {
		return usNombres;
	}

	public void setUsNombres(String usNombres) {
		this.usNombres = usNombres;
	}

	public String getUsApellidos() {
		return usApellidos;
	}

	public void setUsApellidos(String usApellidos) {
		this.usApellidos = usApellidos;
	}

	public String getUsModificador() {
		return usModificador;
	}

	public void setUsModificador(String usModificador) {
		this.usModificador = usModificador;
	}

	public Date getUsFechaCreacion() {
		return usFechaCreacion;
	}

	public void setUsFechaCreacion(Date usFechaCreacion) {
		this.usFechaCreacion = usFechaCreacion;
	}

	public Date getUsUltimaActualizacion() {
		return usUltimaActualizacion;
	}

	public void setUsUltimaActualizacion(Date usUltimaActualizacion) {
		this.usUltimaActualizacion = usUltimaActualizacion;
	}

	public String getUsActualizador() {
		return usActualizador;
	}

	public void setUsActualizador(String usActualizador) {
		this.usActualizador = usActualizador;
	}

	public byte[] getUsImagen() {
		return usImagen;
	}

	public void setUsImagen(byte[] usImagen) {
		this.usImagen = usImagen;
	}

	public String getUsEstado() {
		return usEstado;
	}

	public void setUsEstado(String usEstado) {
		this.usEstado = usEstado;
	}

	public String getUsDireccion() {
		return usDireccion;
	}

	public void setUsDireccion(String usDireccion) {
		this.usDireccion = usDireccion;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public String getBoDireccion() {
		return boDireccion;
	}

	public void setBoDireccion(String boDireccion) {
		this.boDireccion = boDireccion;
	}

	public String getTdNombre() {
		return tdNombre;
	}

	public void setTdNombre(String tdNombre) {
		this.tdNombre = tdNombre;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public Integer getTdId() {
		return tdId;
	}

	public void setTdId(Integer tdId) {
		this.tdId = tdId;
	}

	public Usuario getObjetoObtenido() {
		return objetoObtenido;
	}

	public void setObjetoObtenido(Usuario objetoObtenido) {
		this.objetoObtenido = objetoObtenido;
	}
	
	public Integer getUsuarioCreadorId() {
		return usuarioCreadorId;
	}

	public void setUsuarioCreadorId(Integer usuarioCreadorId) {
		this.usuarioCreadorId = usuarioCreadorId;
	}

	public int getUsTelefono() {
		return usTelefono;
	}

	public void setUsTelefono(int usTelefono) {
		this.usTelefono = usTelefono;
	}

	public String getUsDocumento() {
		return usDocumento;
	}

	public void setUsDocumento(String usDocumento) {
		this.usDocumento = usDocumento;
	}

	public void registrar() {
		Usuario usuario = new Usuario();
		usuario.setUsNombreDeUsuario(usNombreDeUsuario);
		usuario.setUsClave(getMD5(usClave));
		usuario.setUsCorreo(usCorreo);
		usuario.setUsNombres(usNombres);
		usuario.setUsApellidos(usApellidos);
		usuario.setUsEstado("Activo");
		usuario.setUsDireccion(usDireccion);
		usuario.setUsTelefono(usTelefono);
		usuario.setUsDocumento(usDocumento);
		
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
        usFechaCreacion = date;
        usUltimaActualizacion = date;
		usuario.setUsFechaCreacion(usFechaCreacion);
		usuario.setUsUltimaActualizacion(usUltimaActualizacion);
		
		if(this.usImagen != null) {
			usuario.setUsImagen(this.usImagen);
		}
		
		Rol rol = roldao.obtener(4); // Hacer en el futuro un get por nombre que traiga el rol cliente y no que lo queme por código.
		usuario.setRol(rol);
		
		Tipodocumento td = tipodocumentodao.obtener(tdId);
		usuario.setTipodocumento(td);

		usuariodao.registrar(usuario);
	}
	
	public void obtenerUsuario(int idUsuario) {
		this.usuarioLogeado = usuariodao.obtener(idUsuario);
		Integer iInteger = new Integer(idUsuario);
		this.usuarioCreadorId = iInteger;
	}
	
	public List<Vistausuario> obtenerLista() {
		return usuariodao.obtenerLista();
	}
	
	public void actualizar() throws IOException {
		Rol rol = roldao.obtener(objetoObtenido.getRol().getRolId());
		this.objetoObtenido.setRol(rol);
		
		Tipodocumento tipodocumento = tipodocumentodao.obtener(objetoObtenido.getTipodocumento().getTdId());
		this.objetoObtenido.setTipodocumento(tipodocumento);
		
		this.objetoObtenido.setUsImagen(Utils.toByteArray(this.archivoImg.getInputStream()));
		
		usuariodao.actualizar(objetoObtenido);
	}
	
	public void eliminar() {
		usuariodao.eliminar(objetoObtenido);
	}
	
	public String getMD5(String input) {
		 try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] messageDigest = md.digest(input.getBytes());
		 BigInteger number = new BigInteger(1, messageDigest);
		 String hashtext = number.toString(16);

		 while (hashtext.length() < 32) {
		 hashtext = "0" + hashtext;
		 }
		 return hashtext;
		 }
		 catch (NoSuchAlgorithmException e) {
		 throw new RuntimeException(e);
		 }
	}
	
	public void leer(Vistausuario usu) {
		objetoObtenido.setUsId(usu.getUsId());
		objetoObtenido.setUsNombreDeUsuario(usu.getUsNombreDeUsuario());
		objetoObtenido.setUsClave(usu.getUsClave());
		objetoObtenido.setUsCorreo(usu.getUsCorreo());
		objetoObtenido.setUsNombres(usu.getUsNombres());
		objetoObtenido.setUsApellidos(usu.getUsApellidos());
		objetoObtenido.setUsEstado(usu.getUsEstado());
		objetoObtenido.setUsDireccion(usu.getUsDireccion());
		objetoObtenido.setUsFechaCreacion(usu.getUsFechaCreacion());
		Usuario usImg = this.usuariodao.obtener(usu.getUsId());
		
		System.out.println(usImg.getUsImagen());
		objetoObtenido.setUsImagen(usImg.getUsImagen());
		
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
        objetoObtenido.setUsUltimaActualizacion(date);
        
		Usuario usuarioCreador = usuariodao.obtener(usuarioCreadorId);
		objetoObtenido.setUsuarioByUsIdUsuarioCreador(usuarioCreador);
		objetoObtenido.setUsuarioByUsUsuarioActualizador(usuarioCreador);
		
		Rol rol = roldao.obtener(usu.getRolId());
		this.objetoObtenido.setRol(rol);
		
		Tipodocumento td = tipodocumentodao.obtener(usu.getTdId());
		this.objetoObtenido.setTipodocumento(td);
	} 
}
