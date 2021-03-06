package dam.pic.view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dam.pic.control.PIListener;
import javax.swing.JScrollPane;

public class VInicial extends JFrame {
	
	public static final int ANCHO = 600;
	public static final int ALTO = 300;
	
	public static final String BTN_CLIENTE = "Acceder como cliente";
	public static final String BTN_EMPLEADO = "Acceder como empleado";
	public static final String BTN_LOGIN = "Log In";
	
	private JTextField txtUsuario;
	private JTextField txtContrasenia;
	private JButton btnLogIn;
	private JLabel lblContrasenia;
	private JLabel lblUsuario;
	private JButton btnEmpleado;
	private JButton btnCliente;
	private JScrollPane scrpContenedor;
	public VInicial() {
		initComponents();
	}
	private void initComponents() {
		getContentPane().setLayout(null);
		
		setSize(ANCHO, ALTO);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); 
		Dimension ventana = new Dimension(ANCHO, ALTO);         
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
		btnCliente = new JButton(BTN_CLIENTE);
		btnCliente.setBounds(30, 60, 207, 52);
		getContentPane().add(btnCliente);
		
		btnEmpleado = new JButton(BTN_EMPLEADO);
		btnEmpleado.setBounds(30, 149, 207, 52);
		getContentPane().add(btnEmpleado);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setVisible(false);
		lblUsuario.setBounds(313, 60, 104, 14);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setVisible(false);
		txtUsuario.setBounds(313, 85, 146, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setVisible(false);
		lblContrasenia.setBounds(313, 116, 104, 14);
		getContentPane().add(lblContrasenia);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setVisible(false);
		txtContrasenia.setBounds(313, 141, 146, 20);
		getContentPane().add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		btnLogIn = new JButton(BTN_LOGIN);
		btnLogIn.setVisible(false);
		btnLogIn.setBounds(340, 178, 89, 23);
		getContentPane().add(btnLogIn);
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(0, 0, 588, 265);
		getContentPane().add(scrpContenedor);
	}
	public void mostrarComponentes() {
		lblUsuario.setVisible(true);
		txtUsuario.setVisible(true);
		lblContrasenia.setVisible(true);
		txtContrasenia.setVisible(true);
		btnLogIn.setVisible(true);
	}
	public void setListener(PIListener listener) {
		btnCliente.addActionListener(listener);
		btnEmpleado.addActionListener(listener);
		btnLogIn.addActionListener(listener);
		
	}
	public void hacerVisible() {
		setVisible(true);
		
	}
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
		btnCliente.setVisible(false);
		btnEmpleado.setVisible(false);
	}
}
