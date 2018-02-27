package Entidades;

import java.util.Date;

public class Transaccion {

	public int id;
	public String emisor;
	public String receptor;
	public Date fecha;
	public String mensaje;
	public int inmueble;
	public String operacion;
	
	
	public Transaccion() {}
	
	public Transaccion(int id, String emisor, String receptor, Date fecha, String mensaje, int inmueble,String operacion) {
		this.id = id;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.inmueble = inmueble;
		this.operacion = operacion;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getInmueble() {
		return inmueble;
	}
	public void setInmueble(int inmueble) {
		this.inmueble = inmueble;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
}
