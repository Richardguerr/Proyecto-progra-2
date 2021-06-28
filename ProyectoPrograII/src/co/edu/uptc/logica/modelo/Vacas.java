package co.edu.uptc.logica.modelo;

public abstract class Vacas extends GranjaIH {

	private String Nombre;
	private String Edad;

	public abstract String dependencia();

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return the edad
	 */
	public String getEdad() {
		return Edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(String edad) {
		Edad = edad;
	}

}
