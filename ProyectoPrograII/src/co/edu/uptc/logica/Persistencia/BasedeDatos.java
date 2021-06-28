package co.edu.uptc.logica.Persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import co.edu.uptc.ConexionSQL.ConexionSQL;
import co.edu.uptc.logica.Presentacion.Inicio;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import javax.swing.JTable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

import java.util.*;
import javax.swing.border.MatteBorder;

import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class BasedeDatos extends JFrame implements Runnable {

	private JLabel lblHora;
	private String hora, minutos, segundos;
	Thread hilo;

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTable tablaih;
	private JTextField txtBuscar;
	@SuppressWarnings("rawtypes")
	private JComboBox cbEdad;
	@SuppressWarnings("rawtypes")
	private JComboBox cbEstado;
	private JDateChooser dateChooser;

	private PagosBancarios pagosBancarios;
	public JLabel lblRecaudado;
	private ConexionSQL cc;
	private Connection con;
	private Inicio inicio;
	private InicioSesion inicioSesion;

	/**
	 * Launch the application.
	 */

	
	/**
	 * Create the frame.
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BasedeDatos() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(BasedeDatos.class.getResource("/imagenes/IconoJframe.png")));
		setTitle("Base de datos IHGranja");

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 598);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Ingreso_Datos = new JPanel();
		panel_Ingreso_Datos.setBounds(5, 11, 331, 537);
		panel_Ingreso_Datos.setBackground(Color.CYAN);
		contentPane.add(panel_Ingreso_Datos);
		panel_Ingreso_Datos.setLayout(null);

		tablaih = new JTable();
		tablaih.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		tablaih.setBackground(new Color(255, 255, 255));
		tablaih.setBounds(366, 122, 453, 152);
		tablaih.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		tablaih.setForeground(Color.BLACK);

		tablaih.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {

				int fileseleccionado = tablaih.rowAtPoint(evt.getPoint());
				txtNombre.setText(tablaih.getValueAt(fileseleccionado, 1).toString());

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd")
							.parse((String) tablaih.getValueAt(fileseleccionado, 2));
					dateChooser.setDate(date);
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, e);
				}

				cbEdad.setSelectedItem(tablaih.getValueAt(fileseleccionado, 3));
				cbEstado.setSelectedItem(tablaih.getValueAt(fileseleccionado, 4));
			}

		});

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(33, 78, 83, 45);
		lblNombre.setBackground(Color.CYAN);
		lblNombre.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		panel_Ingreso_Datos.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(155, 88, 136, 30);
		panel_Ingreso_Datos.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblFecha_Registro = new JLabel("Fecha Registro:");
		lblFecha_Registro.setBounds(23, 155, 136, 45);
		lblFecha_Registro.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		panel_Ingreso_Datos.add(lblFecha_Registro);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(33, 230, 83, 45);
		lblEdad.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		panel_Ingreso_Datos.add(lblEdad);

		cbEdad = new JComboBox();
		cbEdad.setBounds(155, 238, 136, 30);
		cbEdad.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		cbEdad.setModel(new DefaultComboBoxModel(new String[] { "Ternero", "Joven", "Adulta" }));
		panel_Ingreso_Datos.add(cbEdad);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(33, 307, 83, 45);
		lblEstado.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		panel_Ingreso_Datos.add(lblEstado);

		cbEstado = new JComboBox();
		cbEstado.setBounds(155, 315, 136, 30);
		cbEstado.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		cbEstado.setModel(new DefaultComboBoxModel(new String[] { "Bueno", "Regular", "Critico" }));
		panel_Ingreso_Datos.add(cbEstado);

		JButton btnNuevo = new JButton("");
		btnNuevo.addKeyListener(new KeyAdapter() {

		});
		btnNuevo.addMouseListener(new MouseAdapter() {

		});
		btnNuevo.setBounds(69, 363, 67, 70);
		btnNuevo.setIcon(setIcon("/imagenes/Limpiar.png", btnNuevo));
		btnNuevo.setBorder(null);
		btnNuevo.setPressedIcon(setIconPresionado("/imagenes/Limpiar.png", btnNuevo, 10, 10));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LimpiarCajas();
			}
		});
		panel_Ingreso_Datos.add(btnNuevo);
		btnNuevo.setForeground(new Color(0, 0, 0));
		btnNuevo.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNuevo.setBackground(Color.CYAN);

		JButton btnEliminar = new JButton("");
		btnEliminar.setBounds(69, 444, 72, 77);
		btnEliminar.setBorder(null);
		btnEliminar.setIcon(setIcon("/imagenes/Delete.png", btnEliminar));
		btnEliminar.setPressedIcon(setIconPresionado("/imagenes/Delete.png", btnEliminar, 10, 10));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EliminarRegistros();
				MostrarDatos();
				LimpiarCajas();
			}
		});
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminar.setBackground(Color.CYAN);
		panel_Ingreso_Datos.add(btnEliminar);

		JButton btnGuardar = new JButton("");
		btnGuardar.addMouseListener(new MouseAdapter() {

		});
		btnGuardar.setBounds(186, 372, 67, 61);
		btnGuardar.setIcon(setIcon("/imagenes/Guardar.png", btnGuardar));
		btnGuardar.setPressedIcon(setIconPresionado("/imagenes/Guardar.png", btnGuardar, 10, 10));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InsertarDatos();
				MostrarDatos();
			}
		});
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(Color.CYAN);
		panel_Ingreso_Datos.add(btnGuardar);

		JButton btnActualizar = new JButton("");
		btnActualizar.setBounds(186, 451, 72, 70);
		btnActualizar.setBorder(null);
		btnActualizar.setIcon(setIcon("/imagenes/Actualizar.png", btnActualizar));
		btnActualizar.setPressedIcon(setIconPresionado("/imagenes/Actualizar.png", btnActualizar, 10, 10));

		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ActualizarDatos();
				LimpiarCajas();
				MostrarDatos();
			}
		});
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnActualizar.setBackground(Color.CYAN);
		panel_Ingreso_Datos.add(btnActualizar);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(new Color(255, 255, 255));
		panel_Header.setBounds(23, 21, 282, 36);
		panel_Ingreso_Datos.add(panel_Header);
		panel_Header.setLayout(null);

		JLabel lbl_Header = new JLabel("Base de Datos GranjaIH");
		lbl_Header.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 15));
		lbl_Header.setBackground(new Color(255, 255, 255));
		lbl_Header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Header.setBounds(1, 2, 280, 33);
		panel_Header.add(lbl_Header);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(155, 166, 136, 30);
		dateChooser.setDateFormatString("yyyy/MM/dd");
		panel_Ingreso_Datos.add(dateChooser);

		JPanel panel_Base_Datos = new JPanel();
		panel_Base_Datos.setBackground(new Color(255, 255, 255));
		panel_Base_Datos.setBounds(346, 97, 554, 350);
		contentPane.add(panel_Base_Datos);
		panel_Base_Datos.setLayout(null);

		JLabel lblBusqueda = new JLabel("Busqueda:");
		lblBusqueda.setBounds(132, 28, 73, 23);
		panel_Base_Datos.add(lblBusqueda);
		lblBusqueda.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));

		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(0, 62, 554, 236);
		panel_Base_Datos.add(scrollBar);
		scrollBar.setBackground(new Color(255, 255, 255));
		scrollBar.setViewportView(tablaih);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(224, 26, 223, 28);
		panel_Base_Datos.add(txtBuscar);
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				FiltrarDatos(txtBuscar.getText());
			}
		});
		txtBuscar.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		txtBuscar.setBackground(new Color(255, 255, 255));
		txtBuscar.setColumns(10);

		JLabel lblDonaciones = new JLabel("Donaciones: Totales:");
		lblDonaciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblDonaciones.setFont(new Font("Papyrus", Font.ITALIC, 18));
		lblDonaciones.setBounds(20, 309, 191, 30);
		panel_Base_Datos.add(lblDonaciones);

		lblRecaudado = new JLabel();

		lblRecaudado.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecaudado.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 18));
		lblRecaudado.setBounds(195, 309, 157, 30);
		panel_Base_Datos.add(lblRecaudado);

		JLabel lblCop = new JLabel();
		lblCop.setText("$COP");
		lblCop.setHorizontalAlignment(SwingConstants.LEFT);
		lblCop.setFont(new Font("Papyrus", Font.ITALIC, 18));
		lblCop.setBounds(356, 309, 157, 30);
		panel_Base_Datos.add(lblCop);

		JButton btnAtras = new JButton("");
		btnAtras.setBounds(565, 458, 88, 88);
		contentPane.add(btnAtras);

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Su sesion ha finalizado!");

				inicioSesion = new InicioSesion();
				setVisible(false);
				inicioSesion.setVisible(true);
			}
		});
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setBorder(null);
		btnAtras.setIcon(setIcon("/imagenes/CerrarSesion.png", btnAtras));
		btnAtras.setPressedIcon(setIconPresionado("/imagenes/CerrarSesion.png", btnAtras, 10, 10));

		JButton btnSiguiente = new JButton("");
		btnSiguiente.setBounds(676, 458, 88, 88);
		contentPane.add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicio = new Inicio();
				setVisible(false);
				inicio.setVisible(true);
			}
		});
		btnSiguiente.setBackground(new Color(255, 255, 255));
		btnSiguiente.setBorder(null);

		btnSiguiente.setIcon(setIcon("/imagenes/Inicio.png", btnSiguiente));
		btnSiguiente.setPressedIcon(setIconPresionado("/imagenes/Inicio.png", btnSiguiente, 10, 10));

		JPanel panel_Hora_Fecha = new JPanel();
		panel_Hora_Fecha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Hora_Fecha.setBounds(515, 11, 232, 75);
		contentPane.add(panel_Hora_Fecha);
		panel_Hora_Fecha.setBackground(new Color(255, 255, 255));
		panel_Hora_Fecha.setLayout(null);

		JLabel Fecha = new JLabel("Fecha");
		Fecha.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 19));
		Fecha.setBounds(33, 11, 92, 34);
		panel_Hora_Fecha.add(Fecha);

		JLabel lblFecha = new JLabel("dd/mm/yyyy");
		lblFecha.setText(Fecha());
		lblFecha.setFont(new Font("Papyrus", Font.ITALIC, 19));
		lblFecha.setBounds(10, 48, 141, 22);
		panel_Hora_Fecha.add(lblFecha);

		JLabel Hora = new JLabel("Hora");
		Hora.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 19));
		Hora.setBounds(152, 11, 83, 34);
		panel_Hora_Fecha.add(Hora);

		hilo = new Thread(this);
		hilo.start();

		lblHora = new JLabel("00:00:00");
		lblHora.setFont(new Font("Papyrus", Font.ITALIC, 19));
		lblHora.setBounds(135, 44, 111, 30);
		panel_Hora_Fecha.add(lblHora);

		JButton btnAyudar = new JButton("");
		btnAyudar.setBackground(Color.WHITE);
		btnAyudar.setBorder(null);
		btnAyudar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Desea apoyar a GranjaIH con su donación ?",
						"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (respuesta == JOptionPane.YES_OPTION) {

					pagosBancarios = new PagosBancarios();
					setVisible(false);

					pagosBancarios.setVisible(true);

				} else {

				}

			}
		});

		btnAyudar.setBounds(442, 465, 102, 78);

		btnAyudar.setIcon(setIcon("/imagenes/Ayudar.png", btnAyudar));
		btnAyudar.setPressedIcon(setIconPresionado("/imagenes/Ayudar.png", btnAyudar, 10, 10));
		contentPane.add(btnAyudar);

		JButton btnSalir = new JButton("");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(786, 458, 89, 88);
		btnSalir.setBorder(null);
		btnSalir.setIcon(setIcon("/imagenes/Salir.png", btnSalir));
		btnSalir.setPressedIcon(setIconPresionado("/imagenes/Salir.png", btnSalir, 10, 10));
		contentPane.add(btnSalir);

		MostrarDatos();

	}

	public void ActualizarDatos() {

		try {

			cc = new ConexionSQL();
			con = cc.conexion();

			String SQL = " update tablaih set NombreVaca=?, FechadeRegistro=?,Edad=?,Estado=? where NumerodeRegistro=? ";

			int filaseleccionada = tablaih.getSelectedRow();
			String dao = (String) tablaih.getValueAt(filaseleccionada, 0);

			PreparedStatement pst = con.prepareStatement(SQL);

			pst.setString(1, txtNombre.getText());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String date = sdf.format(dateChooser.getDate());
			pst.setString(2, date);

			int seleccionados = cbEdad.getSelectedIndex();
			pst.setString(3, (String) cbEdad.getItemAt(seleccionados));

			int seleccionado1 = cbEstado.getSelectedIndex();
			pst.setString(4, (String) cbEstado.getItemAt(seleccionado1));

			pst.setString(5, dao);
			pst.execute();

			JOptionPane.showMessageDialog(null, "Registro Editado Exitoso");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de Edicion " + e.getMessage());
		}

	}

	public void InsertarDatos() {

		cc = new ConexionSQL();
		con = cc.conexion();

		try {

			String SQL = "insert into tablaih (NombreVaca,FechadeRegistro,Edad,Estado) values(?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(SQL);

			pst.setString(1, txtNombre.getText());

			pst.setString(2, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());

			int seleccionados = cbEdad.getSelectedIndex();
			pst.setString(3, (String) cbEdad.getItemAt(seleccionados));

			int seleccionado1 = cbEstado.getSelectedIndex();
			pst.setString(4, (String) cbEstado.getItemAt(seleccionado1));

			pst.execute();

			JOptionPane.showMessageDialog(null, "Registro Exitoso");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
		}

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

	public void LimpiarCajas() {

		txtNombre.setText("");
		dateChooser.setCalendar(null);
		cbEdad.setSelectedItem(null);
		cbEstado.setSelectedItem(null);

	}

	public void MostrarDatos() {

		cc = new ConexionSQL();
		con = cc.conexion();

		String[] titulos = { "ID", "NombreVaca", "FechadeRegistro", "Edad", "Estado" };
		String[] registros = new String[5];

		DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		String SQL = "select * from tablaih";

		try {

			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);

			while (rs.next()) {
				registros[0] = rs.getString("NumerodeRegistro");
				registros[1] = rs.getString("NombreVaca");
				registros[2] = rs.getString("FechadeRegistro");
				registros[3] = rs.getString("Edad");
				registros[4] = rs.getString("Estado");

				modelo.addRow(registros);

			}

			tablaih.setModel(modelo);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al mostrar datos!" + e.getMessage());
		}
	}

	public void EliminarRegistros() {

		int fileseleccionada = tablaih.getSelectedRow();

		cc = new ConexionSQL();
		con = cc.conexion();
		try {

			String SQL = "delete from tablaih where NumerodeRegistro=" + tablaih.getValueAt(fileseleccionada, 0);

			java.sql.Statement st = con.createStatement();

			int n = st.executeUpdate(SQL);

			if (n >= 0) {

				JOptionPane.showMessageDialog(null, "Registro Eliminado");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Eliminar Registro" + e.getMessage());
		}

	}

	public void FiltrarDatos(String valor) {

		cc = new ConexionSQL();
		con = cc.conexion();
		String[] titulos = { "ID", "NombreVaca", "FechadeRegistro", "Edad", "Estado" };
		String[] registros = new String[5];

		DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		String SQL = "select * from tablaih where NombreVaca like '%" + valor + "%'";

		try {

			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);

			while (rs.next()) {
				registros[0] = rs.getString("NumerodeRegistro");
				registros[1] = rs.getString("NombreVaca");
				registros[2] = rs.getString("FechadeRegistro");
				registros[3] = rs.getString("Edad");
				registros[4] = rs.getString("Estado");

				modelo.addRow(registros);

			}

			tablaih.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al mostrar datos!" + e.getMessage());
		}
	}

	public static String Fecha() {

		Date fecha = new Date();
		SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
		return formatofecha.format(fecha);

	}

	public void hora() {

		Calendar calendario = new GregorianCalendar();
		Date horaactual = new Date();
		calendario.setTime(horaactual);
		hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
				: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);

	}

	@Override
	public void run() {

		Thread current = Thread.currentThread();

		while (current == hilo) {

			hora();
			lblHora.setText(hora + ":" + minutos + ":" + segundos);

		}

	}
}
