package dam.login.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dam.login.control.PIListener;
import dam.pic.model.Coche;
import dam.pic.model.Reserva;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VConsultaRes extends JFrame {
	private static final String CLM_IDRES = "ID RESERVA";
	private static final String CLM_DNI = "DNI";
	private static final String CLM_IDCOCHE = "ID COCHE";
	private static final String CLM_FECHA = "FECHA DE RESERVA";
	public static final String BTN_VOLVER = "Volver";
	private JTable tblConReserva;
	private JButton btnVolver;
	private DefaultTableModel tblModel;
	public VConsultaRes() {
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 54, 682, 242);
		getContentPane().add(scrollPane);
		
		tblConReserva = new JTable();
		scrollPane.setViewportView(tblConReserva);
		
		JLabel lblNewLabel = new JLabel("Consulta de Reservas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 29, 200, 14);
		getContentPane().add(lblNewLabel);
		
		btnVolver = new JButton(BTN_VOLVER);
		btnVolver.setBounds(604, 331, 89, 23);
		getContentPane().add(btnVolver);
		
		setSize(VInicial.ANCHO + 400,VInicial.ALTO + 170);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VInicial.ANCHO + 300,VInicial.ALTO + 350);
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
		
		tblModel.addColumn(CLM_IDRES);
		tblModel.addColumn(CLM_DNI);
		tblModel.addColumn(CLM_IDCOCHE);
		tblModel.addColumn(CLM_FECHA);
		
		
		tblConReserva.setModel(tblModel);
		
		tblConReserva.getColumn(CLM_IDRES);
		tblConReserva.getColumn(CLM_DNI);
		tblConReserva.getColumn(CLM_IDCOCHE);
		tblConReserva.getColumn(CLM_FECHA);

		
		tblConReserva.setRowHeight(25);
		
	}

	public void setListener(PIListener listener) {
		btnVolver.addActionListener(listener);
		
	}

	public void cargarTabla(ArrayList<Reserva> listaReservas) {
		tblModel.setRowCount(0);
		
		Object[] fila = new Object[8];
		
		for (Reserva reserva : listaReservas) {
			fila[0] = reserva.getId_reserva();
			fila[1] = reserva.getDni();
			fila[2] = reserva.getId_coche();
			fila[3] = reserva.getFecha();
			
			tblModel.addRow(fila);
		}
	}
	
	
}
