package co.edu.uptc.logica.control;

import java.util.ArrayList;

import co.edu.uptc.logica.modelo.Adulta;
import co.edu.uptc.logica.modelo.Jovenes;
import co.edu.uptc.logica.modelo.Ternero;

public class Nomina {

	private ArrayList<Ternero> VacasTerneras;
	private ArrayList<Jovenes> VacasJovenes;
	private ArrayList<Adulta> VacasAdultas;
	private int Contadorglobal = 0;

	public Nomina() {

		VacasTerneras = new ArrayList<Ternero>();
		VacasJovenes = new ArrayList<Jovenes>();
		VacasAdultas = new ArrayList<Adulta>();
	}

	public void CrearVacasTernerasGranjaIH(String nombre, String FechaRegistro, String Edad, String Estado) {

		Ternero t = new Ternero();

		t.setID(Contadorglobal + 1);
		t.setNombre(nombre);
		t.setFecharegistro(FechaRegistro);
		t.setEdad(Edad);
		t.setEstado(Estado);

		VacasTerneras.add(t);

	}

	public void CrearVacasJovenesGranjaIH(String nombre, String FechaRegistro, String Edad, String Estado) {

		Jovenes j = new Jovenes();

		j.setID(Contadorglobal + 1);
		j.setNombre(nombre);
		j.setFecharegistro(FechaRegistro);
		j.setEdad(Edad);
		j.setEstado(Estado);

		VacasJovenes.add(j);

	}

	public void CrearVacasAdultasGranjaIH(String nombre, String FechaRegistro, String Edad, String Estado) {

		Adulta a = new Adulta();

		a.setID(Contadorglobal + 1);
		a.setNombre(nombre);
		a.setFecharegistro(FechaRegistro);
		a.setEdad(Edad);
		a.setEstado(Estado);

		VacasAdultas.add(a);

	}

	/**
	 * @return the vacasTerneras
	 */
	public ArrayList<Ternero> getVacasTerneras() {
		return VacasTerneras;
	}

	/**
	 * @param vacasTerneras the vacasTerneras to set
	 */
	public void setVacasTerneras(ArrayList<Ternero> vacasTerneras) {
		VacasTerneras = vacasTerneras;
	}

	/**
	 * @return the vacasJovenes
	 */
	public ArrayList<Jovenes> getVacasJovenes() {
		return VacasJovenes;
	}

	/**
	 * @param vacasJovenes the vacasJovenes to set
	 */
	public void setVacasJovenes(ArrayList<Jovenes> vacasJovenes) {
		VacasJovenes = vacasJovenes;
	}

	/**
	 * @return the vacasAdultas
	 */
	public ArrayList<Adulta> getVacasAdultas() {
		return VacasAdultas;
	}

	/**
	 * @param vacasAdultas the vacasAdultas to set
	 */
	public void setVacasAdultas(ArrayList<Adulta> vacasAdultas) {
		VacasAdultas = vacasAdultas;
	}

}
