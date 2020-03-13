package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Prospecto;

public class ProspectoDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Prospecto prospectoModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(prospectoModel); 
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

    public void actualizar(Prospecto prospectoModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(prospectoModel); 
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

    public void eliminar(Prospecto prospectoModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(prospectoModel); 
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

    public Prospecto obtener(Integer prsId) throws HibernateException 
    { 
    	Prospecto prospectoModel = null;  
        try 
        { 
            iniciaOperacion(); 
            prospectoModel = (Prospecto) sesion.get(Prospecto.class, prsId); 
        } finally 
        { 
            sesion.close(); 
        }  

        return prospectoModel; 
    }  

    public List<Prospecto> obtenerLista() throws HibernateException 
    { 
        List<Prospecto> listaProspecto = null;  

        try 
        { 
            iniciaOperacion(); 
            listaProspecto = sesion.createQuery("from Prospecto").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaProspecto; 
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