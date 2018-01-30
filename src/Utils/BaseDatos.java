package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Piso;

public class BaseDatos {
		
		private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		private static final String DB_CONNECTION = "jdbc:sqlserver://localhost:1433;Database=Rosario_casa";
		private static final String DB_USER = "root";
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
			String sql = "select Pisos.usuario, Pisos.venta, Pisos.alquiler, Pisos.baños, Pisos.habitaciones, Pisos.precio_venta, Pisos.precio_alquiler, Pisos.permite_mascota, Pisos.aire_acondicionado, Pisos.amueblado, Pisos.piscina, Pisos.ascensor, Zonas.nombre "
					+"from Pisos inner join Zonas on Pisos.id_zona = Zonas.id where usuario='"+user+"' ";
			PreparedStatement ps = con.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();	
			Piso p;
			while(rs.next()){
				
				p = new Piso(rs.getString("usuario"),rs.getString("nombre"),rs.getBoolean("venta"),rs.getBoolean("alquiler"),rs.getDouble("precio_alquiler"),rs.getDouble("precio_venta"));				
				misPisos.add(p);
			}
			
			rs.close();
			ps.close();
			con.close();
			return misPisos;
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
