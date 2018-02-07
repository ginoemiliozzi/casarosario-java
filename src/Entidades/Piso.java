package Entidades;

public class Piso {

	public int id;
	public String estado;
	public String zona;
	public String direccion;
	public String propietario;
	public int baños;
	public int habitaciones;
	public boolean permite_mascotas;
	public boolean aire_acondicionado;
	public boolean amueblado;
	public boolean piscina;
	public boolean ascensor;
	public boolean gimnasio;
	public float precio_alquiler; //mensual
	public float precio_venta;
	
	public Piso(int id, String estado, String zona, String direccion, String propietario, int baños, int habitaciones,
			boolean permite_mascotas, boolean aire_acondicionado, boolean amueblado, boolean piscina, boolean ascensor,
			boolean gimnasio, float precio_alquiler, float precio_venta) {
		this.id = id;
		this.estado = estado;
		this.zona = zona;
		this.direccion = direccion;
		this.propietario = propietario;
		this.baños = baños;
		this.habitaciones = habitaciones;
		this.permite_mascotas = permite_mascotas;
		this.aire_acondicionado = aire_acondicionado;
		this.amueblado = amueblado;
		this.piscina = piscina;
		this.ascensor = ascensor;
		this.gimnasio = gimnasio;
		this.precio_alquiler = precio_alquiler;
		this.precio_venta = precio_venta;
	}
	
	public Piso() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public int getBaños() {
		return baños;
	}

	public void setBaños(int baños) {
		this.baños = baños;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public boolean isPermite_mascotas() {
		return permite_mascotas;
	}

	public void setPermite_mascotas(boolean permite_mascotas) {
		this.permite_mascotas = permite_mascotas;
	}

	public boolean isAire_acondicionado() {
		return aire_acondicionado;
	}

	public void setAire_acondicionado(boolean aire_acondicionado) {
		this.aire_acondicionado = aire_acondicionado;
	}

	public boolean isAmueblado() {
		return amueblado;
	}

	public void setAmueblado(boolean amueblado) {
		this.amueblado = amueblado;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public boolean isAscensor() {
		return ascensor;
	}

	public void setAscensor(boolean ascensor) {
		this.ascensor = ascensor;
	}

	public boolean isGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(boolean gimnasio) {
		this.gimnasio = gimnasio;
	}

	public float getPrecio_alquiler() {
		return precio_alquiler;
	}

	public void setPrecio_alquiler(float precio_alquiler) {
		this.precio_alquiler = precio_alquiler;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	

	
}
