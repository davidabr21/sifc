package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duopharma.models.Estanteria;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Usuario;
import com.duopharma.models.Vistausuario;

public class UsuarioDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Usuario usuarioModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(usuarioModel); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
        	handleException(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

        return id; 
    }  

    public void actualizar(Usuario usuarioModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(usuarioModel); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
        	handleException(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public void eliminar(Usuario usuarioModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(usuarioModel); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
        	handleException(he);
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public Usuario obtener(Integer idUsuario) throws HibernateException 
    { 
    	Usuario usuarioModel = null;  
        try 
        { 
            iniciaOperacion(); 
            usuarioModel = (Usuario) sesion.get(Usuario.class, idUsuario); 
        } finally 
        { 
            sesion.close(); 
        }  

        return usuarioModel; 
    }  

    public List<Vistausuario> obtenerLista() throws HibernateException 
    { 
        List<Vistausuario> listaUsuarios = null;  

        try 
        { 
            iniciaOperacion(); 
            listaUsuarios = sesion.createQuery("from Vistausuario").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaUsuarios; 
    }
    
    public List<Vistausuario> obtenerListaClientes() throws HibernateException 
    { 
        List<Vistausuario> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Vistausuario u where u.rolNombre = 'Cliente'").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return lista; 
    }

    private void iniciaOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    }  

    private void handleException(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    } 
}