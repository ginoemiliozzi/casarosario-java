package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.*;
import Utils.BaseDatos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Section")
public class Section extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//Servlet pensado como redireccionador, para llamar a cada jsp en etiquetas a href=Section?quieroalquilar=1 por doGet
    public Section() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sec = Integer.parseInt(request.getParameter("sec"));
		Boolean error=false;
		
		//Por si viene desde login
		if(request.getAttribute("errorLogin")!=null) {
			request.setAttribute("errorLogin", true);
		}
		
		switch(sec){
			
			case 0:
				response.sendRedirect("index.jsp");			
				break;
		
			case 1: 
			//SECCION BUSCO PISO
				try {
					
					request.setAttribute("pisos", BaseDatos.buscoPiso());
					error = false;
					
				} catch (SQLException e1) {
					
					request.setAttribute("secError", "1");
					error=true;
					request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
					e1.printStackTrace();
			}
			
			//Si se obtuvieron los datos sin ningun error se redirige al jsp solicitado
			if(!error) {
				request.getRequestDispatcher("WEB-INF/buscopiso.jsp").forward(request, response);
			}	
			break;
				
				
			case 2: 			
			//SECCION ALQUILA O VENDE
			try {
				request.setAttribute("mispisos", BaseDatos.traeMisPisos((String)request.getSession().getAttribute("currentUser")));
				error = false;
				
			} catch (SQLException e) {	
				
				request.setAttribute("secError", "2");
				error=true;
				request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				e.printStackTrace(); 
			}
			
			//Si se obtuvieron los datos sin ningun error se redirige al jsp solicitado
			if(!error) {
				request.getRequestDispatcher("WEB-INF/alquilaovende.jsp").forward(request, response);	
			}
				break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
}
