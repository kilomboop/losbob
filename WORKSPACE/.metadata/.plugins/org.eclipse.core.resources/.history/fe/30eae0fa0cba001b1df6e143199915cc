package dam.login.view;

import javax.swing.JFrame;

import dam.login.control.PIListener;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;

public class VInicial extends JFrame {
	
	public static final int ANCHO = 350;
	public static final int ALTO = 250;
	public static final String BTN_CLIENTE = "Acceder como Cliente";
	public static final String BTN_EMPLE = "Acceder como Empleado";
	
	private JButton btnAccesoCli;
	private JButton btnAccesoEmple;
	public VInicial() {
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(null);
		
		setSize(ANCHO, ALTO);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); 
		Dimension ventana = new Dimension(ANCHO, ALTO);         
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
		btnAccesoCli = new JButton(BTN_CLIENTE);
		btnAccesoCli.setBounds(80, 54, 177, 42);
		getContentPane().add(btnAccesoCli);
		
		btnAccesoEmple = new JButton(BTN_EMPLE);
		btnAccesoEmple.setBounds(80, 121, 177, 42);
		getContentPane().add(btnAccesoEmple);
	}

	public void setListener(PIListener listener) {
		btnAccesoCli.addActionListener(listener);
		btnAccesoEmple.addActionListener(listener);
		
	}

	public void hacerVisible() {
		setVisible(true);
		
	}
	
}
