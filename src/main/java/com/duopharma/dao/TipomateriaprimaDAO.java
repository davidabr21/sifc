package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Producto;
import com.duopharma.models.Tipomateriaprima;
import com.duopharma.models.Vistaproducto;

public class TipomateriaprimaDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Tipomateriaprima tipomateriaprimaModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(tipomateriaprimaModel); 
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

    public void actualizar(Tipomateriaprima tipomateriaprimaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(tipomateriaprimaModel); 
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

    public void eliminar(Tipomateriaprima tipomateriaprimaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(tipomateriaprimaModel); 
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

    public Tipomateriaprima obtener(int tmp_Id) throws HibernateException 
    { 
    	Tipomateriaprima tipomateriaprimaModel = null;  
        try 
        { 
            iniciaOperacion(); 
            tipomateriaprimaModel = (Tipomateriaprima) sesion.get(Tipomateriaprima.class, tmp_Id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return tipomateriaprimaModel; 
    }  

    public List<Tipomateriaprima> obtenerLista() throws HibernateException 
    { 
        List<Tipomateriaprima> listaProductos = null;  

        try 
        { 
            iniciaOperacion(); 
            listaProductos = sesion.createQuery("from Tipomateriaprima").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaProductos; 
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
