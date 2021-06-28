package co.edu.uptc.ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexionCuentasBancarias {

	Connection conectar = null;

	public Connection conexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar = DriverManager.getConnection("jdbc:mysql://192.168.0.2/datosbancarios", "GranjaIH", "");
			System.out.println("Conexion Exitosa a base de datos Cuentas Bancarias");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error Conexion  23" + e.getMessage());
		}

		return conectar;

	}

}
