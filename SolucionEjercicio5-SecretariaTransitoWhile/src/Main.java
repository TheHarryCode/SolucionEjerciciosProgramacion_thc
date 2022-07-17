import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	/*
	 La secretaria de transito de San Gil, desea implementar un programa que indique un estadístico, respeto a los n motos que exceden 
	 la velocidad en la ciudad. Se debe solicitar cuanto se sobrepasó del límite de velocidad permitido (sobre 80 km/h que es el límite) 
	 y también que indique si este exceso de velocidad ocurrió durante la mañana, la tarde o la noche; mostrar un mensaje donde se indique 
	 el número de motos que sobrepasaron el límite permitido por cada periodo del día y el promedio de velocidad de cada periodo. 
	 
	 */
	
	public static void main(String[] args) {

		boolean hayMasMultas=true;
		
		List<Registro> registrosManana = new ArrayList<>();
		List<Registro> registrosTarde = new ArrayList<>();
		List<Registro> registrosNoche = new ArrayList<>();
		Registro registro = new Registro();
		
		int sumVelPerManana=0;
		int sumVelPerTarde=0;
		int sumVelPerNoche=0;
		while(hayMasMultas) {
			
			int velocidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese en cuanto se sobrepaso la velocidad permitida"));
			String periodo = JOptionPane.showInputDialog("Ingrese el periodo:  MAÑANA, TARDE ó NOCHE");
			
			registro.setVelocidad(velocidad);
			
			if("MAÑANA".equalsIgnoreCase(periodo)) {
				registro.setPeriodo(Periodos.MANANA);
				registrosManana.add(registro);
				sumVelPerManana = sumVelPerManana+velocidad;
				
			}else if("TARDE".equalsIgnoreCase(periodo)) {
				registro.setPeriodo(Periodos.TARDE);
				registrosTarde.add(registro);
				sumVelPerTarde = sumVelPerTarde+velocidad;
				
			}else if("NOCHE".equalsIgnoreCase(periodo)) {
				registro.setPeriodo(Periodos.NOCHE);
				registrosNoche.add(registro);
				sumVelPerNoche = sumVelPerNoche+velocidad;
				
			}
			
			hayMasMultas = JOptionPane.showInputDialog("Hay mas comparendos por ingresar? Valores posible: SI o NO").equalsIgnoreCase("SI")
					? true : false;
		}
		
		JOptionPane.showMessageDialog(null, "El numero de motos que sobrepasaron la velocidad permitida en la Mañana fueron: "+registrosManana.size());
		JOptionPane.showMessageDialog(null, "El numero de motos que sobrepasaron la velocidad permitida en la Tarde fueron: "+registrosTarde.size());
		JOptionPane.showMessageDialog(null, "El numero de motos que sobrepasaron la velocidad permitida en la Noche fueron: "+registrosNoche.size());
		
		System.out.println("El promedio de velocidad que se sobrepaso en la Mañana fue: "+sumVelPerManana/registrosManana.size());
		System.out.println("El promedio de velocidad que se sobrepaso en la Tarde fue: "+sumVelPerTarde/registrosTarde.size());
		System.out.println("El promedio de velocidad que se sobrepaso en la Noche fue: "+sumVelPerNoche/registrosNoche.size());
	}
}
