package co.edu.uptc.logica.modelo;

public class Ternero extends Vacas {

	public Ternero() {

		new MostrarDatos().datosVacasTerneras();

	}

	class MostrarDatos {

		public void datosVacasTerneras() {

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
