package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Rol;

public class RolDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Rol rolModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(rolModel); 
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

    public void actualizar(Rol rolModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(rolModel); 
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

    public void eliminar(Rol rolModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(rolModel); 
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

    public Rol obtener(Integer idRol) throws HibernateException 
    { 
    	Rol rolModel = null;  
        try 
        { 
            iniciaOperacion(); 
            rolModel = (Rol) sesion.get(Rol.class, idRol); 
        } finally 
        { 
            sesion.close(); 
        }  

        return rolModel; 
    }  

    public List<Rol> obtenerLista() throws HibernateException 
    { 
        List<Rol> listaRoles = null;  

        try 
        { 
            iniciaOperacion(); 
            listaRoles = sesion.createQuery("from Rol").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaRoles; 
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