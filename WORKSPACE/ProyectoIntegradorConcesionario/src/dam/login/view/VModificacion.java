package dam.login.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import dam.login.control.PIListener;
import dam.pic.model.Coche;

public class VModificacion extends JFrame {
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JSpinner spnID;
	private JComboBox<String> cmbTransmision;
	private JComboBox<String> cmbCombustible;
	private JSpinner spnPrecio;
	private JSpinner spnAnio;
	private JTextArea txtaExtras;
	private JButton btnGuardaDatos;
	private JButton btnLimpiarDatos;
	private DefaultComboBoxModel<String> cmbModel2;
	private DefaultComboBoxModel<String> cmbModel;
	public static final String BTN_GUARDAR = "GUARDAR";
	public static final String BTN_LIMPIAR = "CANCELAR";
	public static final String BTN_BUSCAR = "Buscar ID";
	private JButton btnBuscar;
	
	public VModificacion() {
		initComponents();
	}

	private void initComponents() {
		
		setSize(VInicial.ANCHO + 400,VInicial.ALTO + 170);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VInicial.ANCHO + 300,VInicial.ALTO + 350);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);

		
		getContentPane().setLayout(null);
		
		JLabel lblModVehiculo = new JLabel("Modificar Veh\u00EDculo");
		lblModVehiculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModVehiculo.setBounds(26, 11, 137, 22);
		getContentPane().add(lblModVehiculo);
		
		JLabel lblID = new JLabel("ID Veh\u00EDculo:");
		lblID.setBounds(26, 44, 77, 14);
		getContentPane().add(lblID);
		
		spnID = new JSpinner();
		spnID.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		spnID.setBounds(113, 44, 50, 20);
		getContentPane().add(spnID);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(26, 140, 59, 14);
		getContentPane().add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setBounds(95, 137, 111, 20);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(260, 140, 68, 14);
		getContentPane().add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setEnabled(false);
		txtModelo.setBounds(338, 137, 137, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(26, 202, 59, 14);
		getContentPane().add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setEnabled(false);
		txtColor.setBounds(95, 199, 111, 20);
		getContentPane().add(txtColor);
		txtColor.setColumns(10);
		
		JLabel lblTransmision = new JLabel("Transmisi\u00F3n:");
		lblTransmision.setBounds(260, 205, 83, 14);
		getContentPane().add(lblTransmision);
		
		cmbTransmision = new JComboBox();
		cmbTransmision.setEnabled(false);
		String[] trans = {"AUTOMATICO", "MANUAL"};
		cmbModel = new DefaultComboBoxModel<String>(trans);
		cmbTransmision.setModel(cmbModel);
		cmbTransmision.setBounds(353, 198, 122, 22);
		getContentPane().add(cmbTransmision);
		
		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setBounds(26, 258, 77, 14);
		getContentPane().add(lblCombustible);
		
		cmbCombustible = new JComboBox();
		cmbCombustible.setEnabled(false);
		String[] combust = {"GASOLINA", "DIESEL", "HIBRIDO", "ELECTRICO"};
		cmbModel2 = new DefaultComboBoxModel<String>(combust);
		cmbCombustible.setModel(cmbModel2);
		cmbCombustible.setBounds(113, 254, 122, 22);
		getContentPane().add(cmbCombustible);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(26, 97, 59, 14);
		getContentPane().add(lblPrecio);
		
		spnPrecio = new JSpinner();
		spnPrecio.setEnabled(false);
		spnPrecio.setModel(new SpinnerNumberModel(5000, 5000, 150000, 500));
		spnPrecio.setBounds(110, 94, 77, 20);
		getContentPane().add(spnPrecio);
		
		JLabel lblAnio = new JLabel("A\u00F1o:");
		lblAnio.setBounds(243, 97, 48, 14);
		getContentPane().add(lblAnio);
		
		spnAnio = new JSpinner();
		spnAnio.setEnabled(false);
		spnAnio.setModel(new SpinnerNumberModel(1990, 1990, 2022, 1));
		spnAnio.setBounds(301, 94, 77, 20);
		getContentPane().add(spnAnio);
		
		JLabel lblExtras = new JLabel("Extras:");
		lblExtras.setBounds(260, 258, 59, 14);
		getContentPane().add(lblExtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 258, 242, 63);
		getContentPane().add(scrollPane);
		
		txtaExtras = new JTextArea();
		txtaExtras.setEnabled(false);
		txtaExtras.setLineWrap(true);
		scrollPane.setViewportView(txtaExtras);
		
		btnGuardaDatos = new JButton(BTN_GUARDAR);
		btnGuardaDatos.setBounds(137, 332, 137, 31);
		getContentPane().add(btnGuardaDatos);
		
		btnLimpiarDatos = new JButton(BTN_LIMPIAR);
		btnLimpiarDatos.setBounds(358, 332, 137, 31);
		getContentPane().add(btnLimpiarDatos);
		
		btnBuscar = new JButton(BTN_BUSCAR);
		btnBuscar.setBounds(206, 40, 137, 31);
		getContentPane().add(btnBuscar);
	}

	public void hacerVisible() {
		setVisible(true);	
	}

	public void setListener(PIListener listener) {
		btnGuardaDatos.addActionListener(listener);
		btnLimpiarDatos.addActionListener(listener);
		btnBuscar.addActionListener(listener);
		
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
		JOptionPane.showMessageDialog(this, msj, "Error de inserción", JOptionPane.ERROR_MESSAGE);
		
	}

	public void mostrarMsjInfo(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Información de inserción", JOptionPane.INFORMATION_MESSAGE);
		
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
	
		
		habilitarComponentes(false);
	}
	
	public void cargarDatos(Coche coche) { 
		spnID.setValue(coche.getId());
		txtMarca.setText(coche.getMarca());
		txtModelo.setText(coche.getModelo());
		txtColor.setText(coche.getColor());
		spnAnio.setValue(coche.getAnio());
		txtaExtras.setText(coche.getExtras());
		cmbCombustible.setSelectedItem(coche.getCombustible());
		spnPrecio.setValue(coche.getPrecio());
		cmbTransmision.setSelectedItem(coche.getTransmision());	
				
		habilitarComponentes(true);
	}
	
	public void habilitarComponentes(boolean b) { 
		txtColor.setEnabled(b);
		txtaExtras.setEnabled(b);
		spnPrecio.setEnabled(b);
		cmbCombustible.setEnabled(b);
		if(cmbCombustible.getSelectedItem().equals("ELECTRICO") || cmbCombustible.getSelectedItem().equals("HIBRIDO")) { 
			cmbTransmision.setEnabled(false);
		}else if(!cmbCombustible.getSelectedItem().equals("ELECTRICO") && !cmbCombustible.getSelectedItem().equals("HIBRIDO") ) { 

			cmbTransmision.setEnabled(true);
		}
	}
	public int getId() { 
		return (int) spnID.getValue();
	}
}
