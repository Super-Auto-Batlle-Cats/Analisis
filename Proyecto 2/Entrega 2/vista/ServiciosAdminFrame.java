package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServiciosAdminFrame extends JFrame{
	private JPanel panelVolver;
	private JPanel panelAgregarServicio;
	private JPanel panelServicios;
	
	public ServiciosAdminFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(getMaximumSize());
		setLayout(new BorderLayout());
		setTitle("Servicios");
		
		panelAgregarServicio = new JPanel();
		ventanaAgregarServicio(panelAgregarServicio);
		
	}
	
	private void ventanaAgregarServicio(JPanel panelAgregarServicio) {
		panelVolver = new JPanel();
		panelAgregarServicio.setLayout(new GridLayout(10, 5));
		panelAgregarServicio.setBackground(Color.BLUE);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setForeground(Color.white);
		nombre.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JTextField cajaNombre = new JTextField();
		
		JLabel precio = new JLabel("Precio");
		precio.setForeground(Color.white);
		precio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JTextField cajaPrecio = new JTextField();
		
		JButton agregarServicio = new JButton("Agregar servicio");
		agregarServicio.setBackground(Color.CYAN);
		agregarServicio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
		panelAgregarServicio.add(nombre);
		panelAgregarServicio.add(cajaNombre);
		panelAgregarServicio.add(precio);
		panelAgregarServicio.add(cajaPrecio);
		panelAgregarServicio.add(agregarServicio);
		ventanaVolver(panelVolver);
		panelAgregarServicio.add(panelVolver);
		add(panelAgregarServicio, BorderLayout.WEST);
	}
	
	private void ventanaServicios() {
		
	}
	
	private void ventanaVolver(JPanel panelVolver2) {
		panelVolver.setBackground(Color.decode("#7e8c69"));
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBackground(Color.decode("#d0ecf2"));
		
		panelVolver.add(botonVolver);
	}


}
