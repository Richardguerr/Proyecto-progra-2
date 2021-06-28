package co.edu.uptc.logica.Persistencia;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.ConexionSQL.ConexionCuentasBancarias;
import co.edu.uptc.ConexionSQL.ConexionDonaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagosBancarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_pagos;
	private JTextField textField_Donacion;
	private JTextField textField_Tarjeta;
	private JTextField textField_Caducidad;
	private JTextField textField_CVV;

	private String cvv = "";
	public String donacion;
	private ConexionCuentasBancarias cc;
	private Connection con;
	private ConexionDonaciones dd;

	private BasedeDatos basedeDatos;
	private int donacionestotales;

	private int donacionih;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PagosBancarios() {

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(PagosBancarios.class.getResource("/imagenes/IconoJframe.png")));
		setTitle("Pagos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 551, 440);
		setResizable(false);
		panel_pagos = new JPanel();
		panel_pagos.setBackground(Color.WHITE);
		panel_pagos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel_pagos);
		panel_pagos.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 515, 379);
		panel_pagos.add(panel);
		panel.setLayout(null);

		JButton btnPagar = new JButton("");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Pagos();

			}
		});
		btnPagar.setBounds(390, 267, 115, 101);
		panel.add(btnPagar);
		btnPagar.setBackground(Color.LIGHT_GRAY);
		btnPagar.setIcon(setIcon("/imagenes/Pagos.png", btnPagar));
		btnPagar.setPressedIcon(setIconPresionado("/imagenes/Pagos.png", btnPagar, 10, 10));

		JLabel lblDonación_1 = new JLabel("Donaci\u00F3n:");
		lblDonación_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDonación_1.setFont(new Font("Papyrus", Font.ITALIC, 13));
		lblDonación_1.setBounds(51, 265, 156, 21);
		panel.add(lblDonación_1);

		textField_Donacion = new JTextField();
		textField_Donacion.setColumns(10);
		textField_Donacion.setBounds(53, 287, 126, 36);
		panel.add(textField_Donacion);

		textField_Tarjeta = new JTextField();
		textField_Tarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Tarjeta.setColumns(10);
		textField_Tarjeta.setBounds(52, 131, 323, 36);
		panel.add(textField_Tarjeta);

		textField_Caducidad = new JTextField();
		textField_Caducidad.setColumns(10);
		textField_Caducidad.setBounds(52, 208, 132, 36);
		panel.add(textField_Caducidad);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PagosBancarios.class.getResource("/imagenes/tarjetas.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(194, 11, 150, 66);
		panel.add(lblNewLabel_1);

		JLabel lblNumeroTarjeta_1 = new JLabel("N\u00FAmero de Tarjeta:");
		lblNumeroTarjeta_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroTarjeta_1.setFont(new Font("Papyrus", Font.ITALIC, 13));
		lblNumeroTarjeta_1.setBounds(52, 107, 156, 21);
		panel.add(lblNumeroTarjeta_1);

		JLabel lblFecha_caducidad_1 = new JLabel("Fecha de Expedici\u00F3n");
		lblFecha_caducidad_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha_caducidad_1.setFont(new Font("Papyrus", Font.ITALIC, 13));
		lblFecha_caducidad_1.setBounds(52, 189, 156, 21);
		panel.add(lblFecha_caducidad_1);

		JLabel lblCVV = new JLabel("CVV");
		lblCVV.setHorizontalAlignment(SwingConstants.LEFT);
		lblCVV.setFont(new Font("Papyrus", Font.ITALIC, 13));
		lblCVV.setBounds(219, 189, 156, 21);
		panel.add(lblCVV);

		textField_CVV = new JTextField();
		textField_CVV.setColumns(10);
		textField_CVV.setBounds(212, 208, 132, 36);
		panel.add(textField_CVV);
		setLocationRelativeTo(null);
	}

	public Icon setIcon(String url, JButton boton) {

		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int ancho = boton.getWidth();
		int alto = boton.getHeight();

		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));

		return icono;
	}

	public Icon setIconPresionado(String url, JButton boton, int ancho, int altura) {

		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int width = boton.getWidth() - ancho;
		int height = boton.getHeight() - altura;

		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));

		return icono;

	}

	public Boolean ActualizarSaldo() {

		cc = new ConexionCuentasBancarias();
		con = cc.conexion();

		Boolean continuartransaccion = null;

		try {
			int saldo[] = new int[1];
			donacionih = Integer.parseInt(donacion);

			String SQL = " update cuentasbancarias set Saldo=Saldo-'" + donacionih + "' where CVV='" + cvv + "'";
			String SQ = "select * from cuentasbancarias where CVV='" + cvv + "'";

			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQ);

			// String SQL2 = "select * from cuentasbancarias where Saldo='" + saldo[0]+ "'
			// and CVV='"+cvv
			// + "'";
			// ResultSet rt = st.executeQuery(SQL2);

			if (rs.next()) {

				saldo[0] = rs.getInt("Saldo");

				if (donacionih > saldo[0]) {

					JOptionPane.showMessageDialog(null, "Saldo Insuficiente , transacción finalizada!");
					continuartransaccion = true;

				} else {

					PreparedStatement pst = con.prepareStatement(SQL);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Pago realizado Correctamente!");
					continuartransaccion = false;

				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error A " + e.getMessage());
		}
		return continuartransaccion;

	}

	public void Pagos() {

		cc = new ConexionCuentasBancarias();
		con = cc.conexion();

		basedeDatos = new BasedeDatos();
		int resultado = 0;
		String tarjeta = textField_Tarjeta.getText();
		String caducidad = textField_Caducidad.getText();
		cvv = textField_CVV.getText();
		donacion = textField_Donacion.getText();

		String SQL = "select * from cuentasbancarias where NumeroCuenta='" + tarjeta + "' and FechaExpedicion='"
				+ caducidad + "' and CVV='" + cvv + "' ";

		try {

			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);

			if (rs.next()) {

				resultado = 1;

				if (resultado == 1) {

					if (ActualizarSaldo() == false) {

						InsertarDatos();
						SumaDonaciones();

						JOptionPane.showMessageDialog(null,

								"Gracias por su donación , trabajaremos mas duro para mejorar nuestros servicios!!");
						setVisible(false);
						basedeDatos.setVisible(true);

					} else {

						SumaDonaciones();
						setVisible(false);
						basedeDatos.setVisible(true);

					}

				}

			} else {

				JOptionPane.showMessageDialog(null, "Error de Acceso, Cuenta Bancaria no encontrada!");

				setVisible(false);
				basedeDatos.setVisible(true);

				textField_Tarjeta.setText(null);
				textField_Caducidad.setText(null);
				textField_CVV.setText(null);
				textField_Donacion.setText(null);

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}

	}

	public void InsertarDatos() {

		dd = new ConexionDonaciones();
		Connection cond = dd.conexion();

		try {

			String SQL = "insert into tabladonaciones (Donaciones) values(?)";

			PreparedStatement pst = cond.prepareStatement(SQL);

			pst.setString(1, textField_Donacion.getText());

			pst.execute();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
		}

	}

	public String SumaDonaciones() {

		dd = new ConexionDonaciones();
		Connection cond = dd.conexion();

		basedeDatos = new BasedeDatos();

		int[] registros = new int[1];

		String SQL = "select * from tabladonaciones";

		try {

			java.sql.Statement st = cond.createStatement();
			ResultSet rs = st.executeQuery(SQL);

			while (rs.next()) {
				registros[0] = rs.getInt("Donaciones");
				donacionestotales += registros[0];

			}
			donacion = String.valueOf(donacionestotales);
			basedeDatos.lblRecaudado.setText(donacion);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al mostrar datos!" + e.getMessage());
		}
		return donacion;
	}

}
