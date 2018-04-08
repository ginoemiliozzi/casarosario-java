package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Piso;
import Entidades.Transaccion;
import Entidades.Usuario;

public class BaseDatos {
		
		private static final String DB_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
		private static final String DB_CONNECTION = "jdbc:jtds:sqlserver://localhost;instance=SQLEXPRESS;DatabaseName=Rosario_casa;";
		private static final String DB_USER = "sa";
		private static final String DB_PASSWORD = "123456";
		
		
		public static boolean validaLogueo(String user, String password) throws SQLException, InhabilitadoException{
			
			Connection con = getDBConnection();
			String sql = "select * from Usuarios where usuario='"+user+"' and password='"+password+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(rs.getInt("inhabilitado")==1) {
					throw new InhabilitadoException();
				}else {
					return true;					
				}
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
		
		public static List<Usuario> getUsuarios() throws SQLException{
			List<Usuario> usuarios = new ArrayList<Usuario>();
			Connection con= getDBConnection();
			String sql = "select * from Usuarios";
			PreparedStatement ps = con.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();	
			Usuario u;
			while(rs.next()){
				u = new Usuario(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBoolean(7),rs.getBoolean(8));
				usuarios.add(u);
			}
			
			rs.close();
			ps.close();
			con.close();
			return usuarios;
		}

		
		public static Piso getPiso(String id) throws SQLException{
			Connection con= getDBConnection();
			String sql = "select Pisos.* "
						+" from Pisos "
						+ "where Pisos.id="+id+" ";
			PreparedStatement ps = con.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();	
			Piso p = null;
			while(rs.next()){
				
			 p = new Piso(rs.getInt("id"),
					 	  rs.getString("estado"),
					 	  rs.getString("zona"),
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
			}
			
			rs.close();
			ps.close();
			con.close();
			return p;
		}
		
		public static void updatePiso(String id, String zona, String direccion, int banos, int habitaciones, boolean masc, boolean aire, boolean amuebl, boolean piscina, boolean ascensor, boolean gim, float precio, String img_url) throws SQLException{
			Connection con= getDBConnection();
			String sql = "update Pisos set zona=? ,direccion = ?, banios=?, habitaciones=?,permite_mascota=?,aire_acondicionado=?,amueblado=?,piscina=?,ascensor=?,gimnasio=?,precio_venta=? "
					+ "where id = "+id; 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, zona);
			ps.setString(2, direccion);
			ps.setInt(3, banos);
			ps.setInt(4,habitaciones);
			ps.setBoolean(5, masc);
			ps.setBoolean(6, aire);
			ps.setBoolean(7, amuebl);
			ps.setBoolean(8, piscina);
			ps.setBoolean(9, ascensor);
			ps.setBoolean(10, gim);
			ps.setFloat(11, precio);
			ps.execute();	
			
			if(img_url!=null) {
				sql="update Pisos set img_url='"+img_url+"' where id= "+id;
				ps = con.prepareStatement(sql);
				ps.execute();
			}
			
			ps.close();
			con.close();
		}
		
		public static void cambiaDueno(int id_casa,String usuario) throws SQLException {
			Connection con  = getDBConnection();
			boolean ok;
			String sql = "UPDATE Pisos SET Pisos.propietario = ? where Pisos.id = ?";
			PreparedStatement ps=null;
			
				ps = con.prepareStatement(sql);
				ps.setString(1, usuario);
				ps.setInt(2, id_casa);
				ps.executeUpdate();
				ps.close();
				con.close();
			
			
		}
		
		public static List<Piso> buscoPiso(String filtro) throws SQLException, NullPointerException{
			List<Piso> pisos = new ArrayList<>();
			
			Connection con= getDBConnection();
			String sql = "select Pisos.*, Zonas.nombre as nombreZona, Estados.descripcion as descEstado "
						+" from Pisos "
						+ " inner join Zonas "
						+ "		on Pisos.zona = Zonas.id "
						+ "inner join Estados "
						+ "		on Pisos.estado = Estados.id where Pisos.estado=1 ";
			sql+=filtro;
			ResultSet rs=null;
			PreparedStatement ps=null;
			
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
			rs.close();
			ps.close();
			con.close();
			return pisos;
			
		}
		
		//Si me llaman sin nada, mando al metodo principal sin filtro
		public static List<Piso> buscoPiso() throws SQLException{
			return buscoPiso("");
		}
			
		public static Boolean registrarUsuario(Usuario u) throws SQLException, NullPointerException {
			
			Connection con = getDBConnection();
			
			Boolean registrado = true;
			String sql = "select usuario from Usuarios where usuario='"+u.getUsuario()+"'";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				registrado=false;
				rs.close();
				ps.close();
				con.close();
			}else {
			
			sql= "insert into Usuarios values ('"+u.getUsuario()+"'"
					+"								,'"+u.getPassword()+"'"
					+"								,'"+u.getNombre()+"'"
					+"								,'"+u.getApellido()+"'"
					+"								,'"+u.getDni()+"'"
					+"								,'"+u.getTelefono()+"'"
					+"								,'0','0')";
			
			ps = con.prepareStatement(sql);
			
			ps.execute();
			
			ps.close();
			rs.close();
			con.close();
			registrado=true;
			}
			
			return registrado;
			
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

		public static ArrayList<Transaccion> verNotificaciones(String user) throws SQLException {
			ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
			
			String sql = "select * from Transacciones t where t.receptor=? ";
			
			Connection con = getDBConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			Transaccion t;
			while(rs.next()) {
				t = new Transaccion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getInt(6),rs.getString(7));
				transacciones.add(t);
			}
					
			return transacciones;
		}


		public static void createPiso(String propietario,  String zona, String direccion, int banos, 
				int habitaciones, boolean masc, boolean aire, boolean amuebl, boolean piscina, boolean ascensor, boolean gim, float precio, String img_url) throws SQLException {
			Connection con= getDBConnection(); 
			String sql = " INSERT INTO Pisos "
					+ "VALUES(	    ?"
					+ "	           ,?"
					+ "	           ,?"
					+ "	           ,?"
					+ "	           ,?"
					+ "	           ,?"
					+ "	           ,?"
					+ "	           ,?"
					+ "	           ,?"
					+ "	           ,?"
					+ "			   ,?"
					+ "	           ,?"
					+ "	           ,NULL"				//<precio_alquiler, float,>"
					+ "	           ,?"
					+ "	           ,?)";				//<img_url, varchar(100),>)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);//estado
			ps.setString(2, direccion);
			ps.setString(3, zona);
			ps.setString(4, propietario);
			ps.setInt(5, banos);
			ps.setInt(6,habitaciones);
			ps.setBoolean(7, masc);
			ps.setBoolean(8, aire);
			ps.setBoolean(9, amuebl);
			ps.setBoolean(10, piscina);
			ps.setBoolean(11, ascensor);
			ps.setBoolean(12, gim);
			ps.setFloat(13, precio);
			ps.setString(14, img_url);
			System.out.println(ps);
			ps.execute();	
			
			ps.close();
			con.close();
			
		}

		public static Boolean notificar(String emisor, int inmueble, String string) throws SQLException {
			
			String sql;
			Connection conn = getDBConnection();
			ResultSet rs;
			PreparedStatement ps;
			
			String receptor=null;
			
			 sql = "SELECT * FROM dbo.Usuarios  " + 
					"INNER JOIN dbo.Pisos ON Pisos.propietario = Usuarios.usuario " + 
					"WHERE dbo.Pisos.id="+inmueble;
			ps=conn.prepareStatement(sql);
			rs =  ps.executeQuery();
			if(rs.next())
				receptor=rs.getString("usuario");
			
			
				sql="INSERT INTO dbo.Transacciones " + 
					"( " + 
					"    emisor, " + 
					"    receptor, " + 
					"    fecha, " + 
					"    inmueble, " + 
					"    operacion " + 
					") " + 
					"VALUES " + 
					"(   '"+emisor+"',         " + 
					"    '"+receptor+"',       " + 
					"    GETDATE(), " +
					"    "+inmueble+",        " + 
					"    'COM'        " + 
					"    )";
				
			ps = conn.prepareStatement(sql);
			ps.execute();
			return true;
		}

		public static void borraNotificacion(String transaccion,String inmueble,Boolean aceptada) throws SQLException {
			
			Connection conn = getDBConnection();
			String sql;
			PreparedStatement ps;
			
			if(aceptada) {
				sql="DELETE FROM Transacciones where inmueble="+inmueble;	//borro todas las transacciones para ese inmueble
			}else {
				sql="DELETE FROM Transacciones where id="+transaccion;
			}
			
			conn = getDBConnection();
			ps= conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			conn.close();
			
		}

		public static boolean verAdmin(String user) throws SQLException {			
			Connection con = getDBConnection();
			String sql = "select * from Usuarios where usuario=? and admin='1'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
					return true;					
				}
			rs.close();
			ps.close();
			con.close();
			return false;
		}

		public static void habilitarUsuario(String usuario) throws SQLException {
			Connection con = getDBConnection();
			String sql = "update Usuarios set inhabilitado=0 where usuario=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.execute();
			ps.close();
			con.close();
		}
		public static void inhabilitarUsuario(String usuario) throws SQLException {
			Connection con = getDBConnection();
			String sql = "update Usuarios set inhabilitado=1 where usuario=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.execute();
			ps.close();
			con.close();
		}
}
