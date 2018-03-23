package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.BaseDatos;


@WebServlet("/Notificaciones")
public class Notificaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Notificaciones() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int inmueble = Integer.parseInt(request.getParameter("id"));
		String emisor = request.getParameter("usuario");
		Boolean error;
		
		try {
			BaseDatos.notificar(emisor,inmueble,"COM");
			error=false;
		} catch (SQLException | NullPointerException e) {
			
			request.setAttribute("secError", 1);
			error=true;
			e.printStackTrace();
			
		}
		
		if(!error) {
				request.getRequestDispatcher("Section?sec=1&userNotificado=1").forward(request, response);
		}else {

			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
	
	}

}
