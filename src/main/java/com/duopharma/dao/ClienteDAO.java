package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Bodega;
import com.duopharma.models.Cliente;

public class ClienteDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Cliente clienteModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(clienteModel); 
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

    public void actualizar(Cliente clienteModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(clienteModel); 
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

    public void eliminar(Cliente clienteModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(clienteModel); 
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

    public Cliente obtener(Integer id) throws HibernateException 
    { 
    	Cliente clienteModel = null;  
        try 
        { 
            iniciaOperacion(); 
            clienteModel = (Cliente) sesion.get(Cliente.class, id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return clienteModel; 
    }  

    public List<Cliente> obtenerLista() throws HibernateException 
    { 
        List<Cliente> listaClientes= null;  

        try 
        { 
            iniciaOperacion(); 
            listaClientes = sesion.createQuery("from Cliente").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaClientes; 
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