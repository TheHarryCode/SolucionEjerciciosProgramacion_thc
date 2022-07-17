
public class Producto {

	private String nombre;
	private int cantidad;
	private int vlrProducto;
	
	public Producto(String nombre, int cantidad, int vlrProducto) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.vlrProducto = vlrProducto;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getVlrProducto() {
		return vlrProducto;
	}

	public void setVlrProducto(int vlrProducto) {
		this.vlrProducto = vlrProducto;
	}

	public int getTotalInventario() {
		return this.cantidad*this.vlrProducto;
	}

	
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", cantidad=" + cantidad + ", vlrProducto=" + vlrProducto +", valorTotalInventario "+getTotalInventario() + "]";
	}

	
}
