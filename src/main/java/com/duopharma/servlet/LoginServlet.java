package com.duopharma.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duopharma.bean.LoginBean;
import com.duopharma.dao.AuthDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean loginBean = new LoginBean();

		loginBean.setUsuario(userName);
		loginBean.setClave(password);

		AuthDAO authdao = new AuthDAO();

		try
		{
			List<String> userValidate = authdao.authenticateUser(loginBean);
			String usrol = userValidate.get(0);
			System.out.println("ROL: " + usrol);
			System.out.println("ROL: " + usrol);
			if(!usrol.equals("Invalid user credentials"))
			{
				HttpSession session = request.getSession(); //Creating a session
				session.setMaxInactiveInterval(10*60);
				session.setAttribute("user", userName);
				session.setAttribute("id", userValidate.get(1));
				session.setAttribute("Admin", userName); //setting session attribute
				session.setAttribute("photo", userName);
				session.setAttribute("rol", usrol);
				request.setAttribute("userName", userName);
				
				if(request.getAttribute("errMessage") != null) {
					session.removeAttribute("errMessage");
				}

				//request.getRequestDispatcher("pages/Dashboard.xhtml").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/pages/Dashboard.xhtml");
			}
			else
			{
				System.out.println("Error message = "+userValidate);
				request.setAttribute("errMessage", userValidate);
				response.sendRedirect(request.getContextPath() + "/landing-page/login.xhtml");
			}
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	} //End of doPost()
}