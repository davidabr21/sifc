package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duopharma.models.Estanteria;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Vistaestanteria;
import com.duopharma.models.Vistaestanteriacapacidad;

public class EstanteriaDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Estanteria estanteriaModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(estanteriaModel); 
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

    public void actualizar(Estanteria estanteriaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(estanteriaModel); 
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

    public void eliminar(Estanteria estanteriaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(estanteriaModel); 
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

    public Vistaestanteria obtener(Integer id) throws HibernateException 
    { 
    	Vistaestanteria estanteriaModel = null;  
        try 
        { 
            iniciaOperacion(); 
            estanteriaModel = (Vistaestanteria) sesion.get(Vistaestanteria.class, id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return estanteriaModel; 
    }  

    public List<Estanteria> obtenerLista() throws HibernateException 
    { 
        List<Estanteria> listaEstanterias = null;  

        try 
        { 
            iniciaOperacion(); 
            listaEstanterias = sesion.createQuery("from Estanteria").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaEstanterias; 
    }
    
    public List<Estanteria> obtenerListaProductos() throws HibernateException 
    { 
        List<Estanteria> listaEstanterias = null;  

        try 
        { 
            iniciaOperacion(); 
            listaEstanterias = sesion.createQuery("from Estanteria est where est.producto is not null").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaEstanterias; 
    }
    
    public List<Estanteria> obtenerListaMateriales() throws HibernateException 
    { 
        List<Estanteria> listaEstanterias = null;  

        try 
        { 
            iniciaOperacion(); 
            listaEstanterias = sesion.createQuery("from Estanteria est where est.materiaprima is not null").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaEstanterias; 
    }
    
    public List<Vistaestanteriacapacidad> obtenerCapacidadLista() throws HibernateException 
    { 
        List<Vistaestanteriacapacidad> listaEstanteriasCapacidad = null;  

        try 
        { 
            iniciaOperacion(); 
            listaEstanteriasCapacidad = sesion.createQuery("from Vistaestanteriacapacidad").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaEstanteriasCapacidad; 
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