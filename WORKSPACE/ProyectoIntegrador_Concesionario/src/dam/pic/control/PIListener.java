package dam.pic.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dam.pic.view.PListaVehiculosCli;
import dam.pic.view.VInicial;

public class PIListener implements ActionListener{
	
	private VInicial vi;
	private PListaVehiculosCli plvc;

	public PIListener(VInicial vi, PListaVehiculosCli plvc) {
		this.vi = vi;
		this.plvc = plvc;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() instanceof JButton) {
			if(ev.getActionCommand().equals(VInicial.BTN_CLIENTE)) {
				vi.cargarPanel(plvc);
			} else if(ev.getActionCommand().equals(VInicial.BTN_EMPLEADO)) {
				vi.mostrarComponentes();
			}
		}
		
	}
	
}
