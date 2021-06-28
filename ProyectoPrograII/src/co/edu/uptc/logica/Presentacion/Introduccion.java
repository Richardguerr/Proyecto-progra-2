package co.edu.uptc.logica.Presentacion;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Introduccion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Introducción2 introducción2;
	private Inicio inicio;

	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	public Introduccion() {
		setFont(new Font("Brush Script MT", Font.ITALIC, 17));
		setTitle("Introducci\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Introduccion.class.getResource("/imagenes/IconoJframe.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 702);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Introduccion = new JPanel();
		panel_Introduccion.setBackground(new Color(255, 255, 255));
		panel_Introduccion.setBounds(10, 11, 512, 641);
		contentPane.add(panel_Introduccion);
		panel_Introduccion.setLayout(null);

		JLabel lblSuperior = new JLabel("Debemos Cuidarlas..!");
		lblSuperior.setFont(new Font("Script MT Bold", Font.ITALIC, 34));
		lblSuperior.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperior.setBounds(0, 21, 512, 75);
		panel_Introduccion.add(lblSuperior);

		JLabel ImagenVaca = new JLabel("");
		ImagenVaca.setHorizontalAlignment(SwingConstants.CENTER);
		ImagenVaca.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 14));
		ImagenVaca.setIcon(new ImageIcon(Introduccion.class.getResource("/imagenes/Introduccion.png")));
		ImagenVaca.setBounds(100, 97, 318, 412);
		panel_Introduccion.add(ImagenVaca);

		JLabel lblInferior = new JLabel(
				"<html><center>La industria lactea oculta a los consumidores sus<br>  practicas crueles hacia los animales</br></center></html>\r\n");
		lblInferior.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblInferior.setHorizontalAlignment(SwingConstants.CENTER);
		lblInferior.setBounds(10, 534, 492, 68);
		panel_Introduccion.add(lblInferior);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.setBorder(null);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				introducción2 = new Introducción2();
				introducción2.setVisible(true);
			}
		});
		btnSiguiente.setBackground(new Color(255, 255, 255));
		btnSiguiente.setBounds(422, 272, 80, 45);
		btnSiguiente.setIcon(setIcon("/imagenes/Sig.png", btnSiguiente));
		btnSiguiente.setPressedIcon(setIconPresionado("/imagenes/Sig.png", btnSiguiente, 10, 10));
		panel_Introduccion.add(btnSiguiente);

		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				inicio = new Inicio();
				inicio.setVisible(true);
			}
		});
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(10, 272, 80, 45);
		btnAtras.setIcon(setIcon("/imagenes/Atra.png", btnAtras));
		btnAtras.setPressedIcon(setIconPresionado("/imagenes/Atra.png", btnAtras, 10, 10));
		panel_Introduccion.add(btnAtras);
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
