package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Unidadmedida;;

public class UnidadMedidaDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Unidadmedida unidadMedidaModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(unidadMedidaModel); 
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

    public void actualizar(Unidadmedida unidadMedidaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(unidadMedidaModel); 
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

    public void eliminar(Unidadmedida unidadMedidaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(unidadMedidaModel); 
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

    public Unidadmedida obtener(Integer idUnidadMedida) throws HibernateException 
    { 
    	Unidadmedida unidadMedidaModel = null;  
        try 
        { 
            iniciaOperacion(); 
            unidadMedidaModel = (Unidadmedida) sesion.get(Unidadmedida.class, idUnidadMedida); 
        } finally 
        { 
            sesion.close(); 
        }  

        return unidadMedidaModel; 
    }  

    public List<Unidadmedida> obtenerLista() throws HibernateException 
    { 
        List<Unidadmedida> listaUnidadesMedida = null;  

        try 
        { 
            iniciaOperacion(); 
            listaUnidadesMedida = sesion.createQuery("from Unidadmedida").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaUnidadesMedida; 
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