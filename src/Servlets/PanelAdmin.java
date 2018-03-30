package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Usuario;
import Utils.BaseDatos;

/**
 * Servlet implementation class PanelAdmin
 */
@WebServlet("/PanelAdmin")
public class PanelAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("hab")!=null) {
			String usuario = request.getParameter("usuario");
			try {
				BaseDatos.habilitarUsuario(usuario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(request.getParameter("inh")!=null) {
			String usuario = request.getParameter("usuario");
			try {
				BaseDatos.inhabilitarUsuario(usuario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ir(request,response);

	
	}

	private void ir(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			usuarios = BaseDatos.getUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("WEB-INF/PanelAdmin.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
