
public class Nodo<T> {

	private T producto;
	private Nodo<T> siguiente;

	public Nodo(){
        siguiente=null;
     }
	
	public Nodo(T p){
        siguiente=null;
        producto = p;
    }
	
	public Nodo(T t, Nodo<T> siguiente){
        this.siguiente=siguiente;
        producto = t;
    }

	public T getProducto() {
		return producto;
	}

	public void setProducto(T producto) {
		this.producto = producto;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
	
}
