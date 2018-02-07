package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entidades.*;
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
				request.setAttribute("pisos", buscoPiso());		//Carga los pisos como atributo
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
	
	public List<Piso> buscoPiso(){
		List<Piso> pisos = new ArrayList<>();
		
		//mock data
		Piso p1 = new Piso();
		p1.setId(0);
		p1.setEstado("libre");
		p1.setZona("Zona Centro");
		p1.setDireccion("Zeballos 1341");
		p1.setPropietario("Juan Perez");
		p1.setBaños(1);
		p1.setHabitaciones(1);
		p1.setPermite_mascotas(true);
		p1.setAire_acondicionado(true);
		p1.setAmueblado(true);
		p1.setPiscina(true);
		p1.setAscensor(true);
		p1.setGimnasio(true);
		p1.setPrecio_alquiler(5500);
		p1.setPrecio_venta(600000);

		pisos.add(p1);		
	
		Piso p2 = new Piso();
		p2.setId(1);
		p2.setEstado("libre");
		p2.setZona("Zona Centro");
		p2.setDireccion("Zeballos 123");
		p2.setPropietario("Juan Perez");
		p2.setBaños(1);
		p2.setHabitaciones(2);
		p2.setPermite_mascotas(true);
		p2.setAire_acondicionado(true);
		p2.setAmueblado(true);
		p2.setPiscina(true);
		p2.setAscensor(true);
		p2.setGimnasio(true);
		p2.setPrecio_alquiler(7000);
		p2.setPrecio_venta(850000);

		pisos.add(p2);
		
		return pisos;
		
	}

}
