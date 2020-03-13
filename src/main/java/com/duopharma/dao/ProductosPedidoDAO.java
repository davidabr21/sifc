package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Productosporpedido;
import com.duopharma.models.Tipodocumento;

public class ProductosPedidoDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Productosporpedido model) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.save(model); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
        	handleException(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

        return 1; 
    }  

    public void actualizar(Productosporpedido model) throws HibernateException 
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

    public void eliminar(Productosporpedido model) throws HibernateException 
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

    public Productosporpedido obtener(Integer id) throws HibernateException 
    { 
    	Productosporpedido model = null;  
        try 
        { 
            iniciaOperacion(); 
            model = (Productosporpedido) sesion.get(Productosporpedido.class, id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return model; 
    }  

    public List<Productosporpedido> obtenerLista() throws HibernateException 
    { 
        List<Productosporpedido> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Productosporpedido").list(); 
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