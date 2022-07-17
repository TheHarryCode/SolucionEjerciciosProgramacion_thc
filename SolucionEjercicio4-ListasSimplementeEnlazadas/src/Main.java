import javax.swing.JOptionPane;

public class Main {
	
	/*
	Realizar una lista enlazada que permita el ingreso de los datos de un producto en un supermercado por medio de nodos,
	el nodo debe manejar: nombreProducto, cantidad, vlrProducto. Los nodos se deben ingresar por el inicio. La aplicacion
	debe permitir buscar un producto y mostrar su nombre, cantidad, vlrProducto y total de inventario (cantidad*valor).
	Realizar una funcion que recorrar la lista y retorne el promedio de las cantidades de los productos.
	*/
	
	public static void main(String[] args) {
		
		//Realizar una lista enlazada que permita el ingreso de los datos de un producto en un supermercado por medio de nodos
		
		//El nodo debe manejar: nombreProducto, cantidad, vlrProducto. Los nodos se deben ingresar por el inicio.
		ListaEnlazada<Producto> listaProductos= agregarProductos();
		
		//Mostramos la lista
		listaProductos.mostrarLista(); 
		
        //La aplicacion	debe permitir buscar un producto
        String nombreProductoBuscar = JOptionPane.showInputDialog("Que producto desea buscar?");
        
        //La aplicacion	debe permitir buscar un producto y mostrar su nombre, cantidad, vlrProducto y total de inventario (cantidad*valor)
        //Realizar una funcion que recorrar la lista y retorne el promedio de las cantidades de los productos.
        
        //Creo una lista auxiliar para modificarla mientras la recorro
        ListaEnlazada<Producto> listaProductosAux = agregarProductos();
        
        //Creo la variable sumatoria
        int sumatoriaCantidades=0;
        
        //Hasta que no este vacia, se recorre
        while(!listaProductosAux.estaVacia()) {
        	
        	//Le agrego a sumatoria la cantidad de productos, que hay en el nodo actual.
        	sumatoriaCantidades=sumatoriaCantidades+listaProductosAux.getPrimero().getProducto().getCantidad();
        	
        	//aprovecho para validar si el nodo actual, es el producto que busca el usuario, e imprimo su informacion
        	if(nombreProductoBuscar.equalsIgnoreCase(listaProductosAux.getPrimero().getProducto().getNombre())) {
        		System.out.println("Info del producto indicado: "+listaProductosAux.getPrimero().getProducto().toString());
        	}
        	
        	listaProductosAux.quitarPrimero();
        }
        
        //Finalmente imprimo el promedio de las cantidades
        System.out.println("Sumatorio de cantidades "+sumatoriaCantidades);
        System.out.println("Registros en la Lista "+listaProductos.getCantidadElementos());
        System.out.println("Promedio de las cantidad de los producto: "+(sumatoriaCantidades/listaProductos.getCantidadElementos()));
	
	}
	
	private static ListaEnlazada<Producto> agregarProductos() {
		ListaEnlazada<Producto> listaProductos=new ListaEnlazada<>();
		listaProductos.agregarProducto(new Producto("Gaseosa", 100, 4500));
		listaProductos.agregarProducto(new Producto("Pizza", 20, 3000));
		listaProductos.agregarProducto(new Producto("Manzada", 200, 1000));
		listaProductos.agregarProducto(new Producto("Arroz", 20, 3000));
		listaProductos.agregarProducto(new Producto("Leche", 10, 2500));
		return listaProductos;
	}
}
