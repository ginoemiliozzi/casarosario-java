package Entidades;

public class Piso {

	String usuario;
	String zona;
	Boolean alquiler;
	Boolean venta;
	Double precioVenta;
	Double precioAlquiler;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public Boolean getAlquiler() {
		return alquiler;
	}
	public void setAlquiler(Boolean alquiler) {
		this.alquiler = alquiler;
	}
	public Boolean getVenta() {
		return venta;
	}
	public void setVenta(Boolean venta) {
		this.venta = venta;
	}
	public Double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(Double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	
	public Piso(String usuario, String zona, Boolean venta, Boolean alquiler, Double precioAlquiler, Double precioVenta) {
		super();
		this.usuario = usuario;
		this.zona = zona;
		this.alquiler = alquiler;
		this.venta = venta;
		this.precioVenta = precioVenta;
		this.precioAlquiler = precioAlquiler;
	}
	

	

	
}
