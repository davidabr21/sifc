package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Formula;;

public class FormulaDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Formula formulaModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(formulaModel); 
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

    public void actualizar(Formula formulaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(formulaModel); 
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

    public void eliminar(Formula formulaModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(formulaModel); 
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

    public Formula obtener(Integer idFormula) throws HibernateException 
    { 
    	Formula formulaModel = null;  
        try 
        { 
            iniciaOperacion(); 
            formulaModel = (Formula) sesion.get(Formula.class, idFormula); 
        } finally 
        { 
            sesion.close(); 
        }  

        return formulaModel; 
    }  

    public List<Formula> obtenerLista() throws HibernateException 
    { 
        List<Formula> listaFormulas = null;  

        try 
        { 
            iniciaOperacion(); 
            listaFormulas = sesion.createQuery("from Formula").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaFormulas; 
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