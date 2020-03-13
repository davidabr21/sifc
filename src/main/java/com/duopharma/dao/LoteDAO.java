package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Lote;

public class LoteDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Lote model) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(model); 
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

    public void actualizar(Lote model) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(model); 
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

    public void eliminar(Lote model) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(model); 
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

    public Lote obtener(Integer id) throws HibernateException 
    { 
    	Lote model = null;  
        try 
        { 
            iniciaOperacion(); 
            model = (Lote) sesion.get(Lote.class, id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return model; 
    }  

    public List<Lote> obtenerLista() throws HibernateException 
    { 
        List<Lote> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Lote").list(); 
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