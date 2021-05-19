package dam.login.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class VEmpleado extends JFrame {
	private JMenuItem mntmModReservas;
	private JScrollPane scrpEmp;
	public VEmpleado() {
		
		crearMenu();
		init();
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmModReservas = new JMenuItem("Modificaci\u00F3n de Reservas");
		menuBar.add(mntmModReservas);
		
		JMenuItem mntm = new JMenuItem("Modificaci\u00F3n de Veh\u00EDculos");
		menuBar.add(mntm);
	}

	private void init() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpEmp = new JScrollPane();
		getContentPane().add(scrpEmp, BorderLayout.CENTER);
		
		setSize(VInicial.ANCHO + 300,VInicial.ALTO + 350);
		

		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VInicial.ANCHO + 300,VInicial.ALTO + 350);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
	}
	
	public void hacerVisible() { 
		setVisible(true);
	}
}
