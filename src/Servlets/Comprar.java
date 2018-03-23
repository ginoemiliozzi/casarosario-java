package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.BaseDatos;


@WebServlet("/Comprar")
public class Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Comprar() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inmueble = request.getParameter("inmueble");
		String transaccion = request.getParameter("transaccion");
		String emisor = request.getParameter("emisor");
		String aceptar = request.getParameter("aceptar");
		String rechazar = request.getParameter("rechazar");
		Boolean error;
		
		
		try {
			if(aceptar!=null) {
				
					BaseDatos.cambiaDueno(Integer.valueOf(inmueble),emisor );
					BaseDatos.borraNotificacion(transaccion,inmueble,true);
					error=false;
			}else {
				BaseDatos.borraNotificacion(transaccion,inmueble,false);
				error=false;
			}
			
			
			
		}catch (NumberFormatException | SQLException e) {
			request.setAttribute("secError", 3);
			error=true;
			e.printStackTrace();
		} 
			
				
		if(!error) {
				request.getRequestDispatcher("Section?sec=3").forward(request, response);
		}else {

			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
		
		
	}

}
