package co.edu.uptc.logica.modelo;

public class Adulta extends Vacas {

	public Adulta() {
		new MostrarDatos().datosVacasAdultas();
	}

	class MostrarDatos {

		public void datosVacasAdultas() {

			System.out.println(getNombre());
			System.out.println(getFecharegistro());
			System.out.println(getEdad());
			System.out.println(getEstado());
		}

	}

	@Override
	public String dependencia() {

		String dependencia = "GranIH";
		return dependencia;
	}

}
