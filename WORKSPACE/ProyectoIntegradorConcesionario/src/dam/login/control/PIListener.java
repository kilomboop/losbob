package dam.login.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dam.login.view.PLogin;
import dam.login.view.VContenedor;
import dam.login.view.VInicial;

public class PIListener implements ActionListener{
	
	private VInicial vi;
	private VContenedor vc;
	private PLogin pli;
	
	public PIListener(VInicial vi, VContenedor vc, PLogin pli) {
		this.vi = vi;
		this.vc = vc;
		this.pli = pli;
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() instanceof JButton) {
			if(ev.getActionCommand().equals(VInicial.BTN_EMPLE)) {
				vi.dispose();
				vc.hacerVisible();
				vc.cargarPanel(pli);
			}
		}
		
	}

}
