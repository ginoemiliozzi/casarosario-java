package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Entidades.Transaccion;
import Utils.BaseDatos;
import Utils.Encryptor;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String pw = request.getParameter("password");
		
		
		try {
			String password = Encryptor.encrypt(pw);
		if(BaseDatos.validaLogueo(user, password)){
				
				request.getSession().setAttribute("currentUser", user);
				request.getSession().setAttribute("currentPass", password);
				
				ArrayList<Transaccion> misnotif = BaseDatos.verNotificaciones(user);				
				if(!misnotif.isEmpty()) {
					request.getSession().setAttribute("misnotif", misnotif);
				}
				
			}else{
				request.setAttribute("errorLogin", true);
			}
			
			if(request.getParameter("sec")!=null){
				
				request.getRequestDispatcher("Section?sec="+request.getParameter("sec")).forward(request, response);;

			}else{
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("secError", "0");
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
		
	}

}
