package co.edu.uptc.logica.Presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Inicio extends JFrame {

	private Introduccion introduccion;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Inicio() {

		setBackground(new Color(255, 255, 255));
		setTitle("Inicio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/IconoJframe.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 702);
		setResizable(false);
		this.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Inicio = new JPanel();
		panel_Inicio.setBackground(Color.CYAN);
		panel_Inicio.setBounds(10, 11, 512, 641);
		contentPane.add(panel_Inicio);
		panel_Inicio.setLayout(null);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(Color.WHITE);
		panel_Header.setBounds(10, 22, 492, 119);
		panel_Inicio.add(panel_Header);
		panel_Header.setLayout(null);

		JLabel lblHeader = new JLabel(
				"<html><center>Prototipo IH <br>\r\nSalvemos a las</br><br>\r\n vacas...!</br></center></html>\r\n");
		lblHeader.setBackground(Color.BLACK);
		lblHeader.setBounds(160, 11, 171, 102);
		panel_Header.add(lblHeader);
		lblHeader.setForeground(Color.BLACK);
		lblHeader.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Imagen_Inicio = new JLabel("");
		Imagen_Inicio.setBackground(new Color(153, 255, 255));
		Imagen_Inicio.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/vaca.png")));
		Imagen_Inicio.setBounds(94, 184, 322, 308);
		panel_Inicio.add(Imagen_Inicio);

		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnComenzar.setBackground(new Color(127, 255, 212));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnComenzar.setBackground(new Color(123, 255, 255));
			}
		});
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				introduccion = new Introduccion();
				setVisible(false);

				introduccion.setVisible(true);

			}
		});
		btnComenzar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		btnComenzar.setBorder(null);
		btnComenzar.setBackground(new Color(153, 255, 255));
		btnComenzar.setBounds(10, 544, 492, 55);
		panel_Inicio.add(btnComenzar);

		setVisible(true);
	}
}
