package dam.pic.main;

import java.awt.EventQueue;

import dam.pic.control.PIListener;
import dam.pic.view.PListaVehiculosCli;
import dam.pic.view.VInicial;

public class Inicio {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VInicial vi = new VInicial();
				PListaVehiculosCli plvc = new PListaVehiculosCli();
				
				PIListener listener = new PIListener(vi, plvc);
				
				vi.setListener(listener);
				
				vi.hacerVisible();
			}
		});
	}
}
