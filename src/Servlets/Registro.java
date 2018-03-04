package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Usuario;
import Utils.BaseDatos;
import Utils.Encryptor;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registro() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String encPass = Encryptor.encrypt(request.getParameter("password"));
		
		Usuario u = new Usuario(request.getParameter("userid"),
								encPass,
								request.getParameter("nombre"),
								request.getParameter("apellido"),
								request.getParameter("dni"),
								request.getParameter("tel"));
		Boolean error;
		Boolean registrado=false;
		try {
			 registrado = BaseDatos.registrarUsuario(u);
			 error = false;
			
		} catch (SQLException e) {
			
			request.setAttribute("secError", 100);
			error=true;
			e.printStackTrace();
			
		}
		
		if(!error) {
			if(registrado) {
				request.setAttribute("userRegistrado", true);
				request.getRequestDispatcher("index.jsp").forward(request, response);;
			}else {
				request.setAttribute("userInvalido", true);
				request.getRequestDispatcher("registro.jsp").forward(request, response);;
			}
		}else {

			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
		
		
	}

}
