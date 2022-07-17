import javax.swing.JOptionPane;

public class Main {

	/*
	Crear un programa que solicite que ingrese el salario de n empleados y que vaya acumulando el total de dichos salarios leidos,
	el programa debera detener la lectura  de salarios mediante una variable bandera que pregunte si desea leer otro salario, el
	ciclo repetitivo debera ser controlado por dicha variable bandera la cual podra tener valores S o N, es decir, si o no,
	se desea continuar con el cliclo repetitivo, al final que muestre la suma total de los salarios leidos.
	*/
	
	public static void main(String[] args) {
		
		int sumatoriaSalarios=0;
		String pedirMasSalarios;
		
		do {
			int valorSalario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del salario del empleado"));
			sumatoriaSalarios= sumatoriaSalarios + valorSalario;
			
			pedirMasSalarios = JOptionPane.showInputDialog("Desea ingresar mas salarios?, Ingrese S para Si, o N para No");
		}while("S".equals(pedirMasSalarios));
		
		System.out.println("Sumatoria de Salarios: "+sumatoriaSalarios);
	}
	
}
