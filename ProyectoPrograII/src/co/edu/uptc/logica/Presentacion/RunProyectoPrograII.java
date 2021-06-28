package co.edu.uptc.logica.Presentacion;

import co.edu.uptc.logica.Persistencia.BasedeDatos;
import co.edu.uptc.logica.Persistencia.InicioSesion;
import co.edu.uptc.logica.Persistencia.PagosBancarios;

public class RunProyectoPrograII {

	private static Inicio inicio;
	private static Introduccion introduccion;
	private static Introducci�n2 introducci�n2;
	private static Introducci�n3 introducci�n3;
	private static InicioSesion inicioSesion;
	private static BasedeDatos basededatos;
	private static PagosBancarios pagosBancarios;

	public static void main(String[] args) {

		ConfiguracionPaneles();

	}

	public static void ConfiguracionPaneles() {

		inicio = new Inicio();
		introduccion = new Introduccion();
		introducci�n2 = new Introducci�n2();
		introducci�n3 = new Introducci�n3();
		inicioSesion = new InicioSesion();
		basededatos = new BasedeDatos();
		pagosBancarios = new PagosBancarios();

		if (inicio.isVisible() == true) {

			inicio.setVisible(true);
			introduccion.setVisible(false);
			introducci�n2.setVisible(false);
			introducci�n3.setVisible(false);
			inicioSesion.setVisible(false);
			basededatos.setVisible(false);
			pagosBancarios.setVisible(false);
		}

	}

}
