package resolve_test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map.Entry;

public class ResolveTest {

	public enum Carrera
	{
	    INGENIERIA, FILOSOFIA, ADMINISTRACION, DERECHO
	}
	
	/*
	Una universidad tiene n seccionales y cada seccional tiene ne estudiantes. De cada estudiante se conoce: código, nombre, carrera y edad 
	Elaborar un orientado a objetos en java que permita calcular y mostrar: 
    * El promedio de edad de los estudiantes por seccional 
    * El nombre del estudiante con la menor edad (el estudiante mas joven) por seccional
    * El porcentaje de estudiantes con edad entre 18 y 25 años de cada seccional 
    * El nombre del estudiante con la menor edad (el estudiante mas joven) de toda la universidad 
    * El número de estudiantes por carrera de toda la universidad 
	*/
	
	public static void main(String[] args) {
		
		EnumMap<Carrera, Integer> ltEstxCarrera = new EnumMap<>(Carrera.class);
//		Map<Carrera, Integer> ltEstxCarrera = new HashMap<>();
		
		Universidad unisersidad = llenarUniversidad();
		
		Estudiante estudianteMenorUniversidad = unisersidad.getSelecciones().get(0).getEstudiantes().get(0);
		
		for(Seleccion seleccion: unisersidad.getSelecciones()) {
			
			int sumaEdad =0;
			int cantEstBet18y25=0;
			
			Estudiante estudianteMenorSeleccion = seleccion.getEstudiantes().get(0);
			
			for(Estudiante estudianteActual: seleccion.getEstudiantes()) {
				sumaEdad = sumaEdad +estudianteActual.getEdad();
				
				if(estudianteActual.getEdad()<estudianteMenorSeleccion.getEdad()) {
					estudianteMenorSeleccion = estudianteActual;
				}
				
				if(estudianteActual.getEdad()>=18 && estudianteActual.getEdad()<=25) {
					cantEstBet18y25++;
				}
				
				if(ltEstxCarrera.containsKey(estudianteActual.getCarrera())) {
					Integer cont = ltEstxCarrera.get(estudianteActual.getCarrera());
					cont++;
					ltEstxCarrera.put(estudianteActual.getCarrera(), cont);
				}else {
					ltEstxCarrera.put(estudianteActual.getCarrera(), 1);
				}
			}
			
			System.out.println("Seleccion "+seleccion.getNombreSeleccion()+", el promedio de la edad de la seleccion es: "+((double)sumaEdad/(double)seleccion.getEstudiantes().size())); 
			System.out.println("El estudiante menor de la Seleccion es "+estudianteMenorSeleccion.getNombre()+" ,  y tiene "+estudianteMenorSeleccion.getEdad()); 
			System.out.println("El promedio de estudiantes entre 18 y 25 es: "+(((double)cantEstBet18y25/seleccion.getEstudiantes().size())*100));
			System.out.println("**********************************************************************************");
			
			if(estudianteMenorSeleccion.getEdad()<estudianteMenorUniversidad.getEdad()) {
				estudianteMenorUniversidad = estudianteMenorSeleccion;
			}
		}
		
		System.out.println("El estudiante menor de la Universidad es "+estudianteMenorUniversidad.getNombre()+" ,y tiene "+estudianteMenorUniversidad.getEdad()); 
		System.out.println("**********************************************************************************");
		
		//Java 8 --> Lambda
		ltEstxCarrera.forEach((k, v) -> System.out.println("Carrera "+k+" , tiene "+v +" estudiantes en total"));
		System.out.println("**********************************************************************************");
		
		//forEach
		for(Entry<Carrera, Integer> entry : ltEstxCarrera.entrySet()) {
			System.out.println("Carrera: "+entry.getKey()+" , tiene "+entry.getValue()+" en total de estudiantes");
		}
		
	}

	private static Universidad llenarUniversidad() {
		Universidad universidad = new Universidad();
		
		Seleccion seleccion1 = new Seleccion();
		seleccion1.setNombreSeleccion("Seleccion ABC");
		//Agreguemos los estudiantes a la seleccion
		Estudiante estudiante = new Estudiante(1L, "Harry", Carrera.ADMINISTRACION, 12);
		Estudiante estudiante2 = new Estudiante(2L, "Laura", Carrera.ADMINISTRACION, 22);
		Estudiante estudiante3 = new Estudiante(3L, "Melissa", Carrera.FILOSOFIA, 25);
		seleccion1.setEstudiantes(new ArrayList<>());
		seleccion1.getEstudiantes().add(estudiante);
		seleccion1.getEstudiantes().add(estudiante2);
		seleccion1.getEstudiantes().add(estudiante3);
		
		Seleccion seleccion2 = new Seleccion();
		seleccion2.setNombreSeleccion("Seleccion BETTER");
		//Agreguemos los estudiantes a la seleccion
		Estudiante estudiante4 = new Estudiante(4L, "Luis", Carrera.DERECHO, 21);
		Estudiante estudiante5 = new Estudiante(5L, "Carlos", Carrera.INGENIERIA, 26);
		Estudiante estudiante6 = new Estudiante(6L, "Mateo", Carrera.INGENIERIA, 13);
		seleccion2.setEstudiantes(new ArrayList<>());
		seleccion2.getEstudiantes().add(estudiante4);
		seleccion2.getEstudiantes().add(estudiante5);
		seleccion2.getEstudiantes().add(estudiante6);
		
		universidad.setSelecciones(new ArrayList<>());
		universidad.getSelecciones().add(seleccion1);
		universidad.getSelecciones().add(seleccion2);
		return universidad;
	}
	
}
