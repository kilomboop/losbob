package dam.pic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccesoBD {
	
	static final String DRIVER = "org.sqlite.JDBC";
	static final String URL = "jdbc:sqlite:dbSQlite/ProyectoIntegrador.db";
	
	private String driver;
	private String url;
	
	public AccesoBD() {
		
		driver = DRIVER;
		url = URL;
	}
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		System.out.println("Conexi�n establecida con la BBDD");
		return con;
	}
	
}
