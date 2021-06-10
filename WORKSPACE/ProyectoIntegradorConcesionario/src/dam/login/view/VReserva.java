package dam.login.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dam.login.control.PIListener;
import dam.pic.model.Cliente;
import dam.pic.model.Coche;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class VReserva extends JFrame {
	private static final String CLM_MARCA = "MARCA";
	private static final String CLM_MODELO = "MODELO";
	private static final String CLM_ANIO = "AÑO";
	private static final String CLM_COLOR = "COLOR";
	private static final String CLM_COMBUSTIBLE = "COMBUSTIBLE";
	private static final String CLM_PRECIO = "PRECIO";
	private static final String CLM_TRANSMISION = "TRANSMISION";
	private static final String CLM_EXTRAS = "EXTRAS";
	public static final String BTN_HACER_RESERVAN = "Registrar y Reservar";
	public static final String BTN_HACER_RESERVAE = "Reservar";
	
	private JTable tblReserva;
	private JTextField textFieldDniReserva;
	private JTextField textFieldApenomReserva;
	private JTextField textFieldDireccionReserva;
	private JTextField textFieldTelefonoReserva;
	private DefaultTableModel tblModel; 
	private JButton btnReserva2;
	private JButton btnReserva;
	
	public VReserva() {
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 45, 771, 137);
		getContentPane().add(scrollPane);
		
		tblReserva = new JTable();
		tblReserva.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblReserva);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(29, 239, 30, 14);
		getContentPane().add(lblNewLabel);
		
		textFieldDniReserva = new JTextField();
		textFieldDniReserva.setBounds(143, 233, 86, 20);
		getContentPane().add(textFieldDniReserva);
		textFieldDniReserva.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre y Apellido");
		lblNewLabel_1.setBounds(29, 208, 117, 14);
		getContentPane().add(lblNewLabel_1);
		
		textFieldApenomReserva = new JTextField();
		textFieldApenomReserva.setBounds(143, 202, 203, 20);
		getContentPane().add(textFieldApenomReserva);
		textFieldApenomReserva.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setBounds(29, 273, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		textFieldDireccionReserva = new JTextField();
		textFieldDireccionReserva.setBounds(143, 267, 317, 20);
		getContentPane().add(textFieldDireccionReserva);
		textFieldDireccionReserva.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(29, 304, 102, 14);
		getContentPane().add(lblNewLabel_3);
		
		textFieldTelefonoReserva = new JTextField();
		textFieldTelefonoReserva.setBounds(143, 298, 102, 20);
		getContentPane().add(textFieldTelefonoReserva);
		textFieldTelefonoReserva.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Reserva de Vehiculos");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(28, 20, 201, 14);
		getContentPane().add(lblNewLabel_4);
		
		btnReserva2 = new JButton(BTN_HACER_RESERVAN);
		btnReserva2.setBounds(640, 210, 160, 43);
		getContentPane().add(btnReserva2);
		
		btnReserva = new JButton(BTN_HACER_RESERVAE);
		btnReserva.setBounds(663, 283, 117, 43);
		getContentPane().add(btnReserva);
		
		JLabel lblNewLabel_5 = new JLabel("Cliente Nuevo:");
		lblNewLabel_5.setBounds(558, 224, 108, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Cliente Existente:");
		lblNewLabel_5_1.setBounds(558, 297, 108, 14);
		getContentPane().add(lblNewLabel_5_1);
		
		
		setSize(VInicial.ANCHO + 500, VInicial.ALTO + 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VInicial.ANCHO + 100,VInicial.ALTO + 150);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
		
		configurarTabla();
	}
	
	
	private void configurarTabla() {
		tblModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				/*if (column == 2) {
					return true;
				} else {*/
					return false;
				//}
			}
		};
		
		tblModel.addColumn(CLM_MARCA);
		tblModel.addColumn(CLM_MODELO);
		tblModel.addColumn(CLM_ANIO);
		tblModel.addColumn(CLM_PRECIO);
		tblModel.addColumn(CLM_COLOR);
		tblModel.addColumn(CLM_COMBUSTIBLE);
		tblModel.addColumn(CLM_TRANSMISION);
		tblModel.addColumn(CLM_EXTRAS);
		
		
		tblReserva.setModel(tblModel);
		
		tblReserva.getColumn(CLM_MARCA).setPreferredWidth(25);
		tblReserva.getColumn(CLM_MODELO).setPreferredWidth(30);
		tblReserva.getColumn(CLM_ANIO).setPreferredWidth(5);
		tblReserva.getColumn(CLM_PRECIO).setPreferredWidth(25);
		tblReserva.getColumn(CLM_COLOR).setPreferredWidth(25);
		tblReserva.getColumn(CLM_COMBUSTIBLE).setPreferredWidth(65);
		tblReserva.getColumn(CLM_TRANSMISION).setPreferredWidth(60);
		tblReserva.getColumn(CLM_EXTRAS).setPreferredWidth(170);
		
		tblReserva.setRowHeight(25);
		
	}
	
	
	public void cargarTabla(ArrayList<Coche> listaCoches) {
		tblModel.setRowCount(0);
		
		Object[] fila = new Object[8];
		
		for (Coche coche : listaCoches) {
			fila[0] = coche.getMarca();
			fila[1] = coche.getModelo();
			fila[2] = coche.getAnio();
			fila[3] = coche.getPrecio();
			fila[4] = coche.getColor();
			fila[5] = coche.getCombustible();
			fila[6] = coche.getTransmision();
			fila[7] = coche.getExtras();
			
			tblModel.addRow(fila);
		}
	}
	
	public Cliente getDatos() {
		Cliente cliente = null;
		String dni = textFieldDniReserva.getText();
		String apenom = textFieldApenomReserva.getText();
		String direccion = textFieldDireccionReserva.getText();
		String telefono = textFieldTelefonoReserva.getText();
		if(dni.isEmpty()) {
			mostrarMsjError("Debes introducir el dni");
		} else if(apenom.isEmpty()) {
			mostrarMsjError("Debes introducir el nombre y apellido");
		} else if(direccion.isEmpty()) {
			mostrarMsjError("Debes introducir la direccion");
		}else if(telefono.isEmpty()) {
			mostrarMsjError("Debes introducir el telefono");
		} 
		else {
			cliente = new Cliente(dni, apenom, direccion, telefono);
		}
		return cliente;
	}
	
	public void mostrarMsjError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
		
	}

	public void setListener(PIListener listener) {
		btnReserva.addActionListener(listener);
		btnReserva2.addActionListener(listener);
		
	}

	public String getDni() {
		String dni = textFieldDniReserva.getText();
		return dni;
	}

	public String getModelo() {
		String modelo = "";
		
		if(tblReserva.getSelectedRow() == -1) { 
			mostrarMsjError("Debe seleccionar el coche que desea reservar");
		}else{ 
			modelo = (String) tblModel.getValueAt(tblReserva.getSelectedRow(), 1);
		}
		return modelo;
	}

	public void mostrarMsjInfo(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Información de reserva", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
