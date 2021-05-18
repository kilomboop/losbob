package dam.pic.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.SwingConstants;

public class PListaVehiculosEmple extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnRealizarReservaEmple;
	private JSpinner spnPrecioHastaEmple;
	private JComboBox cmbCombustibleEmple;
	private JRadioButton rdbtnManualEmple;
	private JRadioButton rdbtnAutomaticoEmple;
	private JRadioButton rdbtnTodasEmple;
	private JButton btnAplicarFiltroEmple;
	private JComboBox cmbColorEmple;
	private JList lstVehiculosCli;
	public PListaVehiculosEmple() {
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		setSize(VInicial.ANCHO - 30, VInicial.ALTO - 70);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 36, 303, 212);
		add(scrollPane);
		
		lstVehiculosCli = new JList();
		lstVehiculosCli.setBorder(null);
		lstVehiculosCli.setBackground(SystemColor.control);
		scrollPane.setViewportView(lstVehiculosCli);
		
		JLabel lblListaVehiculosEmple = new JLabel("Lista de Veh\u00EDculos Disponibles");
		lblListaVehiculosEmple.setBounds(137, 11, 203, 14);
		add(lblListaVehiculosEmple);
		
		JLabel lblFiltrosEmple = new JLabel("Filtros");
		lblFiltrosEmple.setBounds(10, 11, 117, 14);
		add(lblFiltrosEmple);
		
		JLabel lblColorEmple = new JLabel("Color:");
		lblColorEmple.setBounds(10, 36, 48, 14);
		add(lblColorEmple);
		
		cmbColorEmple = new JComboBox();
		cmbColorEmple.setModel(new DefaultComboBoxModel(new String[] {"Todos los colores", "Rojo", "Blanco", "Negro", "Azul", "Gris"}));
		cmbColorEmple.setBounds(10, 54, 117, 22);
		add(cmbColorEmple);
		
		btnAplicarFiltroEmple = new JButton("Aplicar Filtros");
		btnAplicarFiltroEmple.setBounds(147, 259, 128, 23);
		add(btnAplicarFiltroEmple);
		
		JLabel lblTransmisionEmple = new JLabel("Transmisi\u00F3n:");
		lblTransmisionEmple.setBounds(10, 87, 117, 14);
		add(lblTransmisionEmple);
		
		rdbtnTodasEmple = new JRadioButton("Todas");
		buttonGroup.add(rdbtnTodasEmple);
		rdbtnTodasEmple.setSelected(true);
		rdbtnTodasEmple.setBounds(10, 104, 109, 23);
		add(rdbtnTodasEmple);
		
		rdbtnAutomaticoEmple = new JRadioButton("Automatico");
		buttonGroup.add(rdbtnAutomaticoEmple);
		rdbtnAutomaticoEmple.setBounds(10, 140, 109, 23);
		add(rdbtnAutomaticoEmple);
		
		rdbtnManualEmple = new JRadioButton("Manual");
		buttonGroup.add(rdbtnManualEmple);
		rdbtnManualEmple.setBounds(10, 122, 109, 23);
		add(rdbtnManualEmple);
		
		JLabel lblCombustibleEmple = new JLabel("Combustible:");
		lblCombustibleEmple.setBounds(10, 169, 117, 14);
		add(lblCombustibleEmple);
		
		cmbCombustibleEmple = new JComboBox();
		cmbCombustibleEmple.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Gasolina", "Diesel", "H\u00EDbrido", "El\u00E9ctrico"}));
		cmbCombustibleEmple.setBounds(10, 194, 117, 22);
		add(cmbCombustibleEmple);
		
		JLabel lblPrecioHastaEmple = new JLabel("Precio Hasta:");
		lblPrecioHastaEmple.setBounds(10, 227, 117, 14);
		add(lblPrecioHastaEmple);
		
		spnPrecioHastaEmple = new JSpinner();
		spnPrecioHastaEmple.setModel(new SpinnerNumberModel(10000, 10000, 100000, 5000));
		spnPrecioHastaEmple.setBounds(10, 247, 117, 20);
		add(spnPrecioHastaEmple);
		
		btnRealizarReservaEmple = new JButton("Realizar Reserva");
		btnRealizarReservaEmple.setBounds(285, 259, 144, 23);
		add(btnRealizarReservaEmple);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(339, 11, 101, 22);
		add(menuBar);
		
		JMenu mnEmple = new JMenu("Men\u00FA Empleado");
		mnEmple.setAlignmentY(Component.TOP_ALIGNMENT);
		mnEmple.setBackground(SystemColor.control);
		menuBar.add(mnEmple);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnEmple.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnEmple.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnEmple.add(mntmNewMenuItem_2);
	}
}
