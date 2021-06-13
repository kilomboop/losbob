package dam.login.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import dam.login.db.PIPersistencias;
import dam.login.view.PAddVehiculo;
import dam.login.view.PListaVehiculosCli;
import dam.login.view.PLogin;
import dam.login.view.VConsultaRes;
import dam.login.view.VEmpleado;
import dam.login.view.VInicial;
import dam.login.view.VModificacion;
import dam.login.view.VReserva;
import dam.pic.model.Cliente;
import dam.pic.model.Coche;
import dam.pic.model.Empleado;
import dam.pic.model.Reserva;

public class PIListener implements ActionListener{
static final int INTENTOS = 3;
	
	private PListaVehiculosCli plvc;
	private int contIntent = 0;
	private VInicial vi;
	private PLogin pli;
	private PIPersistencias modelo;
	private VEmpleado empl;
	private PAddVehiculo pav;
	private VModificacion vmod;
	private VReserva vr;
	private VConsultaRes vcr;
	
	public PIListener(VInicial vi,  PLogin pli, VEmpleado empl, PListaVehiculosCli plvc, PAddVehiculo pav, VModificacion vmod , VReserva vr, VConsultaRes vcr) {
		this.vi = vi;
		this.pli = pli;
		this.empl = empl;
		this.plvc = plvc;
		this.pav = pav;
		this.vmod = vmod;
		this.vr = vr;
		this.vcr = vcr;
		
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
							pli.mostrarMsgError("La contraseña no es válida. Te quedan " 
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
						"Se va a eliminar el coche seleccionado ¿Desea continuar?",
						"Confirmación de borrado",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);	
				 if(opcion == JOptionPane.YES_OPTION) { 
					 int res = modelo.deleteCoche(numCoche);
					 
					 if(res == 1) { 
						empl.mostrarMsjInfo("El borrado se ha realizado con éxito");
						ArrayList<Coche> listaCoches = modelo.selectCoches();
						empl.cargarTabla(listaCoches);
					 }else { 
						empl.mostrarMsjError("No se podido eliminar el coche");
					 }
				 } 
			}
		}
		else if(ev.getActionCommand().equals(PListaVehiculosCli.BTN_RESERVA)) {
			plvc.dispose();
			vr.setVisible(true);
			ArrayList<Coche> listaCoches = modelo.selectCoches();
			vr.cargarTabla(listaCoches);
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
		}else if(ev.getActionCommand().equals(VModificacion.BTN_BUSCAR)) {
			int id = vmod.getId();
			Coche coche = modelo.selectCocheId(id);
			
			if (coche != null) { 
				vmod.cargarDatos(coche);
			}else { 
				vmod.mostrarMsjInfo("El id '" + id + "' no existe en la base de datos");
			}
		}else if(ev.getActionCommand().equals(VModificacion.BTN_GUARDAR)) { 
			Coche coche = vmod.getDatos();
			int res = modelo.updateCoche(coche);
			
			if (res == -1) {
				vmod.mostrarMsjError("El id seleccionado corresponde a otro coche");		
			}else if(res == 1) { 
				vmod.mostrarMsjInfo("La modificacion del coche se ha realizado con exito");
				ArrayList<Coche> listaCoches = modelo.selectCoches();
				empl.cargarTabla(listaCoches);
			}else {
				vmod.mostrarMsjError("No se ha podido realizar la modificacion consulte el problema con la base de datos");
			}
			
		} else if(ev.getActionCommand().equals(VReserva.BTN_HACER_RESERVAN)) {
			Cliente cliente = vr.getDatos();
			int res = 0;
			String numCoche = vr.getCocheSelect();
			if(!numCoche.equals("")) {
				if(cliente != null) {
					res = modelo.insertCliente(cliente);
					if (res == 1) {  
						String dni = vr.getDni();
						String modeloCoche = vr.getModelo();
						String id_coche = modelo.getIdCoche(modeloCoche);
						int res2 = modelo.insertReserva(id_coche, dni);
						
						if (res2 == 1) {  
							vr.mostrarMsjInfo("Reserva realizada correctamente.");
						}else { 
							vr.mostrarMsjError("No se ha podido realizar la reserva.");

						}
					} else if (res == -1) {
						vr.mostrarMsjError("No se puede insertar el cliente porque ya existe " 
								+ "el dni en la base de datos.");
					}else{ 
						vr.mostrarMsjError("No se ha podido insertar el cliente.");

					}
				}
			}
		} else if(ev.getActionCommand().equals(VReserva.BTN_HACER_RESERVAE)) {
			String dni = vr.getDni();
			String modeloCoche = vr.getModelo();
			String id_coche = modelo.getIdCoche(modeloCoche);
			int res2 = modelo.insertReserva(id_coche, dni);
			
			if (res2 == 1) {  
				vr.mostrarMsjInfo("Reserva realizada correctamente.");
			}else { 
				vr.mostrarMsjError("No se ha podido realizar la reserva.");

			}
		} else if(ev.getActionCommand().equals(VConsultaRes.BTN_VOLVER)) {
			vcr.dispose();
			empl.setVisible(true);
		} else if(ev.getActionCommand().equals(VModificacion.BTN_LIMPIAR)) {
			vmod.dispose();
			empl.setVisible(true);
		}
	}else if(ev.getSource() instanceof JMenuItem) {
		if(ev.getActionCommand().equals(VEmpleado.MNTM_MODVEHICULOS)) { 
			empl.dispose();
			vmod.hacerVisible();
		} else if(ev.getActionCommand().equals(VEmpleado.MNTM_CORESERVA)) {
			empl.dispose();
			vcr.setVisible(true);
			
			ArrayList<Reserva> listaReservas = modelo.selectReserva();
			vcr.cargarTabla(listaReservas);
		}
	}
		

}
}
