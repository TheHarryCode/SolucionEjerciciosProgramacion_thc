
public class Main {
/*
	Se tiene una matriz de 3 x 3 que contiene números del 1 al 9 simulado con una matriz unidimensional. Así, por ejemplo, esta matriz: 1 2 9 2 5 3 5 1 5
	Se representaría como (1,2,9,2,5,3,5,1,5). El objetivo es identificar el camino que de la menor suma al recorrer el arreglo bi-dimencional de izquierda
	a derecha. Se empieza en la columna izquierda y se mueve siempre una columna a la derecha de la misma fila o a una fila hacia arriba o hacia abajo.
	En el ejemplo, si parte de 1, puede pasar al 2 o al 5. De ahí, si pasó al 5 puede pasar al 9 al 3 o al 5. Por otro lado , si pasa del 1 al 2, desde
	el 2 de la columna del medio no podría pasar al 5 de la ultima fila en la columna derecha.
	Es necesario encontrar el camino que produce el número más bajo al suma los valores de cada número que visita. Así que para el ejemplo, la ruta con la
	menor suma sería 1,2,3
	
	El resultado de su programa debe ser los 3 números por los que paso para obtener la menor suma separados por un espacio. Para el ejemplo, la salida 
	sería exactamente así: 1 2 3

	1	2	9
	2	5	3
	5	1	5

	*/
	public static void main(String[] args) {
		
		int columns=3;
		int filas =3;
		int [][]  matrix = new int [filas][columns];
		matrix[0][0]=1;
		matrix[0][1]=2;
		matrix[0][2]=9;
		matrix[1][0]=2;
		matrix[1][1]=2;
		matrix[1][2]=3;
		matrix[2][0]=5;
		matrix[2][0]=1;
		matrix[2][0]=5;
		
		int posIndexInc=0;
		for(int i=0; i<filas; i++) {
			if(matrix[i][0]<matrix[posIndexInc][0]) {
				posIndexInc=i;
			}
		}
		System.out.print(matrix[posIndexInc][0]+" ");
		
		int posIndexSec=0;
		for(int i=0; i<=(posIndexInc+1); i++) {
			if(matrix[i][1]<matrix[posIndexSec][1]) {
				posIndexSec=i;
			}
		}
		System.out.print(matrix[posIndexSec][1]+" ");
		
		int posIndexTer=0;
		for(int i=0; i<=(posIndexSec+1); i++) {
			if(matrix[i][2]<matrix[posIndexTer][2]) {
				posIndexTer=i;
			}
		}
		
		System.out.print(matrix[posIndexTer][2]);
	}
	
}
