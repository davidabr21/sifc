package com.duopharma.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Pedido;

public class PedidoDAO {
    private Session sesion; 
    private Transaction tx;  

    public long registrar(Pedido model) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) sesion.save(model); 
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

    public void actualizar(Pedido model) throws HibernateException 
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

    public void eliminar(Pedido model) throws HibernateException 
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

    public Pedido obtener(Integer id) throws HibernateException 
    { 
    	Pedido model = null;  
        try 
        { 
            iniciaOperacion(); 
            model = (Pedido) sesion.get(Pedido.class, id); 
        } finally 
        { 
            sesion.close(); 
        }  

        return model; 
    }  

    public List<Pedido> obtenerLista() throws HibernateException 
    { 
        List<Pedido> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Pedido p order by p.pedId desc").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return lista; 
    }
    
    public List<Pedido> obtenerEnSeleccion(Integer cliId) throws HibernateException 
    { 
        List<Pedido> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Pedido p where p.pedEstado = 'En Seleccion' AND p.usuarioByPedClienteCliId.usId = " + cliId).list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return lista; 
    }
    
    public List<Pedido> obtenerPorEstado(String estado) throws HibernateException 
    { 
        List<Pedido> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Pedido p where p.pedEstado = '"+ estado + "'").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return lista; 
    }
    
    public List<Pedido> obtenerSeleccionados() throws HibernateException 
    { 
        List<Pedido> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Pedido p where p.pedEstado = 'Seleccionado'").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return lista; 
    }
    
    public List<Pedido> obtenerPorCliente(Integer cliId) throws HibernateException 
    { 
        List<Pedido> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from Pedido p where p.usuarioByPedClienteCliId.usId = " + cliId).list(); 
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