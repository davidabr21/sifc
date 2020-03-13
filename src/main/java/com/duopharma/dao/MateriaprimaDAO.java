package com.duopharma.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Materiaprima;
import com.duopharma.models.Vistamateriaprima;
import com.duopharma.models.Vistaproducto;

public class MateriaprimaDAO {
	private Session sesion; 
    private Transaction tx;  

    public long registrar(Materiaprima MateriaprimaModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(MateriaprimaModel); 
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

    public void actualizar(Materiaprima MateriaprimaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(MateriaprimaModel); 
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

    public void eliminar(Materiaprima objetoObtenido) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(objetoObtenido); 
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

    public Materiaprima obtener(Integer mpId) throws HibernateException 
    { 
    	Materiaprima materiaprimamodel = null;  
        try 
        { 
            iniciaOperacion(); 
            materiaprimamodel = (Materiaprima) sesion.get(Materiaprima.class, mpId); 
        } finally 
        { 
            sesion.close(); 
        }  

        return materiaprimamodel; 
    }   
    
    public List<Materiaprima> obtenerLista() throws HibernateException 
    { 
        List<Materiaprima> listaMateriaprima = null;  

        try 
        { 
            iniciaOperacion(); 
            listaMateriaprima = sesion.createQuery("from Materiaprima").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaMateriaprima; 
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
