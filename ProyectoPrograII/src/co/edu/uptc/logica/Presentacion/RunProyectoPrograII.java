package co.edu.uptc.logica.Presentacion;

import co.edu.uptc.logica.Persistencia.BasedeDatos;
import co.edu.uptc.logica.Persistencia.InicioSesion;
import co.edu.uptc.logica.Persistencia.PagosBancarios;

public class RunProyectoPrograII {

	private static Inicio inicio;
	private static Introduccion introduccion;
	private static Introducción2 introducción2;
	private static Introducción3 introducción3;
	private static InicioSesion inicioSesion;
	private static BasedeDatos basededatos;
	private static PagosBancarios pagosBancarios;

	public static void main(String[] args) {

		ConfiguracionPaneles();

	}

	public static void ConfiguracionPaneles() {

		inicio = new Inicio();
		introduccion = new Introduccion();
		introducción2 = new Introducción2();
		introducción3 = new Introducción3();
		inicioSesion = new InicioSesion();
		basededatos = new BasedeDatos();
		pagosBancarios = new PagosBancarios();

		if (inicio.isVisible() == true) {

			inicio.setVisible(true);
			introduccion.setVisible(false);
			introducción2.setVisible(false);
			introducción3.setVisible(false);
			inicioSesion.setVisible(false);
			basededatos.setVisible(false);
			pagosBancarios.setVisible(false);
		}

	}

}
