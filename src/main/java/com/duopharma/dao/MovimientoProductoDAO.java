package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Movimientoproducto;

public class MovimientoProductoDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Movimientoproducto model) throws HibernateException 
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

    public void actualizar(Movimientoproducto model) throws HibernateException 
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

    public void eliminar(Movimientoproducto model) throws HibernateException 
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

    public Movimientoproducto obtener(Integer id) throws HibernateException 
    { 
    	Movimientoproducto model = null;  
        try 
        { 
            iniciaOperacion(); 
            model = (Movimientoproducto) sesion.get(Movimientoproducto.class, id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return model; 
    }  

    public List<Movimientoproducto> obtenerLista() throws HibernateException 
    { 
        List<Movimientoproducto> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Movimientoproducto").list(); 
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