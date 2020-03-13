	package com.duopharma.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duopharma.bean.LoginBean;
import com.duopharma.bean.UsuarioBean;
import com.duopharma.models.HibernateUtil;
import com.duopharma.models.Usuario;

public class AuthDAO {
	 private Session sesion; 
	 private Transaction tx;  
	
	public List<String> authenticateUser(LoginBean loginBean)
	{
		String userName = loginBean.getUsuario();
		String password = loginBean.getClave();

		List<Usuario> usersList = null;

		String userNameDB = "";
		String passwordDB = "";
		String roleDB = "";
		List<String> valores = new ArrayList<String>();
		try
		{
			iniciaOperacion();
			usersList = sesion.createQuery("select u from Usuario u left join u.rol as r").list();
			String passwordM = getMD5(password);
			for (Usuario usuario : usersList) {
				userNameDB = usuario.getUsNombreDeUsuario();
				passwordDB = usuario.getUsClave();
				roleDB = usuario. getRol().getRolNombre();
				if(userName.equals(userNameDB) && passwordM.equals(passwordDB)) {					
					valores.add(roleDB);
					valores.add(String.valueOf(usuario.getUsId()));
					return valores;
				}
					
			}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		//valores.add("Invalid");
		return valores;
	}
	
	public String getMD5(String input) {
		 try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] messageDigest = md.digest(input.getBytes());
		 BigInteger number = new BigInteger(1, messageDigest);
		 String hashtext = number.toString(16);

		 while (hashtext.length() < 32) {
		 hashtext = "0" + hashtext;
		 }
		 return hashtext;
		 }
		 catch (NoSuchAlgorithmException e) {
		 throw new RuntimeException(e);
		 }
	}
	
    private void iniciaOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    }  
}
