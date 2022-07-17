package resolve_test;

import resolve_test.ResolveTest.Carrera;

public class Estudiante {

	public Estudiante() {
		super();
	}
	public Estudiante(Long codigo, String nombre, Carrera carrera, int edad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.carrera = carrera;
		this.edad = edad;
	}
	
	private Long codigo;
	private String nombre;
	private Carrera carrera;
	private int edad;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
