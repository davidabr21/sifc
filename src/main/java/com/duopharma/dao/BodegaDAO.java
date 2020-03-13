package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Bodega;

public class BodegaDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Bodega bodegaModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(bodegaModel); 
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

    public void actualizar(Bodega bodegaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(bodegaModel); 
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

    public void eliminar(Bodega bodegaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(bodegaModel); 
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

    public Bodega obtener(Integer idBodega) throws HibernateException 
    { 
    	Bodega bodegaModel = null;  
        try 
        { 
            iniciaOperacion(); 
            bodegaModel = (Bodega) sesion.get(Bodega.class, idBodega); 
        } finally 
        { 
            sesion.close(); 
        }  

        return bodegaModel; 
    }  

    public List<Bodega> obtenerLista() throws HibernateException 
    { 
        List<Bodega> listaBodegas= null;  

        try 
        { 
            iniciaOperacion(); 
            listaBodegas = sesion.createQuery("from Bodega").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaBodegas; 
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