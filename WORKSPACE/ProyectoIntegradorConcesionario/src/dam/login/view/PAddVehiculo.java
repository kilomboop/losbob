package dam.login.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import dam.login.control.PIListener;
import dam.pic.model.Coche;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PAddVehiculo extends JFrame{
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JSpinner spnID;
	private JComboBox cmbTransmision;
	private JComboBox cmbCombustible;
	private JSpinner spnPrecio;
	private JSpinner spnAnio;
	private JTextArea txtaExtras;
	private JButton btnAddVehiculo;
	private JButton btnLimpiarDatos;
	public static final String BTN_ANIADIR = "A�adir Coche";
	public static final String BTN_LIMPIAR = "Limpiar Datos";
	
	public PAddVehiculo() {
		initComponents();
	}

	private void initComponents() {
		setSize(VInicial.ANCHO + 350, VInicial.ALTO + 200);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VInicial.ANCHO + 100,VInicial.ALTO + 150);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
		
		getContentPane().setLayout(null);
		
		JLabel lblAddVehiculo = new JLabel("A\u00F1adir Veh\u00EDculo");
		lblAddVehiculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddVehiculo.setBounds(26, 39, 137, 22);
		getContentPane().add(lblAddVehiculo);
		
		JLabel lblID = new JLabel("ID Veh\u00EDculo:");
		lblID.setBounds(26, 84, 77, 14);
		getContentPane().add(lblID);
		
		spnID = new JSpinner();
		spnID.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		spnID.setBounds(113, 81, 50, 20);
		getContentPane().add(spnID);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(26, 140, 59, 14);
		getContentPane().add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(95, 137, 111, 20);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(260, 140, 68, 14);
		getContentPane().add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(338, 137, 137, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(26, 202, 59, 14);
		getContentPane().add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setBounds(95, 199, 111, 20);
		getContentPane().add(txtColor);
		txtColor.setColumns(10);
		
		JLabel lblTransmision = new JLabel("Transmisi\u00F3n:");
		lblTransmision.setBounds(260, 205, 83, 14);
		getContentPane().add(lblTransmision);
		
		cmbTransmision = new JComboBox();
		cmbTransmision.setModel(new DefaultComboBoxModel(new String[] {"AUTOMATICO", "MANUAL"}));
		cmbTransmision.setBounds(353, 198, 122, 22);
		getContentPane().add(cmbTransmision);
		
		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setBounds(26, 258, 77, 14);
		getContentPane().add(lblCombustible);
		
		cmbCombustible = new JComboBox();
		cmbCombustible.setModel(new DefaultComboBoxModel(new String[] {"GASOLINA", "DIESEL", "HIBRIDO", "ELECTRICO"}));
		cmbCombustible.setBounds(113, 254, 122, 22);
		getContentPane().add(cmbCombustible);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(260, 84, 59, 14);
		getContentPane().add(lblPrecio);
		
		spnPrecio = new JSpinner();
		spnPrecio.setModel(new SpinnerNumberModel(5000, 5000, 150000, 500));
		spnPrecio.setBounds(318, 81, 77, 20);
		getContentPane().add(spnPrecio);
		
		JLabel lblAnio = new JLabel("A\u00F1o:");
		lblAnio.setBounds(447, 84, 48, 14);
		getContentPane().add(lblAnio);
		
		spnAnio = new JSpinner();
		spnAnio.setModel(new SpinnerNumberModel(1990, 1990, 2022, 1));
		spnAnio.setBounds(491, 81, 77, 20);
		getContentPane().add(spnAnio);
		
		JLabel lblExtras = new JLabel("Extras:");
		lblExtras.setBounds(260, 258, 59, 14);
		getContentPane().add(lblExtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 258, 242, 63);
		getContentPane().add(scrollPane);
		
		txtaExtras = new JTextArea();
		txtaExtras.setLineWrap(true);
		scrollPane.setViewportView(txtaExtras);
		
		btnAddVehiculo = new JButton(BTN_ANIADIR);
		btnAddVehiculo.setBounds(137, 332, 137, 31);
		getContentPane().add(btnAddVehiculo);
		
		btnLimpiarDatos = new JButton(BTN_LIMPIAR);
		btnLimpiarDatos.setBounds(358, 332, 137, 31);
		getContentPane().add(btnLimpiarDatos);
	}

	public void hacerVisible() {
		setVisible(true);
		
	}

	public void setListener(PIListener listener) {
		btnAddVehiculo.addActionListener(listener);
		btnLimpiarDatos.addActionListener(listener);
		
	}

	public Coche getDatos() {
		Coche coche = null;
		
		int id = (int) spnID.getValue();
		int precio = (int) spnPrecio.getValue();
		int anio = (int) spnAnio.getValue();
		String combustible = (String) cmbCombustible.getSelectedItem();
		String transmision = (String) cmbTransmision.getSelectedItem();
		String extras = txtaExtras.getText();
		String marca = txtMarca.getText();
		String modelo = txtModelo.getText();
		String color = txtColor.getText();
		
		if(marca.isEmpty()) {
			mostrarMsjError("Debes introducir la marca");
		} else if(modelo.isEmpty()) {
			mostrarMsjError("Debes introducir el modelo");
		} else if(color.isEmpty()) {
			mostrarMsjError("Debes introducir el color");
		} else {
			coche = new Coche(id, marca, modelo, color, anio, extras, combustible, precio, transmision);
		}
		return coche;
	}

	public void mostrarMsjError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error de inserci�n", JOptionPane.ERROR_MESSAGE);
		
	}

	public void mostrarMsjInfo(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Informaci�n de inserci�n", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void limpiarComponentes() {
		spnID.setValue(1);
		spnPrecio.setValue(5000);
		spnAnio.setValue(1990);
		cmbCombustible.setSelectedIndex(0);
		cmbTransmision.setSelectedIndex(0);
		txtaExtras.setText("");
		txtColor.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		
		
	}
}
