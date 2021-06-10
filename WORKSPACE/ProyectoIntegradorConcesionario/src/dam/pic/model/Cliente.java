package dam.pic.model;

public class Cliente {
	private String dni;
	private String apenom;
	private String direccion;
	private String telefono;
	
	public Cliente(String dni, String apenom, String direccion, String telefono) {
		this.dni = dni;
		this.apenom = apenom;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public String getApenom() {
		return apenom;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}
	
}
