package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Tipodocumento;

public class TipoDocumentoDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Tipodocumento model) throws HibernateException 
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

    public void actualizar(Tipodocumento model) throws HibernateException 
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

    public void eliminar(Tipodocumento model) throws HibernateException 
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

    public Tipodocumento obtener(Integer id) throws HibernateException 
    { 
    	Tipodocumento model = null;  
        try 
        { 
            iniciaOperacion(); 
            model = (Tipodocumento) sesion.get(Tipodocumento.class, id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return model; 
    }  

    public List<Tipodocumento> obtenerLista() throws HibernateException 
    { 
        List<Tipodocumento> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Tipodocumento").list(); 
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