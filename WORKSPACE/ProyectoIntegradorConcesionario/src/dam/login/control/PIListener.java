package dam.login.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dam.login.db.PIPersistencias;
import dam.login.view.PAddVehiculo;
import dam.login.view.PListaVehiculosCli;
import dam.login.view.PLogin;
import dam.login.view.VEmpleado;
import dam.login.view.VInicial;
import dam.pic.model.Coche;
import dam.pic.model.Empleado;

public class PIListener implements ActionListener{
static final int INTENTOS = 3;
	
	private PListaVehiculosCli plvc;
	private int contIntent = 0;
	private VInicial vi;
	private PLogin pli;
	private PIPersistencias modelo;
	private VEmpleado empl;
	private PAddVehiculo pav;
	
	public PIListener(VInicial vi,  PLogin pli, VEmpleado empl, PListaVehiculosCli plvc, PAddVehiculo pav) {
		this.vi = vi;
		this.pli = pli;
		this.empl = empl;
		this.plvc = plvc;
		this.pav = pav;
		
		modelo = new PIPersistencias();
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
			ArrayList<Coche> listaCoches = modelo.selectCoches();
			empl.cargarTabla(listaCoches);
		} else if (ev.getActionCommand().equals(VInicial.BTN_CLIENTE)) {
			vi.dispose();
			plvc.hacerVisible();
			plvc.cargarCmbColores(modelo.selectDistinctColor());
			plvc.cargarCmbCombustible(modelo.selectDistinctCombustible());
			ArrayList<Coche> listaCoches = modelo.selectCoches();
			plvc.cargarTabla(listaCoches);
		} else if (ev.getActionCommand().equals(VEmpleado.BTN_ELIMINAR)){
			String numCoche = empl.getCocheSelect();
			
			if(!numCoche.equals("")) { 
				int opcion = JOptionPane.showConfirmDialog(empl, 
						"Se va a eliminar el coche seleccionado �Desea continuar?",
						"Confirmaci�n de borrado",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);	
				 if(opcion == JOptionPane.YES_OPTION) { 
					 int res = modelo.deleteCoche(numCoche);
					 
					 if(res == 1) { 
						empl.mostrarMsjInfo("El borrado se ha realizado con �xito");
						ArrayList<Coche> listaCoches = modelo.selectCoches();
						empl.cargarTabla(listaCoches);
					 }else { 
						empl.mostrarMsjError("No se podido eliminar el restaurante");
					 }
				 } 
			}
		} else if(ev.getActionCommand().equals(VEmpleado.BTN_ADD)) {
			empl.dispose();
			pav.hacerVisible();
		} else if(ev.getActionCommand().equals(PAddVehiculo.BTN_ANIADIR)) {
			Coche coche = pav.getDatos();
			int res = 0;
			if(coche != null) {
				res = modelo.insertCoche(coche);
				if (res == 1) {  
					pav.mostrarMsjInfo("El coche se ha insertado correctamente");
				} else if (res == -1) {
					pav.mostrarMsjError("No se puede insertar el coche porque ya existe " 
							+ "el id en la base de datos");
				}else{ 
					pav.mostrarMsjError("No se ha podido insertar el coche");

				}
			}
		} else if(ev.getActionCommand().equals(PAddVehiculo.BTN_LIMPIAR)) {
			pav.limpiarComponentes();
		} else if(ev.getActionCommand().equals(PListaVehiculosCli.BTN_APLICAR)) {
			String colorFiltro = plvc.getColorFiltro();
			String transmisionFiltro = plvc.getTransmisionFiltro();
			String combustibleFiltro = plvc.getCombustibleFiltro();
			int precioFiltro = plvc.getPrecioFiltro();
			
			ArrayList<Coche> listaCoches = null;
			
			if(colorFiltro.equals(PListaVehiculosCli.OPT_TODOSCOLOR) && transmisionFiltro.equals("TODAS") 
					&& combustibleFiltro.equals(PListaVehiculosCli.OPT_TODOSCOMB)) {
				listaCoches = modelo.selectCoche(precioFiltro);
			} else if(!colorFiltro.equals(PListaVehiculosCli.OPT_TODOSCOLOR) && !transmisionFiltro.equals("TODAS") 
					&& !combustibleFiltro.equals(PListaVehiculosCli.OPT_TODOSCOMB)) {
				listaCoches = modelo.selectCoche(colorFiltro, transmisionFiltro, combustibleFiltro, precioFiltro);
			} else if(!colorFiltro.equals(PListaVehiculosCli.OPT_TODOSCOLOR) && transmisionFiltro.equals("TODAS") 
					&& combustibleFiltro.equals(PListaVehiculosCli.OPT_TODOSCOMB)) {
				listaCoches = modelo.selectCoche(colorFiltro, precioFiltro);
			} else if(colorFiltro.equals(PListaVehiculosCli.OPT_TODOSCOLOR) && !transmisionFiltro.equals("TODAS") 
					&& combustibleFiltro.equals(PListaVehiculosCli.OPT_TODOSCOMB)) {
				listaCoches = modelo.selectCoche2(transmisionFiltro, precioFiltro);
			} else if(colorFiltro.equals(PListaVehiculosCli.OPT_TODOSCOLOR) && transmisionFiltro.equals("TODAS") 
					&& !combustibleFiltro.equals(PListaVehiculosCli.OPT_TODOSCOMB)) {
				listaCoches = modelo.selectCoche3(combustibleFiltro, precioFiltro);
			} else if(!colorFiltro.equals(PListaVehiculosCli.OPT_TODOSCOLOR) && !transmisionFiltro.equals("TODAS") 
					&& combustibleFiltro.equals(PListaVehiculosCli.OPT_TODOSCOMB)) {
				listaCoches = modelo.selectCoche(colorFiltro, transmisionFiltro, precioFiltro);
			} else if(!colorFiltro.equals(PListaVehiculosCli.OPT_TODOSCOLOR) && transmisionFiltro.equals("TODAS") 
					&& !combustibleFiltro.equals(PListaVehiculosCli.OPT_TODOSCOMB)) {
				listaCoches = modelo.selectCoche2(colorFiltro, combustibleFiltro, precioFiltro);
			} else if(colorFiltro.equals(PListaVehiculosCli.OPT_TODOSCOLOR) && !transmisionFiltro.equals("TODAS") 
					&& !combustibleFiltro.equals(PListaVehiculosCli.OPT_TODOSCOMB)) {
				listaCoches = modelo.selectCoche3(combustibleFiltro, transmisionFiltro, precioFiltro);
			}
			plvc.cargarTabla(listaCoches);
		}
		
	}

}
}
