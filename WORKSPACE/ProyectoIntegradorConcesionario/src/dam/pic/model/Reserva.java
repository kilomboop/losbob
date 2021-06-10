package dam.pic.model;

public class Reserva {
	private String dni;
	private String id_coche;
	private String id_reserva;
	private String fecha;

	public Reserva(String dni, String id_coche, String id_reserva, String fecha) {
		this.dni = dni;
		this.id_coche = id_coche;
		this.id_reserva = id_reserva;
		this.fecha = fecha;
	}

	public Reserva(String dni, String id_coche) {
		this.dni = dni;
		this.id_coche = id_coche;
	}

	public String getDni() {
		return dni;
	}

	public String getId_coche() {
		return id_coche;
	}

	public String getId_reserva() {
		return id_reserva;
	}

	public String getFecha() {
		return fecha;
	}
	
	
}
