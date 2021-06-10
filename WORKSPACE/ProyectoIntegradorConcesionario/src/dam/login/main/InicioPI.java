package dam.login.main;

import java.awt.EventQueue;

import dam.login.control.PIListener;
import dam.login.view.PAddVehiculo;
import dam.login.view.PListaVehiculosCli;
import dam.login.view.PLogin;
import dam.login.view.VConsultaRes;
import dam.login.view.VEmpleado;
import dam.login.view.VInicial;
import dam.login.view.VModificacion;
import dam.login.view.VReserva;

public class InicioPI {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VInicial vi = new VInicial();
				PLogin pli = new PLogin();
				VEmpleado emp = new VEmpleado();
				PListaVehiculosCli plvc = new PListaVehiculosCli();
				PAddVehiculo pav = new PAddVehiculo();
				VModificacion vmod = new VModificacion();
				VReserva vr = new VReserva();
				VConsultaRes vcr = new VConsultaRes();
				
				PIListener listener = new PIListener(vi,pli, emp, plvc, pav,vmod, vr, vcr);
				
				plvc.setListener(listener);
				vi.setListener(listener);
				pli.setListener(listener);
				emp.setListener(listener);
				pav.setListener(listener);
				vmod.setListener(listener);
				vr.setListener(listener);
				vcr.setListener(listener);
				
				vi.hacerVisible();
			}
		});
	}
}
