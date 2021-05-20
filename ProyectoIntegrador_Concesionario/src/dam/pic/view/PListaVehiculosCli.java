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

public class PListaVehiculosCli extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList lstVehiculosCli;
	private JComboBox cmbColorCli;
	private JButton btnAplicarFiltroCli;
	private JRadioButton rdbtnTodasCli;
	private JRadioButton rdbtnAutomaticoCli;
	private JRadioButton rdbtnManualCli;
	private JComboBox cmbCombustibleCli;
	private JSpinner spnPrecioHastaCli;
	private JButton btnRealizarReservaCli;
	public PListaVehiculosCli() {
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
		
		JLabel lblListaVehiculosCli = new JLabel("Lista de Veh\u00EDculos disponibles");
		lblListaVehiculosCli.setBounds(137, 11, 203, 14);
		add(lblListaVehiculosCli);
		
		JLabel lblFiltrosCli = new JLabel("Filtros");
		lblFiltrosCli.setBounds(10, 11, 117, 14);
		add(lblFiltrosCli);
		
		JLabel lblColorCli = new JLabel("Color:");
		lblColorCli.setBounds(10, 36, 48, 14);
		add(lblColorCli);
		
		cmbColorCli = new JComboBox();
		cmbColorCli.setModel(new DefaultComboBoxModel(new String[] {"Todos los colores", "Rojo", "Blanco", "Negro", "Azul", "Gris"}));
		cmbColorCli.setBounds(10, 54, 117, 22);
		add(cmbColorCli);
		
		btnAplicarFiltroCli = new JButton("Aplicar Filtros");
		btnAplicarFiltroCli.setBounds(147, 259, 128, 23);
		add(btnAplicarFiltroCli);
		
		JLabel lblTransmisionCli = new JLabel("Transmisi\u00F3n:");
		lblTransmisionCli.setBounds(10, 87, 117, 14);
		add(lblTransmisionCli);
		
		rdbtnTodasCli = new JRadioButton("Todas");
		buttonGroup.add(rdbtnTodasCli);
		rdbtnTodasCli.setSelected(true);
		rdbtnTodasCli.setBounds(10, 104, 109, 23);
		add(rdbtnTodasCli);
		
		rdbtnAutomaticoCli = new JRadioButton("Automatico");
		buttonGroup.add(rdbtnAutomaticoCli);
		rdbtnAutomaticoCli.setBounds(10, 140, 109, 23);
		add(rdbtnAutomaticoCli);
		
		rdbtnManualCli = new JRadioButton("Manual");
		buttonGroup.add(rdbtnManualCli);
		rdbtnManualCli.setBounds(10, 122, 109, 23);
		add(rdbtnManualCli);
		
		JLabel lblCombustibleCli = new JLabel("Combustible:");
		lblCombustibleCli.setBounds(10, 169, 117, 14);
		add(lblCombustibleCli);
		
		cmbCombustibleCli = new JComboBox();
		cmbCombustibleCli.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Gasolina", "Diesel", "H\u00EDbrido", "El\u00E9ctrico"}));
		cmbCombustibleCli.setBounds(10, 194, 117, 22);
		add(cmbCombustibleCli);
		
		JLabel lblPrecioHastaCli = new JLabel("Precio Hasta:");
		lblPrecioHastaCli.setBounds(10, 227, 117, 14);
		add(lblPrecioHastaCli);
		
		spnPrecioHastaCli = new JSpinner();
		spnPrecioHastaCli.setModel(new SpinnerNumberModel(10000, 10000, 100000, 5000));
		spnPrecioHastaCli.setBounds(10, 247, 117, 20);
		add(spnPrecioHastaCli);
		
		btnRealizarReservaCli = new JButton("Realizar Reserva");
		btnRealizarReservaCli.setBounds(285, 259, 144, 23);
		add(btnRealizarReservaCli);
	}
}
