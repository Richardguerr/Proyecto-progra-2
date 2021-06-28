package co.edu.uptc.ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexionInicioSesion {

	Connection conectar = null;

	public Connection conexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar = DriverManager.getConnection("jdbc:mysql://192.168.0.2/iniciosesion", "GranjaIH", "");
			System.out.println("Conexion Exitosa a base de datos Incio de Sesion");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error Conexion  21" + e.getMessage());
		}

		return conectar;

	}

}
