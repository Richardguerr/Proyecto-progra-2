package co.edu.uptc.logica.Presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Introducción2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Introducción3 introducción3;
	private Introduccion introduccion;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Introducción2() {
		setTitle("Introducci\u00F3n 2");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Introducción2.class.getResource("/imagenes/IconoJframe.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 702);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Introduccion2 = new JPanel();
		panel_Introduccion2.setBackground(Color.WHITE);
		panel_Introduccion2.setBounds(10, 11, 512, 641);
		contentPane.add(panel_Introduccion2);
		panel_Introduccion2.setLayout(null);

		JLabel Imagen_Vacatriste = new JLabel("");
		Imagen_Vacatriste.setIcon(new ImageIcon(Introducción2.class.getResource("/imagenes/VacaTriste.png")));
		Imagen_Vacatriste.setHorizontalAlignment(SwingConstants.CENTER);
		Imagen_Vacatriste.setBounds(67, 131, 376, 369);
		panel_Introduccion2.add(Imagen_Vacatriste);

		JLabel lblNecesitan_Nuestra_Ayuda = new JLabel("Necesitan nuestra ayuda..!");
		lblNecesitan_Nuestra_Ayuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblNecesitan_Nuestra_Ayuda.setFont(new Font("Script MT Bold", Font.ITALIC, 34));
		lblNecesitan_Nuestra_Ayuda.setBounds(0, 33, 512, 75);
		panel_Introduccion2.add(lblNecesitan_Nuestra_Ayuda);

		JLabel lblInferior = new JLabel(
				"<html><center>El noventa por ciento de los animales de granja <br>  se cr\u00EDan en granjas Industriales</br></center></html>\r\n");
		lblInferior.setHorizontalAlignment(SwingConstants.CENTER);
		lblInferior.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblInferior.setBounds(10, 529, 492, 68);
		panel_Introduccion2.add(lblInferior);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				introducción3 = new Introducción3();
				introducción3.setVisible(true);

			}
		});
		btnSiguiente.setBorder(null);
		btnSiguiente.setBackground(Color.WHITE);
		btnSiguiente.setBounds(422, 282, 80, 45);
		btnSiguiente.setIcon(setIcon("/imagenes/Sig.png", btnSiguiente));
		btnSiguiente.setPressedIcon(setIconPresionado("/imagenes/Sig.png", btnSiguiente, 10, 10));
		panel_Introduccion2.add(btnSiguiente);

		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				introduccion = new Introduccion();
				introduccion.setVisible(true);

			}
		});
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(10, 282, 80, 45);
		btnAtras.setIcon(setIcon("/imagenes/Atra.png", btnAtras));
		btnAtras.setPressedIcon(setIconPresionado("/imagenes/Atra.png", btnAtras, 10, 10));
		panel_Introduccion2.add(btnAtras);

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
}
