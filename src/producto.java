
public class producto {
	
	protected int id;
	protected String nombre;
	protected float precio;
	protected int cantidad;
	
	public producto () {
	
		this.id=0;
		this.nombre="";
		this.precio=0.0f;
		this.cantidad=0;
	}
	
	public producto (int id, String nom, float pr, int cant) {
		
		this.id=id;
		this.nombre=nom;
		this.precio=pr;
		this.cantidad=cant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
