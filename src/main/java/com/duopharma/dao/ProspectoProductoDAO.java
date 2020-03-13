package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Prospectosporproducto;
import com.duopharma.models.ProspectosporproductoId;

public class ProspectoProductoDAO {
    private Session sesion; 
    private Transaction tx;  

    public void registrar(Prospectosporproducto model) throws HibernateException 
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
    }  

    public void actualizar(Prospectosporproducto model) throws HibernateException 
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

    public void eliminar(Prospectosporproducto model) throws HibernateException 
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

    public Prospectosporproducto obtener(int prospectoId, int productoId) throws HibernateException 
    { 
    	Prospectosporproducto model = null;
    	ProspectosporproductoId id = new ProspectosporproductoId();
    	id.setPpProspectoPrsId(prospectoId);
    	id.setPpProductoProId(productoId);
        try 
        { 
            iniciaOperacion(); 
            model = (Prospectosporproducto) sesion.get(Prospectosporproducto.class, 	id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return model; 
    }  

    public List<Prospectosporproducto> obtenerLista() throws HibernateException 
    { 
        List<Prospectosporproducto> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Prospectoporproducto").list(); 
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