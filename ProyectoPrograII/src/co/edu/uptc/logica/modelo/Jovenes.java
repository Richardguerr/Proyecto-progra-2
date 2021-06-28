package co.edu.uptc.logica.modelo;

public class Jovenes extends Vacas {
	
	
	class MostrarDatos{
		
		
		public void datosVacasJovenes() {
			
			System.out.println(getNombre());
			System.out.println(getFecharegistro());
			System.out.println(getEdad());
			System.out.println(getEstado());
		}
		
	}
	
	public Jovenes() {
		
		new MostrarDatos().datosVacasJovenes();
		
	}
	


	@Override
	public String dependencia() {
		String dependencia = "GranIH";
		return dependencia;
	}
	
	

}
