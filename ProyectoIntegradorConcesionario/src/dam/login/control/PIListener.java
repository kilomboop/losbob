package dam.login.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dam.login.db.Persistencias;
import dam.login.view.PListaVehiculosCli;
import dam.login.view.PLogin;
import dam.login.view.VEmpleado;
import dam.login.view.VInicial;
import dam.pic.model.Empleado;

public class PIListener implements ActionListener{
static final int INTENTOS = 3;
	
	private PListaVehiculosCli plvc;
	private int contIntent = 0;
	private VInicial vi;
	private PLogin pli;
	private Persistencias modelo;
	private VEmpleado empl;
	
	public PIListener(VInicial vi,  PLogin pli, VEmpleado empl, PListaVehiculosCli plvc) {
		this.vi = vi;
		this.pli = pli;
		this.empl = empl;
		this.plvc = plvc;
		
		modelo = new Persistencias();
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() instanceof JButton) {
			if(ev.getActionCommand().equals(VInicial.BTN_EMPLE)) {
				vi.dispose();
				pli.hacerVisible();
			}else if(ev.getActionCommand().equals(PLogin.BTN_LOGIN)) { 
				Empleado emp = pli.getDatos();
				
				if (emp != null) { 
					String pwdDB = modelo.getPassword(emp.getId_empleado());
					
					if(pwdDB == null) { 
					pli.mostrarMsgError("El usuario indicado no existe");
					}else { 
					   if(pwdDB.equals(emp.getContrasenia())) { 
						   pli.dispose();
						   empl.hacerVisible();
						pli.mostrarMsgInfo("SESION INICIADA");

						   
					   } else {
							contIntent++;
							pli.mostrarMsgError("La contrase�a no es v�lida. Te quedan " 
												+ (INTENTOS - contIntent) + " intentos");
							if (contIntent == INTENTOS) {
								System.exit(0);
							}
					}
				}
				
			}
		} else if (ev.getActionCommand().equals(VInicial.BTN_CLIENTE)) {
			vi.dispose();
			plvc.hacerVisible();
		}
		
	}

}
}