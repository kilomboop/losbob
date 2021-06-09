package dam.pic.model;

public class Reserva {
	private int id_reserva;
	private Cliente cliente;
	private Coche coche;
	private String fecha;
	
	public Reserva(int id_reserva, Cliente dni, Coche id_coche, String fecha) {
		this.id_reserva = id_reserva;
		this.cliente = dni;
		this.coche = id_coche;
		this.fecha = fecha;
	}
}
