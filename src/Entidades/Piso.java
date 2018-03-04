package Entidades;

public class Piso {

	public int id;
	public String estado;
	public String zona;
	public String direccion;
	public String propietario;
	public int banos;
	public int habitaciones;
	public boolean permite_mascotas;
	public boolean aire_acondicionado;
	public boolean amueblado;
	public boolean piscina;
	public boolean ascensor;
	public boolean gimnasio;
	public float precio_alquiler; //mensual
	public float precio_venta;
	public String img_url;
	
	//test
	public Piso(int id, String estado, String zona, String direccion, String propietario, int banos, int habitaciones,
			boolean permite_mascotas, boolean aire_acondicionado, boolean amueblado, boolean piscina, boolean ascensor,
			boolean gimnasio, float precio_alquiler, float precio_venta,String img_url) {
		this.id = id;
		this.estado = estado;
		this.zona = zona;
		this.direccion = direccion;
		this.propietario = propietario;
		this.banos = banos;
		this.habitaciones = habitaciones;
		this.permite_mascotas = permite_mascotas;
		this.aire_acondicionado = aire_acondicionado;
		this.amueblado = amueblado;
		this.piscina = piscina;
		this.ascensor = ascensor;
		this.gimnasio = gimnasio;
		this.precio_alquiler = precio_alquiler;
		this.precio_venta = precio_venta;
		this.img_url = img_url;
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

	public int getBanos() {
		return banos;
	}

	public void setBanos(int banos) {
		this.banos = banos;
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

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	

	
}
