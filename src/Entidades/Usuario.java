package Entidades;

public class Usuario {

	String username;
	String password;
	String nombre;
	String apellido;
	String dni;
	String telefono;
	
	
	public Usuario() {}
	
	public Usuario(String username, String password, String nombre, String apellido, String dni, String telefono) {
		super();
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
	}
	
	public String getUsuario() {
		return username;
	}
	public void setUsuario(String usuario) {
		this.username = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
