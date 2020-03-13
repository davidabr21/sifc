package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Producto;
import com.duopharma.models.Vistaproducto;

public class ProductoDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Producto productoModel) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(productoModel); 
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

    public void actualizar(Producto productoModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(productoModel); 
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

    public void eliminar(Producto productoModel) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(productoModel); 
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

    public Producto obtener(Integer idProducto) throws HibernateException 
    { 
    	Producto productoModel = null;  
        try 
        { 
            iniciaOperacion(); 
            productoModel = (Producto) sesion.get(Producto.class, idProducto); 
        } finally 
        { 
            sesion.close(); 
        }  

        return productoModel; 
    }  

    public List<Vistaproducto> obtenerLista() throws HibernateException 
    { 
        List<Vistaproducto> listaProductos = null;  

        try 
        { 
            iniciaOperacion(); 
            listaProductos = sesion.createQuery("from Vistaproducto").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaProductos; 
    }
    
    public List<Producto> obtenerListaProductos() throws HibernateException 
    { 
        List<Producto> listaProductos = null;  

        try 
        { 
            iniciaOperacion(); 
            listaProductos = sesion.createQuery("from Producto").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaProductos; 
    }
    
    public List<Producto> obtenerListaTopProductos() throws HibernateException 
    { 
        List<Producto> listaProductos = null;  

        try 
        { 
            iniciaOperacion(); 
            listaProductos = sesion.createQuery("from Producto p order by p.proId desc").setMaxResults(3).list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaProductos; 
    }
    
    public List<Producto> obtenerListaCantidad() throws HibernateException 
    { 
        List<Producto> listaProductos = null;  

        try 
        { 
            iniciaOperacion(); 
            listaProductos = sesion.createQuery("from Producto p order by p.proCantidad asc").setMaxResults(6).list(); 
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