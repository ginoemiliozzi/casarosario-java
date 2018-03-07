package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Piso;
import Utils.BaseDatos;

/**
 * Servlet implementation class ABMPisos
 */
@WebServlet("/ABMPisos")
public class ABMPisos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ABMPisos() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc = request.getParameter("accion");
		String id;
		Piso p=null;
		boolean error=false;
		if(acc.equals("consulta")) {
			id=request.getParameter("id");
			try {
				p = BaseDatos.getPiso(id);
			} catch (SQLException e) {
				request.setAttribute("secError", "2");
				error=true;
				request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				e.printStackTrace();
			}
			request.setAttribute("piso", p);
			
			//Si se obtuvieron los datos sin ningun error se redirige al jsp solicitado
			if(!error) {
				request.getRequestDispatcher("ABM-pisos.jsp").forward(request, response);			
			}
		}
		
		if(acc.equals("modif")) {
			id=request.getParameter("id");
			try {
				//Pregunto los campos checkbox para hacer booleanos.
				boolean permite_mascotas=false;
				if(request.getParameter("permite_mascotas")!=null) {
					permite_mascotas=true;
				}
				boolean amueblado=false;
				if(request.getParameter("amueblado")!=null) {
					amueblado=true;
				}
				boolean aire_acondicionado=false;
				if(request.getParameter("aire_acondicionado")!=null) {
					aire_acondicionado=true;
				}
				boolean piscina=false;
				if(request.getParameter("piscina")!=null) {
					piscina=true;
				}
				boolean ascensor=false;
				if(request.getParameter("ascensor")!=null) {
					ascensor=true;
				}
				boolean gimnasio=false;
				if(request.getParameter("gimnasio")!=null) {
					gimnasio=true;
				}
				BaseDatos.updatePiso(id,request.getParameter("zona"),request.getParameter("direccion"),Integer.parseInt(request.getParameter("banos")),Integer.parseInt(request.getParameter("habitaciones")),
						permite_mascotas,
						amueblado,
						aire_acondicionado,
						piscina,
						ascensor,
						gimnasio,
						Float.parseFloat(request.getParameter("precio_venta")));
			} catch (NumberFormatException|SQLException e) {
				request.setAttribute("secError", "2");
				error=true;
				request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				e.printStackTrace();
			}if(!error) {
				request.getRequestDispatcher("Section?sec=2").forward(request, response);			
			}
		}
		if(acc.equals("alta")) {
			try {
				
//				NO ES NECESARIO
//				id=BaseDatos.generarId();
				
				String propietario = request.getParameter("propietario");
	
				//Pregunto los campos checkbox para hacer booleanos.
				boolean permite_mascotas=false;
				if(request.getParameter("permite_mascotas")!=null) {
					permite_mascotas=true;
				}
				boolean amueblado=false;
				if(request.getParameter("amueblado")!=null) {
					amueblado=true;
				}
				boolean aire_acondicionado=false;
				if(request.getParameter("aire_acondicionado")!=null) {
					aire_acondicionado=true;
				}
				boolean piscina=false;
				if(request.getParameter("piscina")!=null) {
					piscina=true;
				}
				boolean ascensor=false;
				if(request.getParameter("ascensor")!=null) {
					ascensor=true;
				}
				boolean gimnasio=false;
				if(request.getParameter("gimnasio")!=null) {
					gimnasio=true;
				}
				BaseDatos.createPiso(propietario,request.getParameter("zona"),request.getParameter("direccion"),Integer.parseInt(request.getParameter("banos")),Integer.parseInt(request.getParameter("habitaciones")),
						permite_mascotas,
						amueblado,
						aire_acondicionado,
						piscina,
						ascensor,
						gimnasio,
						Float.parseFloat(request.getParameter("precio_venta")));
			} catch (NumberFormatException|SQLException e) {
				request.setAttribute("secError", "2");
				error=true;
				request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				e.printStackTrace();
			}if(!error) {
				request.getRequestDispatcher("Section?sec=2").forward(request, response);			
			}
			
			
		}
		
	
	}

}
