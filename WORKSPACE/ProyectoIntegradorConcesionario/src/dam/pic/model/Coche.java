package dam.pic.model;

public class Coche {
	private int id; 
	private String marca;
	private String modelo;
	private String color ;
	private int anio ;
	private String extras;
	private String combustible; 
	private int precio;
	private String transmision;
	
	public Coche(int id, String marca, String modelo, String color, int anio, String extras, String combustible,
			int precio, String transmision) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.anio = anio;
		this.extras = extras;
		this.combustible = combustible;
		this.precio = precio;
		this.transmision = transmision;
	}

	public int getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getColor() {
		return color;
	}

	public int getAnio() {
		return anio;
	}

	public String getExtras() {
		return extras;
	}

	public String getCombustible() {
		return combustible;
	}

	public int getPrecio() {
		return precio;
	}

	public String getTransmision() {
		return transmision;
	} 
	
	
	
}
