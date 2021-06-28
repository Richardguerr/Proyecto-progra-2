package co.edu.uptc.logica.Presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.logica.Persistencia.InicioSesion;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Introducción3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private InicioSesion inicioSesion;
	private Introducción2 introducción2;

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the frame.
	 */
	public Introducción3() {
		setTitle("Introducci\u00F3n 3");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Introducción3.class.getResource("/imagenes/IconoJframe.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 702);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Introduccion3 = new JPanel();
		panel_Introduccion3.setBackground(Color.WHITE);
		panel_Introduccion3.setBounds(10, 11, 512, 641);
		contentPane.add(panel_Introduccion3);
		panel_Introduccion3.setLayout(null);

		JLabel lblNecesitan_Nuestra_Ayuda = new JLabel("Las vacas son nuestras amigas..!");
		lblNecesitan_Nuestra_Ayuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblNecesitan_Nuestra_Ayuda.setFont(new Font("Script MT Bold", Font.ITALIC, 34));
		lblNecesitan_Nuestra_Ayuda.setBounds(0, 41, 512, 75);
		panel_Introduccion3.add(lblNecesitan_Nuestra_Ayuda);

		JLabel ImagenVaca_Feliz = new JLabel("");
		ImagenVaca_Feliz.setHorizontalAlignment(SwingConstants.CENTER);
		ImagenVaca_Feliz.setIcon(new ImageIcon(Introducción3.class.getResource("/imagenes/Vacahappy.png")));
		ImagenVaca_Feliz.setBounds(71, 138, 372, 328);
		panel_Introduccion3.add(ImagenVaca_Feliz);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicioSesion = new InicioSesion();
				setVisible(false);

				inicioSesion.setVisible(true);
			}
		});
		btnSiguiente.setBorder(null);
		btnSiguiente.setBackground(Color.WHITE);
		btnSiguiente.setBounds(422, 286, 80, 45);
		btnSiguiente.setIcon(setIcon("/imagenes/Sig.png", btnSiguiente));
		btnSiguiente.setPressedIcon(setIconPresionado("/imagenes/Sig.png", btnSiguiente, 10, 10));
		panel_Introduccion3.add(btnSiguiente);

		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				introducción2 = new Introducción2();
				introducción2.setVisible(true);
			}
		});
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(10, 286, 80, 45);
		btnAtras.setIcon(setIcon("/imagenes/Atra.png", btnAtras));
		btnAtras.setPressedIcon(setIconPresionado("/imagenes/Atra.png", btnAtras, 10, 10));
		panel_Introduccion3.add(btnAtras);

		JLabel lblInferior = new JLabel(
				"<html><center>Los animales son seres sensibles con quienes compartimos este planeta. <br> Son nuestros hermanos, nuestros compa\u00F1eros de viaje en la vida.</br></center></html>\r\n ");
		lblInferior.setHorizontalAlignment(SwingConstants.CENTER);
		lblInferior.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblInferior.setBounds(10, 488, 492, 112);
		panel_Introduccion3.add(lblInferior);
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
