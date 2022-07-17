
public class ListaEnlazada<T> {

	private Nodo<T> primero;

	public void agregarProducto(T t) {
		Nodo<T> aux = new Nodo<>(t);
		Nodo<T> recAux;

		if(estaVacia()) {
			insertarPrimero(t);
		}else {
			recAux = primero;
			
			//Buscamos el ultimo nodo
            while(recAux.getSiguiente() != null){
            	recAux=recAux.getSiguiente();
            } 
                
            //Actualizamos el siguiente del ultimo
            recAux.setSiguiente(aux);
			
		}
	}

	private void insertarPrimero(T t) {
		Nodo<T> primerProducto = new Nodo<>(t);
		primero=primerProducto;
	}

	public boolean estaVacia() {
		return primero == null;
	}
	
	public void mostrarLista(){
        System.out.println("Datos en la Lista \n");
        
        Nodo<T> aux=primero;
        
        while(aux!=null){
        	//Mostrar información del Nodo<Producto>
            System.out.println(aux.getProducto().toString());
            
            //Pasar al siguiente Nodo
            aux=aux.getSiguiente();
        }
        
    }
	
	public void quitarPrimero(){
        Nodo<T> aux;
        if (!estaVacia()){
            aux=primero;
            primero = primero.getSiguiente();
            aux=null;
        }
    }

	public Nodo<T> getPrimero() {
		return primero;
	}

	public void setPrimero(Nodo<T> primero) {
		this.primero = primero;
	}
	
	public int getCantidadElementos(){
        Nodo<T> aux;
        int numElementos=0;
        aux = primero;

        //Recorremos
        while(aux != null){
            numElementos++;
            aux = aux.getSiguiente();
        }
        return numElementos;

    }

}
