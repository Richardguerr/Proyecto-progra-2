package co.edu.uptc.ConexionSQL;

import java.sql.Connection;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexionSQL {

	Connection conectar = null;

	public Connection conexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar = DriverManager.getConnection("jdbc:mysql://192.168.0.2/granjaih", "GranjaIH", "");
			System.out.println("Conexion Exitosa");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error Conexion    2" + e.getMessage());
		}

		return conectar;

	}
}
