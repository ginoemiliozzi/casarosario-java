package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.BaseDatos;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		
		try {
			if(BaseDatos.validaLogueo(user, password)){
				
				request.getSession().setAttribute("currentUser", user);
				request.getSession().setAttribute("currentPass", password);
				
				
				
			}else{
				request.setAttribute("errorLogin", true);
			}
			
			if(request.getParameter("sec")!=null){
				
				switch(Integer.parseInt(request.getParameter("sec"))){
				
				case 1: 
					request.setAttribute("pisos", BaseDatos.buscoPiso());	
					request.getRequestDispatcher("WEB-INF/buscopiso.jsp").forward(request, response);;
					break;
				case 2: 
					try {
						request.setAttribute("mispisos", BaseDatos.traeMisPisos((String)request.getSession().getAttribute("currentUser")));
						} catch (SQLException e) {	
							request.setAttribute("error", "1");
							e.printStackTrace(); }
					request.getRequestDispatcher("WEB-INF/alquilaovende.jsp").forward(request, response);;
					break;
				}
			}else{
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("errorSQL", true);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}
