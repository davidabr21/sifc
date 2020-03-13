package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Tipoproducto;

public class TipoProductoDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Tipoproducto tipoProductoModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(tipoProductoModel); 
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

    public void actualizar(Tipoproducto tipoProductoModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(tipoProductoModel); 
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

    public void eliminar(Tipoproducto tipoProductoModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(tipoProductoModel); 
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

    public Tipoproducto obtener(Integer idTipoProducto) throws HibernateException 
    { 
    	Tipoproducto tipoOperacionModel = null;  
        try 
        { 
            iniciaOperacion(); 
            tipoOperacionModel = (Tipoproducto) sesion.get(Tipoproducto.class, idTipoProducto); 
        } finally 
        { 
            sesion.close(); 
        }  

        return tipoOperacionModel; 
    }  

    public List<Tipoproducto> obtenerLista() throws HibernateException 
    { 
        List<Tipoproducto> listaTiposProducto = null;  

        try 
        { 
            iniciaOperacion(); 
            listaTiposProducto = sesion.createQuery("from Tipoproducto").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaTiposProducto; 
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