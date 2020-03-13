package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Tipooperacion;

public class TipoOperacionDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Tipooperacion tipoOperacionModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(tipoOperacionModel); 
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

    public void actualizar(Tipooperacion tipoOperacionModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(tipoOperacionModel); 
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

    public void eliminar(Tipooperacion tipoOperacionModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(tipoOperacionModel); 
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

    public Tipooperacion obtener(Integer idTipoOperacion) throws HibernateException 
    { 
    	Tipooperacion tipoOperacionModel = null;  
        try 
        { 
            iniciaOperacion(); 
            tipoOperacionModel = (Tipooperacion) sesion.get(Tipooperacion.class, idTipoOperacion); 
        } finally 
        { 
            sesion.close(); 
        }  

        return tipoOperacionModel; 
    }

    public List<Tipooperacion> obtenerLista() throws HibernateException 
    { 
        List<Tipooperacion> listaTiposOperacion = null;  

        try 
        { 
            iniciaOperacion(); 
            listaTiposOperacion = sesion.createQuery("from Tipooperacion").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaTiposOperacion; 
    } 
    
    public List<Tipooperacion> obtenerPorNombre(String nombre) throws HibernateException 
    { 
        List<Tipooperacion> listaTiposOperacion = null;  

        try 
        { 
            iniciaOperacion(); 
            listaTiposOperacion = sesion.createQuery("from Tipooperacion to where to.toNombre = '" + nombre + "'").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaTiposOperacion; 
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