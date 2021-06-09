package dam.login.view;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import dam.login.control.PIListener;
import dam.login.view.VInicial;
import dam.pic.model.Coche;

import javax.swing.JTable;

public class PListaVehiculosCli extends JFrame {
	
	private static final String CLM_MARCA = "MARCA";
	private static final String CLM_MODELO = "MODELO";
	private static final String CLM_ANIO = "A�O";
	private static final String CLM_COLOR = "COLOR";
	private static final String CLM_COMBUSTIBLE = "COMBUSTIBLE";
	private static final String CLM_PRECIO = "PRECIO";
	private static final String CLM_TRANSMISION = "TRANSMISION";
	private static final String CLM_EXTRAS = "EXTRAS";
	public static final String BTN_RESERVA = "Realizar Reserva";
	public static final String BTN_APLICAR = "Aplicar filtro";
	public static final String OPT_TODOSCOLOR = "Todos los Colores";
	public static final String OPT_TODOSCOMB = "Todos";
	
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cmbColorCli;
	private JButton btnAplicar;
	private JComboBox cmbCombustibleCli;
	private JSpinner spnPrecioHastaCli;
	private JButton btnReserva;
	private JTable tblVehiculoCli;
	private DefaultTableModel tblModel;
	private DefaultComboBoxModel<String> cmbModel;
	private DefaultComboBoxModel<String> cmbModel2;
	private DefaultComboBoxModel<String> cmbModel3;
	private JRadioButton rdbtnTodosCli;
	private JRadioButton rdbtnAutomaticoCli;
	private JRadioButton rdbtnManualCli;
	public PListaVehiculosCli() {
		initComponents();
	}
	private void initComponents() {
		getContentPane().setLayout(null);
		
		setSize(VInicial.ANCHO + 500, VInicial.ALTO + 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VInicial.ANCHO + 100,VInicial.ALTO + 150);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 36, 691, 246);
		getContentPane().add(scrollPane);
		
		tblVehiculoCli = new JTable();
		scrollPane.setViewportView(tblVehiculoCli);
		
		JLabel lblListaVehiculosCli = new JLabel("Lista de Veh\u00EDculos disponibles");
		lblListaVehiculosCli.setBounds(137, 11, 203, 14);
		getContentPane().add(lblListaVehiculosCli);
		
		JLabel lblFiltrosCli = new JLabel("Filtros");
		lblFiltrosCli.setBounds(10, 11, 117, 14);
		getContentPane().add(lblFiltrosCli);
		
		JLabel lblColorCli = new JLabel("Color:");
		lblColorCli.setBounds(10, 36, 48, 14);
		getContentPane().add(lblColorCli);
		
		cmbColorCli = new JComboBox();
		cmbModel = new DefaultComboBoxModel<String>();
		cmbColorCli.setModel(cmbModel);
		cmbColorCli.setBounds(10, 61, 117, 22);
		getContentPane().add(cmbColorCli);
		
		btnAplicar = new JButton(BTN_APLICAR);
		btnAplicar.setBounds(10, 298, 117, 31);
		getContentPane().add(btnAplicar);
		
		JLabel lblTransmisionCli = new JLabel("Transmisi\u00F3n:");
		lblTransmisionCli.setBounds(10, 97, 117, 14);
		getContentPane().add(lblTransmisionCli);
		
		JLabel lblCombustibleCli = new JLabel("Combustible:");
		lblCombustibleCli.setBounds(10, 179, 117, 14);
		getContentPane().add(lblCombustibleCli);
		
		cmbCombustibleCli = new JComboBox();
		cmbModel2 = new DefaultComboBoxModel<String>();
		cmbCombustibleCli.setModel(cmbModel2);
		cmbCombustibleCli.setBounds(10, 204, 117, 22);
		getContentPane().add(cmbCombustibleCli);
		
		JLabel lblPrecioHastaCli = new JLabel("Precio Hasta:");
		lblPrecioHastaCli.setBounds(10, 237, 117, 14);
		getContentPane().add(lblPrecioHastaCli);
		
		spnPrecioHastaCli = new JSpinner();
		spnPrecioHastaCli.setModel(new SpinnerNumberModel(10000, 10000, 100000, 5000));
		spnPrecioHastaCli.setBounds(10, 262, 117, 20);
		getContentPane().add(spnPrecioHastaCli);
		
		btnReserva = new JButton(BTN_RESERVA);
		btnReserva.setBounds(565, 293, 138, 41);
		getContentPane().add(btnReserva);
		
		rdbtnTodosCli = new JRadioButton("Todas");
		buttonGroup.add(rdbtnTodosCli);
		rdbtnTodosCli.setSelected(true);
		rdbtnTodosCli.setBounds(10, 111, 109, 23);
		getContentPane().add(rdbtnTodosCli);
		
		rdbtnAutomaticoCli = new JRadioButton("Automatico");
		buttonGroup.add(rdbtnAutomaticoCli);
		rdbtnAutomaticoCli.setBounds(10, 129, 109, 23);
		getContentPane().add(rdbtnAutomaticoCli);
		
		rdbtnManualCli = new JRadioButton("Manual");
		buttonGroup.add(rdbtnManualCli);
		rdbtnManualCli.setBounds(10, 149, 109, 23);
		getContentPane().add(rdbtnManualCli);
		cmbModel3 = new DefaultComboBoxModel<String>();
		
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
		
		
		tblVehiculoCli.setModel(tblModel);
		
		tblVehiculoCli.getColumn(CLM_MARCA).setPreferredWidth(25);
		tblVehiculoCli.getColumn(CLM_MODELO).setPreferredWidth(30);
		tblVehiculoCli.getColumn(CLM_ANIO).setPreferredWidth(5);
		tblVehiculoCli.getColumn(CLM_PRECIO).setPreferredWidth(25);
		tblVehiculoCli.getColumn(CLM_COLOR).setPreferredWidth(25);
		tblVehiculoCli.getColumn(CLM_COMBUSTIBLE).setPreferredWidth(65);
		tblVehiculoCli.getColumn(CLM_TRANSMISION).setPreferredWidth(60);
		tblVehiculoCli.getColumn(CLM_EXTRAS).setPreferredWidth(170);
		
		tblVehiculoCli.setRowHeight(25);
		
	}
	public void setListener(PIListener listener) {
		btnReserva.addActionListener(listener);
		btnAplicar.addActionListener(listener);
	}
	public void hacerVisible() {
		setVisible(true);
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
	
	public void cargarCmbColores(ArrayList<String> listaColores) {
		cmbModel.removeAllElements();
		
		cmbModel.addElement(OPT_TODOSCOLOR);
		for (String color : listaColores) {
			cmbModel.addElement(color);
		}
		
	}
	
	public void cargarCmbCombustible(ArrayList<String> listaCombustibles) {
		cmbModel2.removeAllElements();
		
		cmbModel2.addElement(OPT_TODOSCOMB);
		for (String combustible : listaCombustibles) {
			cmbModel2.addElement(combustible);
		}
		
	}
	
	public String getColorFiltro() {
		String color = (String) cmbColorCli.getSelectedItem();
		return color;
	}
	public String getTransmisionFiltro() {
		String transmision = "";
		if(rdbtnTodosCli.isSelected()) {
			transmision = "TODAS";
		} 
		if(rdbtnAutomaticoCli.isSelected()) {
			transmision = "AUTOMATICO";
		} 
		if(rdbtnManualCli.isSelected()) {
			transmision = "MANUAL";
		}
		return transmision;
	}
	public String getCombustibleFiltro() {
		String combustible = (String) cmbCombustibleCli.getSelectedItem();
		return combustible;
	}
	public int getPrecioFiltro() {
		int precio = (int) spnPrecioHastaCli.getValue();
		return precio;
	}
}