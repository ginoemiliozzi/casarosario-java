package Servlets;

import java.io.IOException;
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
		switch(sec){
		
			case 1: 
				request.getRequestDispatcher("WEB-INF/buscopiso.jsp").forward(request, response);;
				break;
			case 2: 
				request.getRequestDispatcher("WEB-INF/alquilaovende.jsp").forward(request, response);;
				break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
