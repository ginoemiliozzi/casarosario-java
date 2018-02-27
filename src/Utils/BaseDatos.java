package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Piso;

public class BaseDatos {
		
		private static final String DB_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
		private static final String DB_CONNECTION = "jdbc:jtds:sqlserver://localhost;instance=SQLEXPRESS;DatabaseName=Rosario_casa;";
		private static final String DB_USER = "sa";
		private static final String DB_PASSWORD = "123456";
		
		
		public static boolean validaLogueo(String user, String password) throws SQLException{
			
			Connection con = getDBConnection();
			String sql = "select * from Usuarios where usuario='"+user+"' and password='"+password+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			rs.close();
			ps.close();
			con.close();
			return false;
		}
		
		public static ArrayList<Piso> traeMisPisos(String user) throws SQLException{
			ArrayList<Piso> misPisos = new ArrayList<Piso>();
			Connection con= getDBConnection();
			String sql = "select Pisos.*, Zonas.nombre as nombreZona, Estados.descripcion as descEstado "
						+" from Pisos "
						+ " inner join Zonas "
						+ "		on Pisos.zona = Zonas.id "
						+ "inner join Estados "
						+ "		on Pisos.estado = Estados.id "
						+ "where Pisos.propietario='"+user+"' ";
			PreparedStatement ps = con.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();	
			Piso p;
			while(rs.next()){
				
			 p = new Piso(rs.getInt("id"),
					 	  rs.getString("descEstado"),
					 	  rs.getString("nombreZona"),
					 	  rs.getString("direccion"),
					 	  rs.getString("propietario"),
					 	  rs.getInt("banios"),
					 	  rs.getInt("habitaciones"),
					 	  rs.getBoolean("permite_mascota"),
					 	  rs.getBoolean("aire_acondicionado"),
					 	  rs.getBoolean("amueblado"),
					 	  rs.getBoolean("piscina"),
					 	  rs.getBoolean("ascensor"),
					 	  rs.getBoolean("gimnasio"),
					 	  rs.getFloat("precio_alquiler"),
					 	  rs.getFloat("precio_venta"),	
			 			  rs.getString("img_url"));	
			misPisos.add(p);
			}
			
			rs.close();
			ps.close();
			con.close();
			return misPisos;
		}
		
		public static boolean cambiaDueno(int id_casa,String usuario) {
			Connection con  = getDBConnection();
			boolean ok;
			String sql = "UPDATE Pisos SET Pisos.propietario = ? where Pisos.id = ?";
			PreparedStatement ps=null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(0, usuario);
				ps.setInt(1, id_casa);
				ps.executeUpdate();
				ok=true;
			} catch (SQLException e) {
				e.printStackTrace();
				ok= false;
			}
			finally {
				if(ps!=null)try {ps.close();} catch (SQLException e) {e.printStackTrace();}
				if(con!=null)try {con.close();} catch (SQLException e) {e.printStackTrace();}
			}
			return ok;
		}
		
		public static List<Piso> buscoPiso(){
			List<Piso> pisos = new ArrayList<>();
			
			Connection con= getDBConnection();
			String sql = "select Pisos.*, Zonas.nombre as nombreZona, Estados.descripcion as descEstado "
						+" from Pisos "
						+ " inner join Zonas "
						+ "		on Pisos.zona = Zonas.id "
						+ "inner join Estados "
						+ "		on Pisos.estado = Estados.id ";
			ResultSet rs=null;
			PreparedStatement ps=null;
			try {
				ps = con.prepareStatement(sql);			
				rs = ps.executeQuery();
			
			Piso p;
			while(rs.next()){
				
			 p = new Piso(rs.getInt("id"),
					 	  rs.getString("descEstado"),
					 	  rs.getString("nombreZona"),
					 	  rs.getString("direccion"),
					 	  rs.getString("propietario"),
					 	  rs.getInt("banios"),
					 	  rs.getInt("habitaciones"),
					 	  rs.getBoolean("permite_mascota"),
					 	  rs.getBoolean("aire_acondicionado"),
					 	  rs.getBoolean("amueblado"),
					 	  rs.getBoolean("piscina"),
					 	  rs.getBoolean("ascensor"),
					 	  rs.getBoolean("gimnasio"),
					 	  rs.getFloat("precio_alquiler"),
					 	  rs.getFloat("precio_venta"),	
			 			  rs.getString("img_url"));	
			pisos.add(p);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//Cierro todo
				if(rs!=null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
				if(ps!=null) {try {ps.close();} catch (SQLException e) {e.printStackTrace();}}			
				try {con.close();} catch (SQLException e) {e.printStackTrace();	}
				
			}	
			return pisos;
			
		}

		
		private static Connection getDBConnection() {

			Connection dbConnection = null;
			
			try {
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try {

				dbConnection = DriverManager.getConnection(
	                            DB_CONNECTION, DB_USER,DB_PASSWORD);
				return dbConnection;

			} catch (SQLException e) {

				System.out.println(e.getMessage());

			}

			return dbConnection;

		}
}
