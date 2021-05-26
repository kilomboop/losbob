package dam.login.view;


import javax.swing.JTextField;

import dam.login.control.PIListener;
import dam.pic.model.Empleado;

import javax.swing.JPasswordField;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PLogin extends JFrame{
	public static final String BTN_LOGIN ="LOGIN";
	private JTextField txtUsuario;
	private JPasswordField pswdContrasenia;
	private JButton btnLogin;
	public PLogin() {
		init();
	}
	private void init() {
		setLayout(null);
		
		setSize(VInicial.ANCHO + 100, VInicial.ALTO + 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(133, 79, 158, 32);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pswdContrasenia = new JPasswordField();
		pswdContrasenia.setBounds(133, 155, 158, 32);
		add(pswdContrasenia);
		
		btnLogin = new JButton(BTN_LOGIN);
		btnLogin.setBounds(203, 203, 89, 23);
		add(btnLogin);
		
		JLabel lblTitLogin = new JLabel("INICIO DE SESI\u00D3N EMPLEADO");
		lblTitLogin.setBounds(10, 24, 430, 14);
		add(lblTitLogin);
		
		JLabel lblUser = new JLabel("Usuario/ID");
		lblUser.setBounds(133, 54, 98, 14);
		add(lblUser);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a/Password");
		lblPassword.setBounds(133, 131, 158, 14);
		add(lblPassword);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VInicial.ANCHO + 100,VInicial.ALTO + 150);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
		
		
	}
	public void setListener(PIListener listener) {
		btnLogin.addActionListener(listener);
	}
	
	public Empleado getDatos() { 
		Empleado emp = null;
	
		String id = txtUsuario.getText().trim();
		if(id.isEmpty()) { 
			mostrarMsgError("Habra que introducir un ID");
		}else { 
			String pwd = pswdContrasenia.getText().trim();

			if(pwd.isEmpty()) { 
				mostrarMsgError("Habra que introducir un Contraseña");
			}else { 
				emp = new Empleado(id,pwd);

			}
		}
		
		return emp;
	}
	public void mostrarMsgInfo(String msg) {
		JOptionPane.showMessageDialog(this, msg, "INFO", JOptionPane.INFORMATION_MESSAGE);
		
	}
	public void mostrarMsgError(String msg) {
		JOptionPane.showMessageDialog(this, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void hacerVisible() { 
		setVisible(true);
	}
}
