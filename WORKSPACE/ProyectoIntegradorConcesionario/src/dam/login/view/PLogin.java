package dam.login.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import dam.login.control.PIListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PLogin extends JPanel{
	private JTextField txtUsuario;
	private JPasswordField pswdContrasenia;
	private JButton btnLogin;
	public PLogin() {
		setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(133, 79, 158, 32);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pswdContrasenia = new JPasswordField();
		pswdContrasenia.setBounds(133, 156, 158, 32);
		add(pswdContrasenia);
		
		btnLogin = new JButton("Log In");
		btnLogin.setBounds(169, 219, 89, 23);
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
	}
	public void setListener(PIListener listener) {
		btnLogin.addActionListener(listener);
		
	}
}
