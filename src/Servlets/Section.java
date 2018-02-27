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
		
		//Por si viene desde login
		if(request.getAttribute("errorLogin")!=null) {
			request.setAttribute("errorLogin", true);
		}
		
		switch(sec){
		//Deberiamos hacer un try para todos los case y cuando hay error lo mandamos a index con algun mensaje
			case 1: 
				request.setAttribute("pisos", BaseDatos.buscoPiso());		//Carga los pisos como atributo
				request.getRequestDispatcher("WEB-INF/buscopiso.jsp").forward(request, response);;
				break;
			case 2: 
			Boolean error=false;
			try {
				error = false;
				request.setAttribute("mispisos", BaseDatos.traeMisPisos((String)request.getSession().getAttribute("currentUser")));
				} catch (SQLException e) {	
					request.setAttribute("error", "1");
					error=true;
					request.getRequestDispatcher("index.jsp").forward(request, response);
					e.printStackTrace(); }
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
