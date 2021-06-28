package co.edu.uptc.logica.modelo;

public class GranjaIH {

	private int ID;
	private String Fecharegistro;
	private String estado;

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the fecharegistro
	 */
	public String getFecharegistro() {
		return Fecharegistro;
	}

	/**
	 * @param fecharegistro the fecharegistro to set
	 */
	public void setFecharegistro(String fecharegistro) {
		Fecharegistro = fecharegistro;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
