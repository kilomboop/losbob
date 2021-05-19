package dam.pic.model;

public class Empleado {
	private String id_empleado;
	private String contrasenia;
	
	public Empleado(String id_empleado, String contrasenia) {
		this.id_empleado = id_empleado;
		this.contrasenia = contrasenia;
	}

	public String getId_empleado() {
		return id_empleado;
	}

	public String getContrasenia() {
		return contrasenia;
	}

}
