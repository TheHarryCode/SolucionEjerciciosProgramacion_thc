import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class RetenVehiculos {

	/*
	En determinado reten se desea saber cuántos automóviles y cuantos autobuses pasaron en un día,
	así también el promedio de personas que viajan en automóvil y de personas que viajan en autobús. 
	Por cada vehículo que pasa por el retén,
	se elabora un registro donde se especifica el tipo de vehículo y el número de personas que lo ocupan.
	 */

	public static void main(String[] args) {

		List<Vehiculo> ltVehiculos = new ArrayList<>();

		boolean hayVehiculosEnFila = true;

		do {
			String tipoVehiculo = JOptionPane.showInputDialog("Ingrese tipo de Vehiculo 1: Automovil, 2: AutoBus");
			String numeroPersonas = JOptionPane.showInputDialog("Ingrese el numero de personas en el vehiculo");

			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setNumeroPersonas(Integer.parseInt(numeroPersonas));

			if("1".equals(tipoVehiculo)) {
				vehiculo.setTipoVehiculo(TipoVehiculo.AUTOMOVIL);
			}else if("2".equals(tipoVehiculo)) {
				vehiculo.setTipoVehiculo(TipoVehiculo.AUTOBUS);
			}

			ltVehiculos.add(vehiculo);

			hayVehiculosEnFila = JOptionPane.showInputDialog("Aun hay vehiculos en el reten? S: Si , N: No")
					.equals("S") ? true : false;
		}while(hayVehiculosEnFila);

		System.out.println("Cantidad de Vehiculos que entraron al reten en el día fueron: "+ltVehiculos.size());
		int cantPersonaAutoBus=0;
		int cantPersonaAutoMovil=0;
		int cantAutoBus=0;
		int cantAutoMovil=0;


		for(Vehiculo veh : ltVehiculos) {
			if(veh.getTipoVehiculo()==TipoVehiculo.AUTOMOVIL) {
				cantAutoMovil++;
				cantPersonaAutoMovil = cantPersonaAutoMovil+veh.getNumeroPersonas();
			}else if(veh.getTipoVehiculo()==TipoVehiculo.AUTOBUS) {
				cantAutoBus++;
				cantPersonaAutoBus = cantPersonaAutoBus+veh.getNumeroPersonas();
			}
		}
		
		if(cantAutoMovil>0) {
			System.out.println("El promedio de personas que viajan en AutoMovil es: "+(cantPersonaAutoMovil/cantAutoMovil));
		}

		if(cantAutoBus>0) {
			System.out.println("El promedio de personas que viajan en AutoBus  es: "+(cantPersonaAutoBus/cantAutoBus));
		}

	}

}
