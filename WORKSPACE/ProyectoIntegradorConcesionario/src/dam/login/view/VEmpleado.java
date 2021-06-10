package dam.login.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dam.login.control.PIListener;
import dam.pic.model.Coche;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class VEmpleado extends JFrame {
	private static final String CLM_ID = "ID";
	private static final String CLM_MARCA = "MARCA";
	private static final String CLM_MODELO = "MODELO";
	private static final String CLM_ANIO = "A�O";
	private static final String CLM_COLOR = "COLOR";
	private static final String CLM_COMBUSTIBLE = "COMBUSTIBLE";
	private static final String CLM_PRECIO = "PRECIO";
	private static final String CLM_TRANSMISION = "TRANSMISION";
	private static final String CLM_EXTRAS = "EXTRAS";
	public static final String MNTM_CORESERVA = "Consulta de Reservas";
	public static final String MNTM_MODVEHICULOS = "Modificaci�n de Veh�culos";
	public static final String BTN_ADD = "A�adir Nuevo Vehiculo";
	public static final String BTN_ELIMINAR = "Eliminar Veh�culo";
	
	
	private DefaultTableModel tblModel;
	private JMenuItem mntmCoReservas;
	private JTable tblVehiculosEmple;
	private JMenuItem mntmModVehiculos;
	private JButton btnAddVehiculo;
	private JButton btnEliminarVehiculo;
	public VEmpleado() {
		
		crearMenu();
		init();
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmCoReservas = new JMenuItem(MNTM_CORESERVA);
		menuBar.add(mntmCoReservas);
		
		mntmModVehiculos = new JMenuItem(MNTM_MODVEHICULOS);
		menuBar.add(mntmModVehiculos);
		getContentPane().setLayout(null);
		
	}

	private void init() {
		
		setSize(VInicial.ANCHO + 400,VInicial.ALTO + 170);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VInicial.ANCHO + 300,VInicial.ALTO + 350);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
		
		JLabel lblListaEmple = new JLabel("Lista de Veh\u00EDculos");
		lblListaEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaEmple.setBounds(10, 11, 153, 14);
		getContentPane().add(lblListaEmple);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 718, 240);
		getContentPane().add(scrollPane);
		
		tblVehiculosEmple = new JTable();
		tblVehiculosEmple.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblVehiculosEmple);
		
		btnEliminarVehiculo = new JButton(BTN_ELIMINAR);
		btnEliminarVehiculo.setBounds(403, 287, 173, 39);
		getContentPane().add(btnEliminarVehiculo);
		
		btnAddVehiculo = new JButton(BTN_ADD);
		btnAddVehiculo.setBounds(158, 287, 173, 39);
		getContentPane().add(btnAddVehiculo);
		
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
		
		tblModel.addColumn(CLM_ID);
		tblModel.addColumn(CLM_MARCA);
		tblModel.addColumn(CLM_MODELO);
		tblModel.addColumn(CLM_ANIO);
		tblModel.addColumn(CLM_PRECIO);
		tblModel.addColumn(CLM_COLOR);
		tblModel.addColumn(CLM_COMBUSTIBLE);
		tblModel.addColumn(CLM_TRANSMISION);
		tblModel.addColumn(CLM_EXTRAS);
		
		
		tblVehiculosEmple.setModel(tblModel);
		
		tblVehiculosEmple.getColumn(CLM_ID).setPreferredWidth(5);
		tblVehiculosEmple.getColumn(CLM_MARCA).setPreferredWidth(25);
		tblVehiculosEmple.getColumn(CLM_MODELO).setPreferredWidth(30);
		tblVehiculosEmple.getColumn(CLM_ANIO).setPreferredWidth(5);
		tblVehiculosEmple.getColumn(CLM_PRECIO).setPreferredWidth(25);
		tblVehiculosEmple.getColumn(CLM_COLOR).setPreferredWidth(25);
		tblVehiculosEmple.getColumn(CLM_COMBUSTIBLE).setPreferredWidth(65);
		tblVehiculosEmple.getColumn(CLM_TRANSMISION).setPreferredWidth(60);
		tblVehiculosEmple.getColumn(CLM_EXTRAS).setPreferredWidth(170);
		
		tblVehiculosEmple.setRowHeight(25);
		
	}
	
	public void cargarTabla(ArrayList<Coche> listaCoches) {
		tblModel.setRowCount(0);
		
		Object[] fila = new Object[9];
		
		for (Coche coche : listaCoches) {
			fila[0] = coche.getId();
			fila[1] = coche.getMarca();
			fila[2] = coche.getModelo();
			fila[3] = coche.getAnio();
			fila[4] = coche.getPrecio();
			fila[5] = coche.getColor();
			fila[6] = coche.getCombustible();
			fila[7] = coche.getTransmision();
			fila[8] = coche.getExtras();
			
			tblModel.addRow(fila);
		}
	}
	
	public void hacerVisible() { 
		setVisible(true);
	}

	public String getCocheSelect() {
		String numCoche = "";
		
		if(tblVehiculosEmple.getSelectedRow() == -1) { 
			mostrarMsjError("Debe seleccionar el coche que desea eliminar");
		}else{ 
			numCoche = (String) tblModel.getValueAt(tblVehiculosEmple.getSelectedRow(), 1);
		}
		return numCoche;
	}

	public void mostrarMsjError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);

		
	}

	public void mostrarMsjInfo(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Informaci�n de borrado", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void setListener(PIListener listener) {
		btnAddVehiculo.addActionListener(listener);
		btnEliminarVehiculo.addActionListener(listener);
		mntmModVehiculos.addActionListener(listener);
		mntmCoReservas.addActionListener(listener);
		
	}
}
