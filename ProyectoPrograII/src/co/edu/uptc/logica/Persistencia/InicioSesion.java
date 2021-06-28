package co.edu.uptc.logica.Persistencia;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.ConexionSQL.ConexionInicioSesion;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import java.sql.ResultSet;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class InicioSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Nombre_Usuario;
	private JTextField txtExampleuptceduco;

	private JPasswordField Contraseña;
	private String nombreusario;
	private BasedeDatos basedeDatos;
	private ConexionInicioSesion cc ;
	private Connection con;
	public String usuario;

	public InicioSesion() {
		setTitle("Iniciar Sesi\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/imagenes/IconoJframe.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 702);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Inicio_Sesion = new JPanel();
		panel_Inicio_Sesion.setToolTipText("Usuario");
		panel_Inicio_Sesion.setBackground(Color.CYAN);
		panel_Inicio_Sesion.setBounds(10, 11, 512, 641);
		contentPane.add(panel_Inicio_Sesion);
		panel_Inicio_Sesion.setLayout(null);

		JLabel lblIniciar_Sesion = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciar_Sesion.setBounds(0, 21, 512, 37);
		lblIniciar_Sesion.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 23));
		lblIniciar_Sesion.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Inicio_Sesion.add(lblIniciar_Sesion);

		JLabel Imagen_Iniciar_Sesion = new JLabel("");
		Imagen_Iniciar_Sesion.setIcon(new ImageIcon(InicioSesion.class.getResource("/imagenes/LogoSesion.png")));
		Imagen_Iniciar_Sesion.setHorizontalAlignment(SwingConstants.CENTER);
		Imagen_Iniciar_Sesion.setBounds(162, 84, 180, 180);
		panel_Inicio_Sesion.add(Imagen_Iniciar_Sesion);

		JLabel Imagen_Usuario = new JLabel("");
		Imagen_Usuario.setHorizontalAlignment(SwingConstants.CENTER);
		Imagen_Usuario.setIcon(new ImageIcon(InicioSesion.class.getResource("/imagenes/LogoInicio.png")));
		Imagen_Usuario.setBounds(117, 302, 50, 50);
		panel_Inicio_Sesion.add(Imagen_Usuario);

		Nombre_Usuario = new JTextField("Nombre de Usuario");
		Nombre_Usuario.setFont(new Font("Papyrus", Font.ITALIC, 16));
		Nombre_Usuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Nombre_Usuario.setText(null);
			}

		});
		Nombre_Usuario.setToolTipText("");
		Nombre_Usuario.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre_Usuario.setBounds(177, 314, 196, 38);
		panel_Inicio_Sesion.add(Nombre_Usuario);
		Nombre_Usuario.setColumns(10);

		JLabel imagen_contraseña = new JLabel("");
		imagen_contraseña.setIcon(new ImageIcon(InicioSesion.class.getResource("/imagenes/Password.png")));
		imagen_contraseña.setHorizontalAlignment(SwingConstants.CENTER);
		imagen_contraseña.setBounds(101, 445, 70, 37);
		panel_Inicio_Sesion.add(imagen_contraseña);

		JLabel Correo = new JLabel("");
		Correo.setIcon(new ImageIcon(InicioSesion.class.getResource("/imagenes/correo.png")));
		Correo.setHorizontalAlignment(SwingConstants.CENTER);
		Correo.setBounds(109, 381, 58, 42);
		panel_Inicio_Sesion.add(Correo);

		txtExampleuptceduco = new JTextField("example@uptc.edu.co");
		txtExampleuptceduco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtExampleuptceduco.setText(null);
			}
		});
		txtExampleuptceduco.setToolTipText("");
		txtExampleuptceduco.setHorizontalAlignment(SwingConstants.CENTER);
		txtExampleuptceduco.setFont(new Font("Papyrus", Font.ITALIC, 16));
		txtExampleuptceduco.setColumns(10);
		txtExampleuptceduco.setBounds(176, 381, 196, 38);
		panel_Inicio_Sesion.add(txtExampleuptceduco);

		JButton btnIniciar_Sesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciar_Sesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnIniciar_Sesion.setBackground(new Color(127, 255, 212));
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnIniciar_Sesion.setBackground(new Color(123, 255, 255));
			}
		});
		btnIniciar_Sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				iniciarSesion();
			}
		});
		btnIniciar_Sesion.setBackground(new Color(153, 255, 255));
		btnIniciar_Sesion.setBorder(null);
		btnIniciar_Sesion.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		btnIniciar_Sesion.setBounds(29, 547, 447, 50);
		panel_Inicio_Sesion.add(btnIniciar_Sesion);

		JLabel lblNewLabel_4 = new JLabel("@uptc.edu.co");
		lblNewLabel_4.setFont(new Font("Papyrus", Font.ITALIC, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(368, 381, 108, 38);
		panel_Inicio_Sesion.add(lblNewLabel_4);

		Contraseña = new JPasswordField("Contraseña");
		Contraseña.setHorizontalAlignment(SwingConstants.CENTER);
		Contraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Contraseña.setText(null);
			}
		});
		Contraseña.setBounds(177, 444, 196, 38);
		panel_Inicio_Sesion.add(Contraseña);
	}

	public void iniciarSesion() {
		 cc = new ConexionInicioSesion();
		 con = cc.conexion();

		basedeDatos = new BasedeDatos();

		int resultado = 0;
		nombreusario = Nombre_Usuario.getText();
		String correo = txtExampleuptceduco.getText() + "@uptc.edu.co";
		String contraseña = String.valueOf(Contraseña.getPassword());
		String SQL = "select * from tabladatos where NombreUsuario='" + nombreusario + "' and Correo='" + correo
				+ "' and Contraseña='" + contraseña + "' ";

		try {

			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);

			if (rs.next()) {

				resultado = 1;

				if (resultado == 1) {

					JOptionPane.showMessageDialog(null,
							"Bienvenid@ " + mostrarNombreusuario() + " a la base de datos GranjaIh..!");
					setVisible(false);

					basedeDatos.setVisible(true);

				}

			} else {

				Nombre_Usuario.setText(null);
				txtExampleuptceduco.setText(null);
				Contraseña.setText(null);

				JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario no Registrado");

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}

	}

	public String mostrarNombreusuario() {

		 cc = new ConexionInicioSesion();
		 con = cc.conexion();

		usuario = new String();

		try {

			String SQ = "select * from tabladatos where NombreUsuario='" + nombreusario + "'";

			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQ);

			if (rs.next()) {

				usuario = rs.getString("NombreUsuario");

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error A " + e.getMessage());
		}
		return usuario;

	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
