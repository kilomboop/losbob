package dam.login.main;

import java.awt.EventQueue;

import dam.login.control.PIListener;
import dam.login.view.PListaVehiculosCli;
import dam.login.view.PLogin;
import dam.login.view.VEmpleado;
import dam.login.view.VInicial;

public class InicioPI {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VInicial vi = new VInicial();
				PLogin pli = new PLogin();
				VEmpleado emp = new VEmpleado();
				PListaVehiculosCli plvc = new PListaVehiculosCli();
				
				PIListener listener = new PIListener(vi,pli, emp, plvc);
				
				plvc.setListener(listener);
				vi.setListener(listener);
				pli.setListener(listener);
				
				vi.hacerVisible();
			}
		});
	}
}
