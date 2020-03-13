package com.duopharma.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Materiaprima;
import com.duopharma.models.Proveedor;

public class ProveedorDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Proveedor proveedor) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(proveedor); 
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

    public void actualizar(Proveedor proveedor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(proveedor); 
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

    public void eliminar(Proveedor proveedor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(proveedor); 
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

    public Proveedor obtener(Integer idproveedor) throws HibernateException 
    { 
    	Proveedor proveedorModel = null;  
        try 
        { 
            iniciaOperacion(); 
            proveedorModel = (Proveedor) sesion.get(Proveedor.class, idproveedor); 
        } finally 
        { 
            sesion.close(); 
        }  

        return proveedorModel; 
    }  

    public List<Proveedor> obtenerLista() throws HibernateException 
    { 
        List<Proveedor> listaProveedores = null;  

        try 
        { 
            iniciaOperacion(); 
            listaProveedores = sesion.createQuery("from Proveedor").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaProveedores; 
    }
    
    public List<String> obtenerListaCorreos() throws HibernateException 
    { 
        List<Proveedor> listaProveedores = null;  
        List<String> correos = new ArrayList<>();
        try 
        { 
            iniciaOperacion(); 
            listaProveedores = sesion.createQuery("from Proveedor").list(); 
            for(Proveedor prov: listaProveedores){
            	correos.add(prov.getPrvCorreo());
            }
        } finally 
        { 
            sesion.close(); 
        }  

        return correos; 
    }
    
    /*public List<Materiaprima> obtenerListaMateria() throws HibernateException 
    { 
        List<Proveedor> listaProveedores = null;  
        List<Materiaprima> correos = new ArrayList<>();
        System.out.println("OBTENER LISTA MATERIA");
        try 
        { 
            iniciaOperacion(); 
            listaProveedores = sesion.createQuery("from Proveedor").list(); 
            for(Proveedor prov: listaProveedores){
            	System.out.println(prov.getPrvNombre());
            	for(Materiaprima mp: prov.getMateriaprimas())
            		System.out.println(mp.getMpNombre());
            	System.out.println("");
            }
        } finally 
        { 
            sesion.close(); 
        }  

        return correos; 
    }*/
    public List<Materiaprima> obtenerListaMateria(Proveedor obj) throws HibernateException 
    { 
        List<Proveedor> listaProveedores = null;  
        List<Materiaprima> correos = new ArrayList<>();
        
        try 
        { 
            iniciaOperacion(); 
    		sesion.refresh(obj);
    		Hibernate.initialize(obj);
    		Set<Materiaprima> s = obj.getMateriaprimas(); 
    		List<Materiaprima> materia = new ArrayList<Materiaprima>();

    		for (Materiaprima x : s) 
    			materia.add(x);
         
        } finally 
        { 
            sesion.close(); 
        }  

        return correos; 
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