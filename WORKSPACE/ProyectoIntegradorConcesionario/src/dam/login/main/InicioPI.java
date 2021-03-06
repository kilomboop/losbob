package dam.login.main;

import java.awt.EventQueue;

import dam.login.control.PIListener;
import dam.login.view.PLogin;
import dam.login.view.VContenedor;
import dam.login.view.VInicial;

public class InicioPI {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VInicial vi = new VInicial();
				VContenedor vc = new VContenedor();
				PLogin pli = new PLogin();
				
				PIListener listener = new PIListener(vi, vc, pli);
				
				vi.setListener(listener);
				pli.setListener(listener);
				
				vi.hacerVisible();
			}
		});
	}
}
