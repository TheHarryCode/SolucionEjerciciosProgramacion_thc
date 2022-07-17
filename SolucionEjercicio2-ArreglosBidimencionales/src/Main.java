import javax.swing.JOptionPane;

public class Main {

	/*
	Pedir al usuario dos enteros positivo N y M, no mayor a 10. 
	Crear un arreglo de tamaño N x M. 
	Para llenarlo, debe solicitar al usuario un número para llenar todas las posiciones donde los dos índices sean pares (0 es par),
	generar un número al azar entre 11 y 20 para las posiciones donde los índices sean impares,
	y donde los índices se conformen por un par y un impar se debe asignar cero (0). Imprimir el arreglo bidimensional.
	 */

	public static void main(String[] args) {

		//Pedir al usuario dos enteros positivo N y M, no mayor a 10. 
		boolean numeroValido=false;

		int n=0, m=0;

		while(!numeroValido) {
			try {
				n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primero numero del arreglo bidimencional"));
				if(n>10) {
					JOptionPane.showMessageDialog(null, "Numero ingresado no puede ser mayor a 10, vuelvalo a ingresar");
				}else {
					numeroValido=true;
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Numero ingresado invalido, vuelvalo a ingresar");
			}
		}

		numeroValido=false;
		while(!numeroValido) {
			try {
				m = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero del arreglo bidimencional"));
				if(m>10) {
					JOptionPane.showMessageDialog(null, "Numero ingresado no puede ser mayor a 10, vuelvalo a ingresar");
				}else {
					numeroValido=true;
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Numero ingresado invalido, vuelvalo a ingresar");
			}
		}

		//Crear un arreglo de tamaño N x M. 
		int [][] arregloBidi = new int [n][m];

		//solicitar al usuario un número para llenar todas las posiciones donde los dos índices sean pares (0 es par)
		int valorRellenoUsuario =0;
		numeroValido=false;
		while(!numeroValido) {
			try {
				valorRellenoUsuario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de relleno del arreglo"));
				numeroValido=true;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Numero ingresado invalido, vuelvalo a ingresar");
			}
		}

		//llenar Matrix - Arreglo Bidimensional

		//For que pasa por cada fila, 
		for(int fila=0; fila<n; fila++) {

			//for que pasa por cada columna de fila
			for(int colum=0; colum<m;colum++) {

				//llenar posiciones con valor ingresado por el usuario donde los indices sean pares
				if((fila%2==0) && (colum%2==0)) {
					arregloBidi[fila][colum]=valorRellenoUsuario;

					//generar un número al azar entre 11 y 20 para las posiciones donde los índices sean impares
				}else if((fila%2!=0) && (colum%2!=0)) {
					arregloBidi[fila][colum]= (int)Math.floor(Math.random()*(20-11+1)+11);

					//y donde los índices se conformen por un par y un impar se debe asignar cero (0)

					//				}else {
				}else if(((fila%2!=0) && (colum%2==0)) || ((fila%2==0) && (colum%2!=0))) {
					arregloBidi[fila][colum]=0;
				}

			}
		}

		//Imprimir el arreglo bidimensional.
		StringBuilder matrix = new StringBuilder();
		for(int fila=0; fila<n; fila++) {
			for(int colum=0; colum<m;colum++) {
				
				if(arregloBidi[fila][colum]>9) {
					matrix.append(arregloBidi[fila][colum]);
				}else {
					matrix.append(arregloBidi[fila][colum]).append(" ");
				}
				
				
				matrix.append("  ");
			}
			matrix.append("\n");
		}
		
		System.out.println("Arreglo Bidimencional: \n"+matrix.toString());
	}

}
